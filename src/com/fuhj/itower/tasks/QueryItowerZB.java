/**
 * 
 */
package com.fuhj.itower.tasks;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.log.AppLogger;
import com.fuhj.util.SpringUtil;
import com.fuhj.weixin.WebWX;
import com.fuhj.weixin.WebWXService;
import com.fuhj.weixin.WebWXService.ZbzData;
import com.fuhj.weixin.json.ContactItem;

/**
 * @Description: 定时查询重保站
 * @author fu
 * @date 2016-8-16
 */
public class QueryItowerZB {
	private static final String CONFIG_FILENAME = "queryItowerZB_config.xml";
	private LocationService locationService = null;
	private ItowerImpl itower = null;
	private TaskReader taskReader = new TaskReader();

	public void execute() {
		AppLogger.sysDebug("QueryItowerZB execute()");
		if (SpringUtil.getWebAppPath() == null) {
			return;
		}
		List<ConfigTask> taskList = taskReader.getDZConfigTasks(CONFIG_FILENAME);
		itower = new ItowerImpl();
		locationService = SpringUtil.getBean(LocationService.class);
		String cookieValue = MyProperties.getValueByKey(MyProperties.COOKIEFILE, "Cookie");
		if (StringUtils.isNotEmpty(cookieValue) && itower.hasLogin(cookieValue)) {
			for (ConfigTask dzt : taskList) {
				process(dzt);
			}
		}
	}

	public void process(ConfigTask task) {
		WebWXService webWXservice = WebWXService.getInstance();
		if (webWXservice != null && webWXservice.isWebwxStart()) {
			WebWX webwx = webWXservice.getWebwx();
			if (webwx.isInitCompleted()) {
				ITCity city = locationService.getCityById(task.getRange());
				ZbzData data = webWXservice.selfServiceZBZ(city.getCname());
				if (data.getSumCount() > 0) {
					// 群聊必须保存在微信通讯录中
					ContactItem cItem = webwx.getFullContactNickNameMap().get(task.getChatRoomName());
					try {
						if (cItem == null) {
							webwx.getFullContact();
							cItem = webwx.getFullContactNickNameMap().get(task.getChatRoomName());
							if (cItem != null) {
								webwx.sendTxtMsg(cItem.getUserName(), data.getText());
							}
						} else {
							webwx.sendTxtMsg(cItem.getUserName(), data.getText());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
