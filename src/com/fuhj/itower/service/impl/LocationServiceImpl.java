/**
 * 
 */
package com.fuhj.itower.service.impl;

import java.util.List;

import lombok.Setter;

import com.fuhj.itower.dao.Example;
import com.fuhj.itower.dao.GenericMapper;
import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITCityCriteria;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ITDistrictCriteria;
import com.fuhj.itower.model.ITProvince;
import com.fuhj.itower.model.ITProvinceCriteria;
import com.fuhj.itower.service.LocationService;
import com.fuhj.util.cache.LocationCache;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-22
 */
public class LocationServiceImpl extends AbstractServiceImpl implements LocationService {
	@Setter private GenericMapper<ITCity> cityMapper;
	@Setter private GenericMapper<ITProvince> provinceMapper;
	@Setter private GenericMapper<ITDistrict> districtMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = -136648908807058136L;

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#findAllProvince()
	 */
	@Override public List<ITProvince> findAllProvince() {
		if (LocationCache.ALL_PROVINCE.size() == 0) {
			reloadLocation();
		}
		return LocationCache.ALL_PROVINCE;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getProvinceById(java.lang.Integer )
	 */
	@Override public ITProvince getProvinceById(String provinceId) {
		ITProvince province = LocationCache.PROVINCE_MAP.get(provinceId);
		return province;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#findAllCityByProvinceId(java. lang.Integer)
	 */
	@Override public List<ITCity> findAllCityByProvinceId(String provinceId) {
		List<ITCity> cityList = LocationCache.PROVINCE_CITY_MAP.get(provinceId);
		if (cityList != null) {
			return cityList;
		}
		Example<ITCityCriteria> example = Example.getExample(ITCityCriteria.class);
		example.createCriteria().andItProvinceIdEqualTo(provinceId);
		cityList = cityMapper.selectByExample(example);
		LocationCache.PROVINCE_CITY_MAP.put(provinceId, cityList);
		return cityList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getCityById(java.lang.Integer)
	 */
	@Override public ITCity getCityById(String cityId) {
		ITCity city = LocationCache.CITY_MAP.get(cityId);
		if (city != null) {
			return city;
		}
		city = cityMapper.selectByPrimaryKey(cityId);
		LocationCache.CITY_MAP.put(cityId, city);
		return city;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#findAllDistrictByCityId(java. lang.Integer)
	 */
	@Override public List<ITDistrict> findAllDistrictByCityId(String cityId) {
		List<ITDistrict> districtList = LocationCache.CITY_DISTRICT_MAP.get(cityId);
		if (districtList != null) {
			return districtList;
		}
		Example<ITDistrictCriteria> example = Example.getExample(ITDistrictCriteria.class);
		example.createCriteria().andItCityIdEqualTo(cityId);
		districtList = districtMapper.selectByExample(example);
		LocationCache.CITY_DISTRICT_MAP.put(cityId, districtList);
		return districtList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getDistrictById(java.lang.Integer )
	 */
	@Override public ITDistrict getDistrictById(String districtId) {
		ITDistrict district = LocationCache.DISTRICT_MAP.get(districtId);
		if (district != null) {
			return district;
		}
		district = districtMapper.selectByPrimaryKey(districtId);
		LocationCache.DISTRICT_MAP.put(districtId, district);
		return district;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getProvinceIdByFullName(java. lang.String)
	 */
	@Override public String getProvinceIdByFullName(String fullName) {
		// Example<ITProvinceCriteria> example = Example.getExample(ITProvinceCriteria.class);
		// example.createCriteria().andPnameEqualTo(fullName);
		// List<ITProvince> provinces = provinceMapper.selectByExample(example);
		// return provinces.size() > 0 ? provinces.get(0).getItProvinceId() : "";
		List<ITProvince> provinces = findAllProvince();
		for (ITProvince p : provinces) {
			if (p.getPname().equals(fullName)) {
				return p.getItProvinceId();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getCityIdByFullName(java.lang .Integer, java.lang.String)
	 */
	@Override public String getCityIdByFullName(String provinceId, String fullName) {
		Example<ITCityCriteria> example = Example.getExample(ITCityCriteria.class);
		example.createCriteria().andItProvinceIdEqualTo(provinceId).andCnameEqualTo(fullName);
		List<ITCity> cities = cityMapper.selectByExample(example);
		return cities.size() > 0 ? cities.get(0).getItCityId() : "";
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getDistrictIdByFullName(java. lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override public String getDistrictIdByFullName(String provinceId, String cityId, String fullName) {
		Example<ITDistrictCriteria> example = Example.getExample(ITDistrictCriteria.class);
		example.createCriteria().andItProvinceIdEqualTo(provinceId).andItCityIdEqualTo(cityId).andDnameEqualTo(fullName);
		List<ITDistrict> districts = districtMapper.selectByExample(example);
		return districts.size() > 0 ? districts.get(0).getItDistrictId() : "";
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getLocationName(java.lang.Integer , java.lang.Integer, java.lang.Integer)
	 */
	@Override public String getLocationName(String provinceId, String cityId, String districtId) {
		ITProvince province = getProvinceById(provinceId);
		ITCity city = getCityById(cityId);
		ITDistrict district = getDistrictById(districtId);
		String name = (province == null ? " " : province.getPname()) + (city == null ? " " : city.getCname())
				+ (district == null ? " " : district.getDname());
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#reloadLocation()
	 */
	@Override public void reloadLocation() {
		LocationCache.clear();
		Example<ITProvinceCriteria> example = Example.getExample(ITProvinceCriteria.class);
		List<ITProvince> provinces = provinceMapper.selectByExample(example);
		for (ITProvince province : provinces) {
			LocationCache.ALL_PROVINCE.add(province);
			LocationCache.PROVINCE_MAP.put(province.getItProvinceId(), province);
			List<ITCity> cityList = findAllCityByProvinceId(province.getItProvinceId());
			for (ITCity citys : cityList) {
				findAllDistrictByCityId(citys.getItCityId());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getCityIdByFullName(java.lang .String)
	 */
	@Override public String getCityIdByName(String fullName) {
		List<ITProvince> provinces = findAllProvince();
		for (ITProvince p : provinces) {
			List<ITCity> citys = findAllCityByProvinceId(p.getItProvinceId());
			for (ITCity city : citys) {
				if (city.getCname().equals(fullName)) {
					return city.getItCityId();
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getDistrictIdByFullName(java. lang.String)
	 */
	@Override public String getDistrictIdByName(String name) {
		List<ITProvince> provinces = findAllProvince();
		for (ITProvince p : provinces) {
			List<ITCity> citys = findAllCityByProvinceId(p.getItProvinceId());
			for (ITCity city : citys) {
				List<ITDistrict> list_district = findAllDistrictByCityId(city.getItCityId());
				for (ITDistrict district : list_district) {
					if (district.getDname().equals(name) || district.getDshortname().equals(name)) {
						return district.getItDistrictId();
					}
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getCityByName(java.lang.String)
	 */
	@Override public ITCity getCityByName(String fullName) {
		return getCityById(getCityIdByName(fullName));
	}

	/*
	 * (non-Javadoc)
	 * @see com.fuhj.itower.service.LocationService#getDistrictByName(java.lang.String)
	 */
	@Override public ITDistrict getDistrictByName(String name) {
		return getDistrictById(getDistrictIdByName(name));
	}
}
