/**
 * 
 */
package com.fuhj.itower.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.AlarmQueryLog;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.service.LocationService;
import com.fuhj.itower.service.MainService;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.service.impl.AbstractServiceImpl;
import com.fuhj.itower.service.model.AlarmJson;
import com.fuhj.itower.service.model.AlarmModelJson;
import com.fuhj.itower.ui.MyProperties;
import com.fuhj.itower.ui.model.AlarmComparator;
import com.fuhj.itower.ui.model.AlarmModel;
import com.fuhj.itower.ui.model.QueryResult;
import com.fuhj.itower.ui.model.StationModel;
import com.fuhj.itower.ui.model.TDSiteVoltage;
import com.fuhj.log.AppLogger;
import com.fuhj.util.JsonUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-4-18
 */
public class APIServiceImpl extends AbstractServiceImpl implements APIService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5566260661802979968L;
	@Setter
	private LocationService locationService;
	@Setter
	private StationService stationService;
	@Setter
	private MainService mainService;
	@Getter
	private AlarmComparator vtAsc = new AlarmComparator(true, 5);
	private ItowerImpl itower = new ItowerImpl();

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.APIService#queryPFAlarm(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public AlarmJson queryPFAlarm(final String atype, final String range, final String slave) throws ServiceException {
		AlarmJson json = null;
		try {
			if (StringUtils.isNotEmpty(atype)) {
				if (atype.equals("1")) {
					if (!rangeCheck(range)) {
						return new AlarmJson(-1, "参数range错误");
					}
					String cookieValue = MyProperties.getValueByKey(MyProperties.COOKIEFILE, "Cookie");
					if (StringUtils.isNotEmpty(cookieValue)) {
						final Date queryBegin = new Date();
						final List<AlarmModel> list = itower.queryItowerAlarm(range, ItowerImpl.ALARM_TD);
						if (list != null && list.size() > 0) {
							if (StringUtils.isNotEmpty(slave) && slave.equals("false")) {
								ExecutorService pool = Executors.newSingleThreadExecutor();
								Map<String, TDSiteVoltage> tdvMap = itower.queryTDsiteV(range);
								List<String> sidList = new ArrayList<String>(list.size());
								for (AlarmModel a : list) {
									sidList.add(a.getStationcode());
								}
								Map<String, StationModel> map = stationService.queryStaSBySCode(sidList);
								for (AlarmModel a : list) {
									StationModel dbStmodel = map.get(a.getStationcode());
									if (dbStmodel != null) {
										a.setDid(dbStmodel.getBatteryId());
										if (!a.getStationname().equals(dbStmodel.getStationName())) {
											AppLogger.sysDebug("update station:" + dbStmodel.getItStationId());
											stationService.updateStaName(dbStmodel.getItStationId(), a.getStationname());
										}
									} else {
										// BUG:查询station表事务未提交这里更新可能会报错
										ItStation site = itower.getStationByCode(range, a.getStationcode());
										if (site != null) {
											a.setItProvinceId(site.getItProvinceId());
											a.setItCityId(site.getItCityId());
											a.setItDistrictId(site.getItDistrictId());
											site.setCreateTime(new Date());
											site.setUpdateTime(new Date());
											stationService.addStation(site);
										}
										StaAgtStaff sas = itower.getStaAgtStaffByCode(range, a.getStationcode());
										if (sas != null) {
											a.setSas(new StaAgtStaff(sas.getAgstaffname(), sas.getAgstafftel()));
											stationService.addStaAgtStaff(sas);
										}
									}

									TDSiteVoltage tdv = tdvMap.get(a.getStationcode());
									if (tdv != null) {
										a.setVoltage(tdv.getVoltage());
									} else {
										pool.execute(new QueryVoltageTask(a, range));
									}
								}
								pool.shutdown();
								while (true) {
									if (pool.isTerminated()) {
										break;
									}
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								Collections.sort(list, vtAsc);
							}

							List<AlarmModelJson> newList = new ArrayList<AlarmModelJson>();
							for (int i = 0; i < list.size(); i++) {
								AlarmModel a = list.get(i);
								AlarmModelJson amJson = new AlarmModelJson();
								BeanUtils.copyProperties(amJson, a);
								amJson.setIndex(i + 1);
								newList.add(amJson);
							}
							json = new AlarmJson(0, "查询成功");
							json.setCount(list.size());
							json.setList(JsonUtil.getJSONArrayFromList(newList));
						} else {
							json = new AlarmJson(0, "查询成功");
							json.setCount(0);
							json.setList(null);
						}
						ExecutorService service = Executors.newSingleThreadExecutor();
						service.execute(new Runnable() {
							@Override
							public void run() {
								AlarmQueryLog log = mainService.createQueryLog(list, queryBegin, range);
								mainService.addAlarmQueryLog(log);
							}
						});
						service.shutdown();
					} else {
						return new AlarmJson(-2, "未登录");
					}
				} else {
					return new AlarmJson(-1, "不支持的atype");
				}
			} else {
				return new AlarmJson(-1, "缺少参数：atype");
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return json;
	}

	public boolean rangeCheck(String range) {
		String[] rangeArray = range.split(",");
		for (String s : rangeArray) {
			ITDistrict district = locationService.getDistrictById(s);
			if (district == null) {
				ITCity city = locationService.getCityById(s);
				if (city == null) {
					return false;
				}
			}
		}
		return true;
	}

	class QueryVoltageTask implements Runnable {
		ItowerImpl itower = new ItowerImpl();
		private AlarmModel model;
		private String range;

		public QueryVoltageTask(AlarmModel model, String range) {
			this.model = model;
			this.range = range;
		}

		public void run() {
			try {
				String voltage = "";
				final ExecutorService service = Executors.newSingleThreadExecutor();
				Future<String> f = service.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						return itower.queryVoltageRT(model.getItProvinceId(), range, model.getStationsid(), model.getStationcode(), model.getDid());
					}
				});
				try {
					voltage = f.get(60, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					f.cancel(true);
					voltage = QueryResult.INTERRUPT.getValue();
				} catch (ExecutionException e) {
					f.cancel(true);
					voltage = QueryResult.TIMEOUT.getValue();
				} catch (TimeoutException e) {
					f.cancel(true);
					voltage = QueryResult.TIMEOUT.getValue();
				} finally {
					service.shutdown();
				}
				// AppLogger.sysDebug(Thread.currentThread().getName() + " voltage:" + voltage);
				if (StringUtils.isNotEmpty(voltage)) {
					model.setVoltage(ItowerImpl.formatVoltage(voltage));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
