/**
 * 
 */
package com.fuhj.itower.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.dao.DbField;
import com.fuhj.itower.dao.Example;
import com.fuhj.itower.dao.GenericMapper;
import com.fuhj.itower.model.FSUCondItem;
import com.fuhj.itower.model.FSUCondItemCriteria;
import com.fuhj.itower.model.ItStation;
import com.fuhj.itower.model.ItStationCriteria;
import com.fuhj.itower.model.StaAgtStaff;
import com.fuhj.itower.model.StationBattery;
import com.fuhj.itower.model.StationBatteryCriteria;
import com.fuhj.itower.model.ZbzItem;
import com.fuhj.itower.service.StationService;
import com.fuhj.itower.ui.model.StaQueryParam;
import com.fuhj.itower.ui.model.StationModel;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-11
 */
public class StationServiceImpl extends AbstractServiceImpl implements StationService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8714799037699784946L;
	@Setter
	private GenericMapper<ItStation> itStationMapper;
	@Setter
	private GenericMapper<StaAgtStaff> staAgtStaffMapper;
	@Setter
	private GenericMapper<StationBattery> stationBatteryMapper;
	@Setter
	private GenericMapper<FSUCondItem> fSUCondItemMapper;
	@Setter
	private GenericMapper<ZbzItem> zbzItemMapper;

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#queryStaBySID(java.lang.String)
	 */
	@Override
	public ItStation queryStaBySID(String sid) throws ServiceException {
		Example<ItStationCriteria> example = Example.getExample(ItStationCriteria.class);
		ItStationCriteria c = example.createCriteria();
		c.andStationCodeEqualTo(sid);
		List<ItStation> list = itStationMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#queryStaSBySID(java.util.List)
	 */
	@Override
	public Map<String, StationModel> queryStaSBySCode(List<String> scodeList) throws ServiceException {
		Map<String, StationModel> map = new HashMap<String, StationModel>(scodeList.size());
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("scodeList", scodeList);
		List<StationModel> list = itStationMapper.selectByCustom("selectStaSBySCode", paraMap);
		for (StationModel sta : list) {
			map.put(sta.getStationCode(), sta);
		}
		return map;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#queryStaSBySCode(java.lang.String)
	 */
	@Override
	public StationModel queryStaSBySCode(String siteCode) throws ServiceException {
		Map<String, StationModel> map = queryStaSBySCode(Arrays.asList(siteCode));
		return map.size() == 1 ? map.get(siteCode) : null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getApplicant(com.fuhj.itower.service .StaQueryParam, int, int)
	 */
	@Override
	public List<StationModel> getStations(StaQueryParam param, int index, int pageSize) throws ServiceException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("offset", index);
		paramMap.put("limit", pageSize);
		if (param != null) {
			if (StringUtils.isNotEmpty(param.getStName())) {
				StringBuffer sb = new StringBuffer("%").append(param.getStName()).append("%");
				paramMap.put("stName", sb.toString());
			}
			if (StringUtils.isNotEmpty(param.getStCode())) {
				paramMap.put("stCode", param.getStCode());
			}
			if (StringUtils.isNotEmpty(param.getItProvinceId())) {
				paramMap.put("provinceId", param.getItProvinceId());
			}
			if (StringUtils.isNotEmpty(param.getItCityId())) {
				paramMap.put("cityId", param.getItCityId());
			}
			if (StringUtils.isNotEmpty(param.getItDistrictId())) {
				paramMap.put("districtId", param.getItDistrictId());
			}
		}
		return itStationMapper.selectByCustom("selectStaPageByCustom", paramMap);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getStaCount(com.fuhj.itower.service .StaQueryParam)
	 */
	@Override
	public int getStaCount(StaQueryParam param) throws ServiceException {
		Example<ItStationCriteria> example = Example.getExample(ItStationCriteria.class);
		ItStationCriteria c = example.createCriteria();
		if (param != null) {
			if (StringUtils.isNotEmpty(param.getStName())) {
				StringBuffer sb = new StringBuffer("%").append(param.getStName()).append("%");
				c.andStationNameLike(sb.toString());
			}
			if (StringUtils.isNotEmpty(param.getStCode())) {
				c.andStationCodeEqualTo(param.getStCode());
			}
			if (StringUtils.isNotEmpty(param.getItProvinceId())) {
				c.andItProvinceIdEqualTo(param.getItProvinceId());
			}
			if (StringUtils.isNotEmpty(param.getItCityId())) {
				c.andItCityIdEqualTo(param.getItCityId());
			}
			if (StringUtils.isNotEmpty(param.getItDistrictId())) {
				c.andItDistrictIdEqualTo(param.getItDistrictId());
			}
		}
		return itStationMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#addStationBattery()
	 */
	@Override
	public void addStationBattery(StationBattery sb) throws ServiceException {
		// StationBattery sbdb = getStationBattery(sb.getStationcode());
		// if (sbdb != null) {
		// sb.setStationBatteryId(sbdb.getStationBatteryId());
		// stationBatteryMapper.updateByPrimaryKeySelective(sb);
		// } else {
		stationBatteryMapper.insertSelective(sb);
		// }

	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getStationBattery(java.lang.String)
	 */
	@Override
	public StationBattery getStationBattery(String stationCode) throws ServiceException {
		Example<StationBatteryCriteria> e = Example.getExample(StationBatteryCriteria.class);
		e.createCriteria().andStationcodeEqualTo(stationCode);
		e.setOrderByClause(new StringBuffer(StationBattery.STATION_BATTERY_ID).append(" DESC").toString());
		List<StationBattery> list = stationBatteryMapper.selectByExample(e);
		return list.size() > 0 ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#addStation(com.fuhj.itower.model.Station)
	 */
	@Override
	public void addStation(ItStation st) throws ServiceException {
		Date now=new Date();
		st.setCreateTime(now);
		st.setUpdateTime(now);
		itStationMapper.insertSelective(st);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#addStaAgtStaff(com.fuhj.itower.model.StaAgtStaff)
	 */
	@Override
	public void addStaAgtStaff(StaAgtStaff sas) throws ServiceException {
		staAgtStaffMapper.insertSelective(sas);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#addfSUCondItem(java.util.List)
	 */
	@Override
	public void addfSUCondItem(FSUCondItem item) throws ServiceException {
		fSUCondItemMapper.insert(item);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.MainService#getFSUCondByQueryId(java.lang.String)
	 */
	@Override
	public List<FSUCondItem> getFSUCondByQueryId(String queryId) throws ServiceException {
		Example<FSUCondItemCriteria> example = Example.getExample(FSUCondItemCriteria.class);
		try {
			long id = Long.parseLong(queryId);
			example.createCriteria().andQueryidEqualTo(id);
			example.setOrderByClause(FSUCondItem.SORT);
			return fSUCondItemMapper.selectByExample(example);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#addZbzItem(com.fuhj.itower.model.ZbzItem)
	 */
	@Override
	public void addZbzItem(ZbzItem item) throws ServiceException {
		// TODO Auto-generated method stub
		zbzItemMapper.insert(item);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#getStationByName(java.lang.String)
	 */
	@Override
	public List<StationModel> getStationByName(String staName) throws ServiceException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#getStationByCode(java.lang.String)
	 */
	@Override
	public StationModel getStationByCode(String staCode) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#getZbzItems(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ZbzItem> getZbzItems(String provinceId, String cityId, String districtId) throws ServiceException {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(provinceId)) {
			paraMap.put("provinceId", provinceId);
		}
		if (StringUtils.isNotEmpty(cityId)) {
			paraMap.put("cityId", cityId);
		}
		if (StringUtils.isNotEmpty(districtId)) {
			paraMap.put("districtId", districtId);
		}
		return zbzItemMapper.selectByCustom("selectCustomzbz", paraMap);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#getZbzItemsMap(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, ZbzItem> getZbzItemsMap(String provinceId, String cityId, String districtId) throws ServiceException {
		List<ZbzItem> list = getZbzItems(provinceId, cityId, districtId);
		Map<String, ZbzItem> map = new HashMap<String, ZbzItem>();
		for (ZbzItem item : list) {
			String stCode = item.getTempStr();
			map.put(stCode, item);
		}
		return map;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#updateStaName(int)
	 */
	@Override
	public void updateStaName(int stationId, String staName) throws ServiceException {
		List<DbField> fields = new ArrayList<DbField>();
		fields.add(new DbField(ItStation.STATION_NAME, staName));
		fields.add(new DbField(ItStation.UPDATE_TIME, new Date()));
		Example<ItStationCriteria> example = Example.getExample(ItStationCriteria.class);
		ItStationCriteria c = example.createCriteria();
		c.andItStationIdEqualTo(stationId);
		itStationMapper.updateFieldsByExample(fields, example);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#getStations(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ItStation> getStations(String itProvinceId, String itCityId, String nameKeyWord, String stationcode) throws ServiceException {
		Example<ItStationCriteria> example = Example.getExample(ItStationCriteria.class);
		ItStationCriteria c = example.createCriteria();
		if (StringUtils.isNotEmpty(itProvinceId)) {
			c.andItProvinceIdEqualTo(itProvinceId);
		}
		if (StringUtils.isNotEmpty(itCityId)) {
			c.andItCityIdEqualTo(itCityId);
		}
		if (StringUtils.isNotEmpty(nameKeyWord)) {
			c.andStationNameLike("%" + nameKeyWord + "%");
		}
		if (StringUtils.isNotEmpty(stationcode)) {
			c.andStationCodeEqualTo(stationcode);
		}
		example.setOrderByClause(ItStation.IT_STATION_ID);
		return itStationMapper.selectByExample(example, new RowBounds(0, 10));
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.StationService#getQXStations(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ItStation> getQXStations(String provinceId, String cityId, String districtId, String outsideCustomerName) throws ServiceException {
		if (StringUtils.isEmpty(outsideCustomerName)) {
			return null;
		}
		Example<ItStationCriteria> example = Example.getExample(ItStationCriteria.class);
		ItStationCriteria c = example.createCriteria();
		if (StringUtils.isNotEmpty(provinceId)) {
			c.andItProvinceIdEqualTo(provinceId);
		}
		if (StringUtils.isNotEmpty(cityId)) {
			c.andItCityIdEqualTo(cityId);
		}
		if (StringUtils.isNotEmpty(districtId)) {
			c.andItDistrictIdEqualTo(districtId);
		}
		c.andOutsideCustomerEqualTo(outsideCustomerName);
		example.setOrderByClause(ItStation.IT_STATION_ID);
		return itStationMapper.selectByExample(example);
	}
}
