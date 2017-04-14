/**
 * 
 */
package com.fuhj.weixin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.api.APIService;
import com.fuhj.itower.api.ItowerImpl;
import com.fuhj.itower.model.FSUCondItem;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.model.ZbzItem;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.service.model.AlarmJson;
import com.fuhj.itower.ui.model.AlarmComparator;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.itower.ui.model.FSUMonitorModel;
import com.fuhj.itower.ui.model.MonitorMapBean;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.itower.ui.model.TDSiteVoltage;
import com.fuhj.log.AppLogger;
import com.fuhj.util.FormatUtil;
import com.fuhj.util.SpringUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-24
 */
public class WebWXService implements IReplyService {
	public final String TIMEOUT_TEXT = "查询超时，请稍后重试。";
	private static WebWXService instance = new WebWXService();
	@Getter
	final private WebWX webwx = new WebWX();
	private WxTask task;
	private final TuRingBot trBot = new TuRingBot();
	private ExecutorService service = null;
	private IUICallBack uiCallback;
	private LocationService locationService;

	private StationService stationService;
	private APIService apiService;
	private final ItowerImpl itower = new ItowerImpl();

	private WebWXService() {
		locationService = SpringUtil.getBean(LocationService.class);
		apiService = SpringUtil.getBean(APIService.class);
		stationService = SpringUtil.getBean(StationService.class);
	}

	public static WebWXService getInstance() {
		return instance;
	}

	public BufferedImage getQRCode() throws Exception {
		webwx.getLoginUUID();
		return webwx.getQRCode();
	}

	public void startWebwx() {
		if (service == null || service.isTerminated()) {
			service = Executors.newSingleThreadExecutor();
			task = new WxTask(webwx, instance, uiCallback);
			service.execute(task);
			service.shutdown();
		} else {

		}
	}

	public void stopWebwx() {
		if (service != null && !service.isTerminated()) {
			service.shutdownNow();
		}
	}

	public boolean isWebwxStart() {
		return service != null && !service.isTerminated();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.weixin.IReplyService#localService()
	 */
	@Override
	public String localService(String content, String fromId, int type) throws ServiceException {
		String reply = "";
		switch (type) {
		case 1:
			reply = selfServiceTD(content);
			break;
		case 2:
			reply = selfServiceBZ(content);
			break;
		case 3:
			reply = selfServiceFSU(content);
			break;
		case 4:
			reply = selfServiceDZ(content);
			break;
		case 5:
			reply = selfServiceTDCount(content);
			break;
		case 6:
			reply = selfServiceZBZ(content).getText();
			break;
		}
		return reply;
	}

	public String help() {
		String str = "指令说明：\n1.【精准发电】，指令为\"V区域名\"或\"电压区域名\"，可查询区域内当前停电站点电压(开关电源实时电压)情况，并与代维开始发电进行自动关联，杜绝拉闸虚假发电现象；\n2.【应急保障】，指令为\"BZ区域名\"或\"保障区域名\"，可查询区域内当前停电、欠压、退服、网管数据异常站点情况，在应急通信保障，可快速、精准提供批量网管数据；\n3.【FSU离线】，指令为\"LX区域名\"，可查询区域内当前FSU离线情况，反映当前网管脱网离线情况；\n4.【退服站点】，指令为\"T区域名\"，可查询区域内当前退服情况；\n5.【停电统计】，指令为\"停电统计区域名\"，可查询全省或地市停电告警数量。\n6.【重保督办】，指令为\"ZB市/区县\"，可对(在后台)已配置重保站点定点查询停电、欠压、退服、离线情况。\nPS:指令大小写都可以";
		return str;
	}

	public String invalidService() {
		return "因总部查询频次限制，当前全省账号已不能支撑所有地市批量操作，如有需求请加机器人好友进行沟通，谢谢合作。";
	}

	public String selfServiceTDCount(String content) {
		if (content.endsWith("省")) {
			content = content.substring(0, content.length() - 1);
		}
		String provinceId = locationService.getProvinceIdByFullName(content);
		return selfServiceTDCount(provinceId, content);
	}

	public String selfServiceTDCount(String provinceId, String content) {
		String reply = "";
		StringBuffer replysb = new StringBuffer();
		try {
			replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
			if (StringUtils.isNotEmpty(provinceId)) {
				replysb.append(content).append("各地市停电告警统计：\n");
				final Map<String, Integer> countMap = new HashMap<String, Integer>();
				for (final ITCity city : locationService.findAllCityByProvinceId(provinceId)) {
					int count = itower.queryItowerAlarmCount(city.getItCityId(), ItowerImpl.ALARM_TD);
					countMap.put(city.getItCityId(), count);
				}
				int sum = 0;
				Map<String, Integer> tempMap = sortMapByValue(countMap);
				for (Entry<String, Integer> e : tempMap.entrySet()) {
					sum += e.getValue();
					replysb.append(locationService.getCityById(e.getKey()).getCname()).append("分公司").append("：").append(e.getValue()).append("\n");
				}
				replysb.append(content).append("合计共停电").append(sum).append("个。");
				reply = replysb.toString();
			} else {

				String parsedStr = rangeParse(content);
				if (StringUtils.isNotEmpty(parsedStr)) {
					int count = itower.queryItowerAlarmCount(parsedStr, ItowerImpl.ALARM_TD);
					replysb.append(content).append("合计共停电").append(count).append("个。");
					reply = replysb.toString();
				}
				// else {
				// reply = "不支持的城市或地区";
				// }
			}
		} catch (ServiceException e) {
			reply = TIMEOUT_TEXT;
			itower.autoLogin();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		return reply;
	}

	// private static final ThreadLocal<AlarmJson> sstd_json1 = new
	// ThreadLocal<AlarmJson>();
	// private static final ThreadLocal<AlarmJson> sstd_json2 = new
	// ThreadLocal<AlarmJson>();

	@SuppressWarnings("unchecked")
	public String selfServiceTD(String content) {
		String reply = "";
		try {
			String parsedStr = rangeParse(content);
			if (StringUtils.isNotEmpty(parsedStr)) {
				// sstd_json1.set(apiService.queryPFAlarm("1", parsedStr,
				// "false"));
				// AlarmJson json = sstd_json1.get();
				AlarmJson json = apiService.queryPFAlarm("1", parsedStr, "false");
				if (json != null) {
					JSONArray jarray = json.getList();
					StringBuffer replysb = new StringBuffer();
					replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
					if (jarray != null && jarray.size() > 0) {
						replysb.append(content).append("【停电站点】" + jarray.size() + "个：").append("\n");
						for (Iterator<JSONObject> jarrayit = jarray.iterator(); jarrayit.hasNext();) {
							JSONObject obj = jarrayit.next();
							replysb.append(obj.get("index")).append(".").append(obj.get("stationname")).append(" ").append(obj.get("voltage")).append(" ").append("历时").append(obj.get("alarmduration"))
									.append("\n");
						}
						if (replysb.length() > 0 && replysb.substring(replysb.length() - 1, replysb.length()).equals("\n")) {
							replysb.deleteCharAt(replysb.length() - 1);
						}
					} else {
						replysb.append(content).append("无停电告警信息");
					}
					reply = replysb.toString();
				}
			}
			// else {
			// reply = "不支持的城市或地区";
			// }
		} catch (ServiceException e) {
			reply = TIMEOUT_TEXT;
			itower.autoLogin();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		return reply;
	}

	public FSUCondItem getFSUCondByDistrict(final String districtId) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		final FSUCondItem fsuItem = new FSUCondItem();
		pool.execute(new Runnable() {

			@Override
			public void run() {
				AlarmJson json = apiService.queryPFAlarm("1", districtId, "true");
				if (json != null) {
					int qyCount = 0, errorCount = 0;
					JSONArray jarray = json.getList();
					if (jarray != null) {
						fsuItem.setTdcount(jarray.size());
						Map<String, TDSiteVoltage> tdvMap = itower.queryTDsiteV(districtId);
						for (@SuppressWarnings("unchecked")
						Iterator<JSONObject> jarrayit = jarray.iterator(); jarrayit.hasNext();) {
							JSONObject obj = jarrayit.next();
							String siteCode = obj.getString("stationcode");
							try {
								TDSiteVoltage tdv = tdvMap.get(siteCode);
								float f = 0f;
								if (tdv != null) {
									f = Float.parseFloat(tdv.getVoltage());
								} else {
									String did = "";
									String provinceId = "";
									StationModel dbStmodel = stationService.queryStaSBySCode(siteCode);
									if (dbStmodel != null) {
										did = dbStmodel.getBatteryId();
										provinceId = dbStmodel.getItProvinceId();
										if (!obj.getString("stationname").equals(dbStmodel.getStationName())) {
											AppLogger.sysDebug("update station:" + dbStmodel.getItStationId());
											stationService.updateStaName(dbStmodel.getItStationId(), obj.getString("stationname"));
										}
									} else {
										ItStation site = itower.getStationByCode(districtId, siteCode);
										if (site != null) {
											provinceId = site.getItProvinceId();
											stationService.addStation(site);
										}
										StaAgtStaff sas = itower.getStaAgtStaffByCode(districtId, siteCode);
										if (sas != null) {
											stationService.addStaAgtStaff(sas);
										}
									}
									String voltage = itower.queryVoltageRT(provinceId, districtId, obj.getString("stationid"), siteCode, did);
									f = Float.parseFloat(voltage);
								}
								if (f < 48) {
									qyCount++;
								}
							} catch (NumberFormatException e) {
								errorCount++;
							}
						}
						fsuItem.setVlowcount(qyCount);
					}
				}
			}
		});
		pool.execute(new Runnable() {

			@Override
			public void run() {
				List<AlarmModel> dzList = itower.queryItowerAlarm(districtId, ItowerImpl.ALARM_DZTF);
				fsuItem.setDzcount(dzList.size());
			}
		});
		pool.execute(new Runnable() {

			@Override
			public void run() {
				List<FSUMonitorModel> fsuofflineList = itower.listFSUOffline(districtId);
				fsuItem.setOfflinecount(fsuofflineList.size());
			}
		});
		pool.shutdown();
		while (true) {
			if (pool.isTerminated()) {
				return fsuItem;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public List<FSUCondItem> selfServiceBZ_IMG(boolean sumProvince, String content) {
		List<FSUCondItem> list = new ArrayList<FSUCondItem>();
		if (sumProvince) {
			String range = "0001928";
			for (final ITCity city : locationService.findAllCityByProvinceId(range)) {
				FSUCondItem fsuItem = new FSUCondItem();
				fsuItem.setAreaname(city.getCname());
				fsuItem.setItcityid(city.getItCityId());
				fsuItem.setItprovinceid(city.getItProvinceId());

				AlarmJson json = apiService.queryPFAlarm("1", city.getItCityId(), "true");
				if (json != null) {
					int qyCount = 0, errorCount = 0;
					JSONArray jarray = json.getList();
					if (jarray != null) {
						fsuItem.setTdcount(jarray.size());
						Map<String, TDSiteVoltage> tdvMap = itower.queryTDsiteV(city.getItCityId());
						for (@SuppressWarnings("unchecked")
						Iterator<JSONObject> jarrayit = jarray.iterator(); jarrayit.hasNext();) {
							JSONObject obj = jarrayit.next();
							String siteCode = obj.getString("stationcode");
							try {
								TDSiteVoltage tdv = tdvMap.get(siteCode);
								float f = 0f;
								if (tdv != null) {
									f = Float.parseFloat(tdv.getVoltage());
								} else {
									String did = "";
									StationModel dbStmodel = stationService.queryStaSBySCode(siteCode);
									if (dbStmodel != null) {
										did = dbStmodel.getBatteryId();
									} else {
										ItStation site = itower.getStationByCode(range, siteCode);
										if (site != null) {
											stationService.addStation(site);
										}
										StaAgtStaff sas = itower.getStaAgtStaffByCode(range, siteCode);
										if (sas != null) {
											stationService.addStaAgtStaff(sas);
										}
									}
									String voltage = itower.queryVoltageRT(range, city.getItCityId(), obj.getString("stationid"), siteCode, did);
									f = Float.parseFloat(voltage);
								}
								if (f < 48) {
									qyCount++;
								}
							} catch (NumberFormatException e) {
								errorCount++;
							}
						}
						fsuItem.setVlowcount(qyCount);
					}
				}

				List<AlarmModel> dzList = itower.queryItowerAlarm(city.getItCityId(), ItowerImpl.ALARM_DZTF);
				fsuItem.setDzcount(dzList.size());
				List<FSUMonitorModel> fsuofflineList = itower.listFSUOffline(city.getItCityId());
				fsuItem.setOfflinecount(fsuofflineList.size());
				list.add(fsuItem);
			}
		} else {
			String[] rangeArray = content.trim().split("\\s+");
			if (rangeArray.length == 1) {
				String city_id = locationService.getCityIdByName(content);

				if (city_id != null) {
					List<ITDistrict> districtList = locationService.findAllDistrictByCityId(city_id);
					for (final ITDistrict itdis : districtList) {
						FSUCondItem fsuItem = getFSUCondByDistrict(itdis.getItDistrictId());
						fsuItem.setAreaname(itdis.getDshortname());
						fsuItem.setItcityid(city_id);
						fsuItem.setItdistrictid(itdis.getItDistrictId());
						list.add(fsuItem);
					}
				}
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public String selfServiceBZ(String provinceId, String content) {
		String reply = "";
		if (StringUtils.isNotEmpty(provinceId)) {
			StringBuffer replysb = new StringBuffer();
			replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
			Map<String, Integer> tempMap = new HashMap<String, Integer>();
			for (final ITCity city : locationService.findAllCityByProvinceId(provinceId)) {
				int count = itower.queryItowerAlarmCount(city.getItCityId(), ItowerImpl.ALARM_TD);
				tempMap.put(city.getItCityId(), count);
			}
			MonitorMapBean bean = itower.queryMonitorMap();
			int sum = 0;
			Map<String, Integer> bigTDMap = new HashMap<String, Integer>();
			for (Entry<String, Integer> e : tempMap.entrySet()) {
				sum += e.getValue();
				if (e.getValue() >= 100) {
					bigTDMap.put(e.getKey(), e.getValue());
				}
			}
			replysb.append(content).append("共停电").append(sum).append("个");
			if (bigTDMap.size() > 0) {
				replysb.append("（");
				for (Entry<String, Integer> e : bigTDMap.entrySet()) {
					replysb.append(locationService.getCityById(e.getKey()).getCname()).append("：").append(e.getValue()).append("个，");
				}
				replysb.deleteCharAt((replysb.length() - 1));
				replysb.append("）");
			}
			replysb.append("，");
			if (bean != null) {
				// replysb.append("一脱告警" + bean.getDzAlarm() + "条，FSU离线站点" +
				// (bean.getDeliveredStation() - bean.getFsuOnline()) + "个。");
				replysb.append("一脱告警" + bean.getDzAlarm() + "条。");
			}
			reply = replysb.toString();
		} else {
			try {
				String parsedStr = rangeParse(content);
				if (StringUtils.isNotEmpty(parsedStr)) {
					// sstd_json2.set(apiService.queryPFAlarm("1", parsedStr,
					// "false"));
					// AlarmJson json = sstd_json2.get();
					AlarmJson json = apiService.queryPFAlarm("1", parsedStr, "false");
					List<AlarmModel> dzList = itower.queryItowerAlarm(parsedStr, ItowerImpl.ALARM_DZTF);
					if (json != null) {
						JSONArray jarray = json.getList();
						StringBuffer replysb = new StringBuffer();
						replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
						int tdCount = 0, qyCount = 0, errorCount = 0;
						List<JSONObject> qyObjList = new ArrayList<JSONObject>();
						List<JSONObject> errorObjList = new ArrayList<JSONObject>();

						if (jarray != null) {
							tdCount = jarray.size();
							for (Iterator<JSONObject> jarrayit = jarray.iterator(); jarrayit.hasNext();) {
								JSONObject obj = jarrayit.next();
								try {
									float f = Float.parseFloat(obj.getString("voltage"));
									if (f < 48) {
										qyCount++;
										qyObjList.add(obj);
									}
								} catch (NumberFormatException e) {
									errorCount++;
									errorObjList.add(obj);
								}
							}
						}
						replysb.append(content).append("停电站点").append(tdCount).append("个，其中欠压(<48V)").append(qyCount).append("个，退服").append(dzList.size()).append("个，异常").append(errorCount)
								.append("个。\n");
						if (qyObjList.size() > 0) {
							replysb.append("【欠压站点】：\n");
							for (int i = 0; i < qyObjList.size(); i++) {
								JSONObject obj = qyObjList.get(i);
								replysb.append(String.valueOf(i + 1)).append(".").append(obj.get("stationname")).append(" ").append(obj.get("voltage")).append(" ").append("历时")
										.append(obj.get("alarmduration")).append("\n");
							}
						}
						if (dzList.size() > 0) {
							replysb.append("【退服站点】：\n");
							for (int i = 0; i < dzList.size(); i++) {
								AlarmModel am = dzList.get(i);
								replysb.append(String.valueOf(i + 1)).append(".").append(am.getStationname()).append(" ").append("历时").append(am.getAlarmduration()).append("\n");
							}
						}
						if (errorObjList.size() > 0) {
							replysb.append("【异常站点】：\n");
							for (int i = 0; i < errorObjList.size(); i++) {
								JSONObject obj = errorObjList.get(i);
								replysb.append(String.valueOf(i + 1)).append(".").append(obj.get("stationname")).append(" ").append(obj.get("voltage")).append(" ").append("历时")
										.append(obj.get("alarmduration")).append("\n");
							}
						}
						if (replysb.length() > 0 && replysb.substring(replysb.length() - 1, replysb.length()).equals("\n")) {
							replysb.deleteCharAt(replysb.length() - 1);
						}
						reply = replysb.toString();
					}
				}
				// else {
				// reply = "不支持的城市或地区";
				// }
			} catch (ServiceException e) {
				reply = TIMEOUT_TEXT;
				itower.autoLogin();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		return reply;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class ZbzData {
		private int sumCount;
		private String text;
	}

	@SuppressWarnings("unchecked")
	public ZbzData selfServiceZBZ(String content) {
		ZbzData zbzData = null;
		String range = "";
		Map<String, ZbzItem> zbzMap = null;

		if (content.matches("湖南|湖南省")) {
			return new ZbzData(-1, "非常抱歉，目前只能查询地市或者区县重保站状态。");
		}
		String provinceId = "";
		ITCity city = locationService.getCityByName(content);
		if (city != null) {
			range = city.getItCityId();
			zbzMap = stationService.getZbzItemsMap(null, range, null);
			provinceId = city.getItProvinceId();
		} else {
			ITDistrict district = locationService.getDistrictByName(content);
			if (district != null) {
				range = district.getItDistrictId();
				zbzMap = stationService.getZbzItemsMap(null, null, range);
				provinceId = district.getItProvinceId();
			}
		}
		final String range_temp = range;
		final ZBZMonitor zbzMonitor = new ZBZMonitor();
		if (zbzMap == null || zbzMap.size() == 0) {
			return new ZbzData(-1, "非常抱歉，" + content + "未配置重保站点。");
		} else {
			zbzData = new ZbzData();
			ExecutorService service = Executors.newFixedThreadPool(3);
			service.execute(new Runnable() {
				@Override
				public void run() {
					zbzMonitor.setFsuList(itower.listFSUOffline(range_temp));
				}
			});
			service.execute(new Runnable() {
				@Override
				public void run() {
					zbzMonitor.setDztfList(itower.queryItowerAlarm(range_temp, ItowerImpl.ALARM_DZTF));
				}
			});
			service.execute(new Runnable() {
				@Override
				public void run() {
					// zbzMonitor.setTdList(itower.queryItowerAlarm(range_temp,
					// ItowerImpl.ALARM_TD));
					AlarmJson json = apiService.queryPFAlarm("1", range_temp, "true");
					if (json != null) {
						zbzMonitor.setTdjsonArray(json.getList());
					}
				}
			});
			service.shutdown();
			List<FSUMonitorModel> zbz_fsuList = new ArrayList<FSUMonitorModel>();
			List<AlarmModel> zbz_dztfList = new ArrayList<AlarmModel>();
			List<JSONObject> zbz_tdList = new ArrayList<JSONObject>();
			List<JSONObject> zbz_tdqyList = new ArrayList<JSONObject>();
			List<JSONObject> zbz_errorOList = new ArrayList<JSONObject>();
			int qyCount = 0, errorCount = 0;
			while (true) {
				if (service.isTerminated()) {
					for (FSUMonitorModel fsumodel : zbzMonitor.getFsuList()) {
						if (zbzMap.containsKey(fsumodel.getStationCode())) {
							zbz_fsuList.add(fsumodel);
						}
					}
					for (AlarmModel dztfAlarm : zbzMonitor.getDztfList()) {
						if (zbzMap.containsKey(dztfAlarm.getStationcode())) {
							zbz_dztfList.add(dztfAlarm);
						}
					}
					// 先查出重保站中停电站点添加至zbz_tdList
					for (Iterator<JSONObject> jarrayit = zbzMonitor.getTdjsonArray().iterator(); jarrayit.hasNext();) {
						JSONObject obj = jarrayit.next();
						String stCode = obj.getString("stationcode");
						if (zbzMap.containsKey(stCode)) {
							zbz_tdList.add(obj);
						}
					}
					break;
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 查询重保站中停电站点的电压
			for (Iterator<JSONObject> jarrayit = zbz_tdList.iterator(); jarrayit.hasNext();) {
				float f = 0f;
				JSONObject obj = jarrayit.next();
				String stCode = obj.getString("stationcode");
				String stId = obj.getString("stationid");
				String did = "";
				StationModel dbStmodel = stationService.queryStaSBySCode(stCode);
				if (dbStmodel != null) {
					did = dbStmodel.getBatteryId();
					if (!obj.getString("stationname").equals(dbStmodel.getStationName())) {
						AppLogger.sysDebug("update station:" + dbStmodel.getItStationId());
						stationService.updateStaName(dbStmodel.getItStationId(), obj.getString("stationname"));
					}
				}
				String voltage = itower.queryVoltageRT(provinceId, range_temp, stId, stCode, did);
				obj.put("voltage", ItowerImpl.formatVoltage(voltage));
				try {
					f = Float.parseFloat(voltage);
					if (f < 48) {
						qyCount++;
						zbz_tdqyList.add(obj);
					}
				} catch (NumberFormatException e) {
					errorCount++;
					zbz_errorOList.add(obj);
				}
			}

			StringBuffer replysb = new StringBuffer("【重保督办】\n");
			replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
			replysb.append(content).append("重保站点保障情况：");
			replysb.append("停电站点").append(zbz_tdList.size()).append("个，");
			replysb.append("其中欠压(<48V)").append(qyCount).append("个，");
			replysb.append("异常").append(errorCount).append("个，");
			replysb.append("退服").append(zbz_dztfList.size()).append("个，");
			replysb.append("离线").append(zbz_fsuList.size()).append("个。\n");
			if (zbz_tdList.size() > 0) {
				replysb.append("【停电站点】\n");
				for (int i = 0; i < zbz_tdList.size(); i++) {
					JSONObject obj = zbz_tdList.get(i);
					replysb.append(String.valueOf(i + 1)).append(".").append(obj.get("stationname")).append(" ").append(obj.get("voltage")).append(" ").append("历时").append(obj.get("alarmduration"))
							.append("\n");
				}
			}
			if (zbz_tdqyList.size() > 0) {
				replysb.append("【欠压站点】\n");
				for (int i = 0; i < zbz_tdqyList.size(); i++) {
					JSONObject obj = zbz_tdqyList.get(i);
					replysb.append(String.valueOf(i + 1)).append(".").append(obj.get("stationname")).append(" ").append(obj.get("voltage")).append(" ").append("历时").append(obj.get("alarmduration"))
							.append("\n");
				}
			}
			if (zbz_errorOList.size() > 0) {
				replysb.append("【异常站点】\n");
				for (int i = 0; i < zbz_errorOList.size(); i++) {
					JSONObject obj = zbz_errorOList.get(i);
					replysb.append(String.valueOf(i + 1)).append(".").append(obj.get("stationname")).append(" ").append(obj.get("voltage")).append(" ").append("历时").append(obj.get("alarmduration"))
							.append("\n");
				}
			}
			if (zbz_dztfList.size() > 0) {
				replysb.append("【退服站点】\n");
				for (int i = 0; i < zbz_dztfList.size(); i++) {
					AlarmModel am = zbz_dztfList.get(i);
					replysb.append(String.valueOf(i + 1)).append(".").append(am.getStationname()).append(" ").append("历时").append(am.getAlarmduration()).append("\n");
				}
			}
			long nowTime = System.currentTimeMillis();
			if (zbz_fsuList.size() > 0) {
				replysb.append("【FSU离线站点】\n");
				for (int i = 0; i < zbz_fsuList.size(); i++) {
					FSUMonitorModel fsuMo = zbz_fsuList.get(i);
					long duration = (nowTime - fsuMo.getOfflineTime().getTime()) / (1000 * 60);
					replysb.append(String.valueOf(i + 1)).append(".").append(fsuMo.getStationName()).append(" ").append("历时").append(minConvertHourMin(duration)).append("\n");
				}
			}
			if (replysb.length() > 0 && replysb.substring(replysb.length() - 1, replysb.length()).equals("\n")) {
				replysb.deleteCharAt(replysb.length() - 1);
			}
			zbzData.setSumCount(zbz_tdList.size() + qyCount + errorCount + zbz_dztfList.size() + zbz_fsuList.size());
			zbzData.setText(replysb.toString());
		}
		return zbzData;
	}

	public String selfServiceBZ(String content) {
		String city_id = locationService.getCityIdByName(content);
		if (city_id == null) {
			if (content.endsWith("省")) {
				content = content.substring(0, content.length() - 1);
			}
			String provinceId = locationService.getProvinceIdByFullName(content);
			return selfServiceBZ(provinceId, content);
		} else {
			List<FSUCondItem> list = selfServiceBZ_IMG(false, content);
			if (list.size() > 0) {
				long id = System.currentTimeMillis();
				Date now = new Date(id);
				for (int i = 0; i < list.size(); i++) {
					FSUCondItem item = list.get(i);
					item.setQueryid(id);
					item.setQuerytime(now);
					item.setSort(i + 1);
					stationService.addfSUCondItem(item);
				}
				return "http://localhost:9898/itowerElec/bz.jsp?qid=" + id;
			}
			return "";
		}
	}

	private AlarmComparator adDesc = new AlarmComparator(false, 2);

	public String selfServiceFSU(String content) {
		String reply = "";
		long nowTime = System.currentTimeMillis();
		try {
			String parsedStr = rangeParse(content);
			if (StringUtils.isNotEmpty(parsedStr)) {
				// List<AlarmModel> fsuList = itower.queryItowerAlarm(parsedStr,
				// ItowerImpl.ALARM_FSU);
				List<FSUMonitorModel> fusOfflineList = itower.listFSUOffline(parsedStr);

				StringBuffer replysb = new StringBuffer();
				replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
				if (fusOfflineList.size() > 0) {
					Collections.sort(fusOfflineList, new Comparator<FSUMonitorModel>() {
						@Override
						public int compare(FSUMonitorModel o1, FSUMonitorModel o2) {
							return o1.getOfflineTime().compareTo(o2.getOfflineTime());
						}
					});
					replysb.append(content).append("【FSU离线站点】" + fusOfflineList.size() + "个：").append("\n");
					for (int i = 0; i < fusOfflineList.size(); i++) {
						FSUMonitorModel fsum = fusOfflineList.get(i);
						long duration = (nowTime - fsum.getOfflineTime().getTime()) / (1000 * 60);
						replysb.append(String.valueOf(i + 1)).append(".").append(fsum.getStationName()).append(" 历时").append(minConvertHourMin(duration)).append("\n");
					}
					if (replysb.length() > 0 && replysb.substring(replysb.length() - 1, replysb.length()).equals("\n")) {
						replysb.deleteCharAt(replysb.length() - 1);
					}
				} else {
					replysb.append(content).append("无FSU离线信息");
				}
				reply = replysb.toString();
			}
			// else {
			// reply = "不支持的城市或地区";
			// }
		} catch (ServiceException e) {
			reply = TIMEOUT_TEXT;
			itower.autoLogin();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		return reply;
	}

	public String minConvertHourMin(long min) {
		String html = "0分";
		if (min > 0) {
			String format = "";
			Object[] array = null;
			int days = (int) (min / (60 * 24));
			int hours = (int) (min / (60) - days * 24);
			int minutes = (int) (min - hours * 60 - days * 24 * 60);
			if (days > 0) {
				format = "%1$,d天%2$,d时%3$,d分";
				array = new Object[] { days, hours, minutes };
			} else if (hours > 0) {
				format = "%1$,d时%2$,d分";
				array = new Object[] { hours, minutes };
			} else {
				format = "%1$,d分";
				array = new Object[] { minutes };
			}
			html = String.format(format, array);
		}
		return html;
	}

	public String selfServiceDZ(String content) {
		if (content.endsWith("省")) {
			content = content.substring(0, content.length() - 1);
		}
		String provinceId = locationService.getProvinceIdByFullName(content);
		return selfServiceDZ(provinceId, content);
	}

	public String selfServiceDZ(String provinceId, String content) {
		String reply = "";
		if (StringUtils.isNotEmpty(provinceId)) {
			reply = dzService(provinceId, content);
		} else {
			try {
				String parsedStr = rangeParse(content);
				if (StringUtils.isNotEmpty(parsedStr)) {
					reply = dzService(parsedStr, content);
				}
				// else {
				// reply = "不支持的城市或地区";
				// }
			} catch (Exception e) {
				throw new ServiceException(e);
			}
		}
		return reply;
	}

	public String dzService(String range, String content) {
		List<AlarmModel> dzList = null;
		try {
			dzList = itower.queryItowerAlarm(range, ItowerImpl.ALARM_DZTF);
		} catch (ServiceException e) {
			return TIMEOUT_TEXT;
		}
		StringBuffer replysb = new StringBuffer();
		replysb.append("截止至 ").append(FormatUtil.getDateMin(new Date())).append("\n");
		if (dzList.size() > 0) {
			Collections.sort(dzList, adDesc);
			replysb.append(content).append("【退服站点】" + dzList.size() + "个：").append("\n");
			for (int i = 0; i < dzList.size(); i++) {
				AlarmModel am = dzList.get(i);
				replysb.append(String.valueOf(i + 1)).append(".").append(am.getStationname()).append(" ").append("历时").append(am.getAlarmduration()).append("\n");
			}
			if (replysb.length() > 0 && replysb.substring(replysb.length() - 1, replysb.length()).equals("\n")) {
				replysb.deleteCharAt(replysb.length() - 1);
			}
		} else {
			replysb.append(content).append("无退服信息");
		}
		return replysb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.weixin.IReplyService#aiService()
	 */
	@Override
	public String aiService(String content, String fromId) throws ServiceException {
		return trBot.talk(content, DigestUtils.md5Hex(fromId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fuhj.weixin.IReplyService#otherService()
	 */
	@Override
	public String otherService(String content, String fromId) throws ServiceException {
		// TODO Auto-generated method stub
		return "";
	}

	public String rangeParse(String content) {
		String str = "";
		String[] rangeArray = content.trim().split("\\s+");
		StringBuffer sb = new StringBuffer();
		for (String s : rangeArray) {
			String district_id = locationService.getCityIdByName(s);
			if (district_id == null) {
				String city_id = locationService.getDistrictIdByName(s);
				if (city_id == null) {
					return null;
				} else {
					sb.append(city_id).append(",");
				}
			} else {
				sb.append(district_id).append(",");
			}
		}
		if (sb.substring(sb.length() - 1, sb.length()).equals(",")) {
			sb.deleteCharAt(sb.length() - 1);
		}
		if (sb.length() > 0) {
			str = sb.toString();
		}
		return str;
	}

	/**
	 * @param uiCallback
	 *            the uiCallback to set
	 */
	public void setUiCallback(IUICallBack uiCallback) {
		this.uiCallback = uiCallback;
		if (this.task != null) {
			this.task.setUiCallBack(uiCallback);
		}
	}

	public Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		if (oriMap != null && !oriMap.isEmpty()) {
			List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(oriMap.entrySet());
			Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
					return entry2.getValue() - entry1.getValue();
				}
			});
			Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
			Map.Entry<String, Integer> tmpEntry = null;
			while (iter.hasNext()) {
				tmpEntry = iter.next();
				sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
			}
		}
		return sortedMap;
	}

	@Data
	class ZBZMonitor {
		private List<FSUMonitorModel> fsuList;
		private List<AlarmModel> dztfList;
		private JSONArray tdjsonArray;
	}
}
