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
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.log.AppLogger;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;
import com.fuhj.weixin.WebWX;
import com.fuhj.weixin.WebWXService;
import com.fuhj.weixin.json.ContactItem;

/**
 * @Description: 定时查询断站
 * @author fu
 * @date 2016-7-21
 */
public class QueryItowerDZ {
	private static final String CONFIG_FILENAME = "queryItowerDZ_config.xml";
	// @Getter private static List<String> inHandDZList = new CopyOnWriteArrayList<String>();
	// @Getter private static List<String> currentDZList = new ArrayList<String>();

	@Getter
	private static Map<String, List<String>> inHandDZMap = new HashMap<String, List<String>>();
	@Getter
	private static Map<String, List<String>> currentDZMap = new HashMap<String, List<String>>();
	private StationService stationService = null;
	private LocationService locationService = null;
	private ItowerImpl itower = null;
	private TaskReader taskReader = new TaskReader();

	public void execute() {
		AppLogger.sysDebug("QueryItowerDZ execute()");
		if (SpringUtil.getWebAppPath() == null) {
			return;
		}
		List<ConfigTask> taskList = taskReader.getDZConfigTasks(CONFIG_FILENAME);
		for (ConfigTask taskConfig : taskList) {
			if (inHandDZMap.get(taskConfig.getChatRoomName()) == null) {
				inHandDZMap.put(taskConfig.getChatRoomName(), new CopyOnWriteArrayList<String>());
			}
			if (currentDZMap.get(taskConfig.getChatRoomName()) == null) {
				currentDZMap.put(taskConfig.getChatRoomName(), new ArrayList<String>());
			}
		}
		itower = new ItowerImpl();
		stationService = SpringUtil.getBean(StationService.class);
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
				try {
					List<AlarmModel> dzList = itower.queryItowerAlarm(task.getRange(), ItowerImpl.ALARM_DZTF);

					if (dzList != null && dzList.size() > 0) {
						List<String> inHandDZList = inHandDZMap.get(task.getChatRoomName());
						List<String> currentDZList = currentDZMap.get(task.getChatRoomName());
						List<String> sumInHandList = getSumInHandList();
						List<String> sidList = new ArrayList<String>(dzList.size());
						for (AlarmModel model : dzList) {
							sidList.add(model.getStationcode());
						}
						Map<String, StationModel> map = stationService.queryStaSBySCode(sidList);
						for (AlarmModel am : dzList) {
							StationModel dbStmodel = map.get(am.getStationcode());
							if (dbStmodel != null) {
								am.setCity(dbStmodel.getCity());
								am.setDistrict(dbStmodel.getDistrict());
								am.setItProvinceId(dbStmodel.getItProvinceId());
								am.setItCityId(dbStmodel.getItCityId());
								am.setItDistrictId(dbStmodel.getItDistrictId());
								if (!am.getStationname().equals(dbStmodel.getStationName())) {
									AppLogger.sysDebug("update station:" + dbStmodel.getItStationId());
									stationService.updateStaName(dbStmodel.getItStationId(), am.getStationname());
								}
							} else {
								ItStation site = itower.getStationByCode(task.getRange(), am.getStationcode());
								if (site != null) {
									am.setItProvinceId(site.getItProvinceId());
									am.setItCityId(site.getItCityId());
									am.setItDistrictId(site.getItDistrictId());
									stationService.addStation(site);
								}
							}
							am.setCity(StringUtils.isNotEmpty(am.getCity()) ? am.getCity() : locationService.getCityById(am.getItCityId())
									.getCname());
							am.setDistrict(StringUtils.isNotEmpty(am.getDistrict()) ? am.getDistrict() : locationService.getDistrictById(
									am.getItDistrictId()).getDname());
						}
						Collections.sort(dzList, new DZListComparator());
						StringBuffer sb = new StringBuffer();
						sb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
						sb.append("【退服告警督办】").append("\n");
						currentDZList.clear();
						for (int i = 0; i < dzList.size(); i++) {
							AlarmModel am = dzList.get(i);
							sb.append(String.valueOf(i + 1)).append(".")
									.append(am.getCity()).append(" ")
									.append(am.getStationname()).append(" ")
									.append("历时").append(am.getAlarmduration()).append(" ")
									.append(sumInHandList.contains(am.getStationname()) ? "(已督办)" : "(待响应)")
									.append("\n");
							currentDZList.add(am.getStationname());
						}
						if (sb.length() > 0 && sb.substring(sb.length() - 1, sb.length()).equals("\n")) {
							sb.deleteCharAt(sb.length() - 1);
						}
						for (String s : inHandDZList) {
							if (!currentDZList.contains(s)) {
								inHandDZList.remove(s);
							}
						}
						// 群聊必须保存在微信通讯录中
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

	@SuppressWarnings("unchecked")
	public static List<String> getSumInHandList() {
		List<String> sumInHandList = new ArrayList<String>();
		for (List<String> list : inHandDZMap.values()) {
			sumInHandList = (List<String>) CollectionUtils.union(sumInHandList, list);
		}
		return sumInHandList;
	}

	class DZListComparator implements Comparator<AlarmModel> {
		@Override
		public int compare(AlarmModel o1, AlarmModel o2) {
			if (o1.getItCityId().compareTo(o2.getItCityId()) != 0) {
				return o1.getItCityId().compareTo(o2.getItCityId());
			} else {
				return (o1.getAlarmduration() - o2.getAlarmduration()) * -1;
			}
		}
	}
}
