/**
 * 
 */
package com.fuhj.itower.service;

import java.util.List;
import java.util.Map;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.FSUCondItem;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.model.StationBattery;
import com.fuhj.itower.model.ZbzItem;
import com.fuhj.itower.ui.model.StaQueryParam;
import com.fuhj.itower.ui.model.StationModel;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-11
 */
public interface StationService extends AbstractService {
	ItStation queryStaBySID(String sid) throws ServiceException;

	void updateStaName(int stationId, String staName) throws ServiceException;

	Map<String, StationModel> queryStaSBySCode(List<String> scodeList) throws ServiceException;

	StationModel queryStaSBySCode(String siteCode) throws ServiceException;

	List<StationModel> getStations(StaQueryParam param, int index, int pageSize) throws ServiceException;

	void addStationBattery(StationBattery sb) throws ServiceException;

	StationBattery getStationBattery(String stationCode) throws ServiceException;

	void addStation(ItStation st) throws ServiceException;

	void addStaAgtStaff(StaAgtStaff sas) throws ServiceException;

	void addfSUCondItem(FSUCondItem item) throws ServiceException;

	List<FSUCondItem> getFSUCondByQueryId(String queryId) throws ServiceException;

	int getStaCount(StaQueryParam param) throws ServiceException;

	void addZbzItem(ZbzItem item) throws ServiceException;

	List<ZbzItem> getZbzItems(String provinceId, String cityId, String districtId) throws ServiceException;

	Map<String, ZbzItem> getZbzItemsMap(String provinceId, String cityId, String districtId) throws ServiceException;

	List<StationModel> getStationByName(String staName) throws ServiceException;

	StationModel getStationByCode(String staCode) throws ServiceException;

	List<ItStation> getStations(String itProvinceId, String itCityId, String nameKeyWord, String stationcode) throws ServiceException;

	List<ItStation> getQXStations(String provinceId, String cityId, String districtId, String outsideCustomerName) throws ServiceException;
}
