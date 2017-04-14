/**
 * 
 */
package com.fuhj.itower.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.log.AppLogger;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.weixin.WebWX;
import com.fuhj.weixin.WebWXService;
import com.fuhj.weixin.json.ContactItem;

/**
 * @Description: 定时查询千寻公司
 * @author fu
 * @date 2017-3-6
 */
public class QueryItowerQianXun {
	private static final String CONFIG_FILENAME = "queryItowerQX_config.xml";
	private StationService stationService;
	private ItowerImpl itower = null;
	private TaskReader taskReader = new TaskReader();

	public void execute() {
		AppLogger.sysDebug("QueryItowerQianXun execute()");
		if (SpringUtil.getWebAppPath() == null) {
			return;
		}
		List<ConfigTask> taskList = taskReader.getDZConfigTasks(CONFIG_FILENAME);
		itower = new ItowerImpl();
		stationService = SpringUtil.getBean(StationService.class);
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
				try {
					List<ItStation> qx_stations = stationService.getQXStations(task.getRange(), null, null, "千寻公司");
					Map<String, ItStation> qx_stations_map = new HashMap<String, ItStation>();
					for (ItStation itst : qx_stations) {
						qx_stations_map.put(itst.getStationCode(), itst);
					}
					AppLogger.sysDebug("千寻站址数量：" + qx_stations.size());

					List<AlarmModel> qx_td_list = new ArrayList<AlarmModel>();
					List<AlarmModel> qx_dz_list = new ArrayList<AlarmModel>();
					List<AlarmModel> qx_fsu_list = new ArrayList<AlarmModel>();

					List<AlarmModel> alarm_td = itower.queryItowerAlarm(task.getRange(), ItowerImpl.ALARM_TD);
					for (AlarmModel am : alarm_td) {
						if (qx_stations_map.keySet().contains(am.getStationcode())) {
							qx_td_list.add(am);
						}
					}
					AppLogger.sysDebug("停电告警总数：" + alarm_td.size() + ",千寻站址停电告警：" + qx_td_list.size());
					List<AlarmModel> alarm_dz = itower.queryItowerAlarm(task.getRange(), ItowerImpl.ALARM_DZTF);
					for (AlarmModel am : alarm_dz) {
						if (qx_stations_map.keySet().contains(am.getStationcode())) {
							qx_dz_list.add(am);
						}
					}

					AppLogger.sysDebug("断站/退服告警总数：" + alarm_dz.size() + ",千寻站址断站/退服告警：" + qx_dz_list.size());

					List<AlarmModel> alarm_fsu = itower.queryItowerAlarm(task.getRange(), ItowerImpl.ALARM_FSU);
					for (AlarmModel am : alarm_fsu) {
						if (qx_stations_map.keySet().contains(am.getStationcode())) {
							qx_fsu_list.add(am);
						}
					}
					AppLogger.sysDebug("FSU离线告警总数：" + alarm_fsu.size() + ",千寻站址FSU离线告警：" + qx_fsu_list.size());

					if (qx_td_list.size() + qx_dz_list.size() + qx_fsu_list.size() > 0) {
						AlarmComparator ac = new AlarmComparator();
						StringBuffer sb = new StringBuffer();
						sb.append("【千寻站址运监告警情况】").append("\n");
						sb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
						if (qx_td_list.size() > 0) {
							sb.append("【停电告警】").append("\n");
							Collections.sort(qx_td_list, ac);
							for (int i = 0; i < qx_td_list.size(); i++) {
								AlarmModel am = qx_td_list.get(i);
								sb.append(String.valueOf(i + 1)).append(".")
										.append(am.getStationname()).append(" ")
										.append("历时").append(am.getAlarmduration()).append(" ")
										.append("\n");
							}
						}
						if (qx_dz_list.size() > 0) {
							sb.append("【断站/退服告警】").append("\n");
							Collections.sort(qx_dz_list, ac);
							for (int i = 0; i < qx_dz_list.size(); i++) {
								AlarmModel am = qx_dz_list.get(i);
								sb.append(String.valueOf(i + 1)).append(".")
										.append(am.getStationname()).append(" ")
										.append("历时").append(am.getAlarmduration()).append(" ")
										.append("\n");
							}
						}
						if (qx_fsu_list.size() > 0) {
							sb.append("【FSU离线告警】").append("\n");
							Collections.sort(qx_fsu_list, ac);
							for (int i = 0; i < qx_fsu_list.size(); i++) {
								AlarmModel am = qx_fsu_list.get(i);
								sb.append(String.valueOf(i + 1)).append(".")
										.append(am.getStationname()).append(" ")
										.append("历时").append(am.getAlarmduration()).append(" ")
										.append("\n");
							}
						}
						ContactItem cItem = webwx.getFullContactNickNameMap().get(task.getChatRoomName());
						if (cItem == null) {
							webwx.getFullContact();
							cItem = webwx.getFullContactNickNameMap().get(task.getChatRoomName());
							if (cItem != null) {
								webwx.sendTxtMsg(cItem.getUserName(), sb.toString());
							}
						} else {
							webwx.sendTxtMsg(cItem.getUserName(), sb.toString());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	class AlarmComparator implements Comparator<AlarmModel> {
		@Override
		public int compare(AlarmModel o1, AlarmModel o2) {
			return (o1.getAlarmduration() - o2.getAlarmduration()) * -1;
		}
	}
}
