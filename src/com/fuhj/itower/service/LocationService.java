/**
 * 
 */
package com.fuhj.itower.service;

import java.util.List;

import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ITProvince;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-22
 */
public interface LocationService extends AbstractService {
	/**
	 * 查询所有省
	 * 
	 * @return
	 */
	List<ITProvince> findAllProvince();

	/**
	 * 根据ID查找省
	 * 
	 * @param provinceId
	 * @return
	 */
	ITProvince getProvinceById(String provinceId);

	/**
	 * 查找指定省内所有城市
	 * 
	 * @param provinceId
	 * @return
	 */
	List<ITCity> findAllCityByProvinceId(String provinceId);

	/**
	 * 根据ID查找市
	 * 
	 * @param cityId
	 * @return
	 */
	ITCity getCityById(String cityId);

	/**
	 * 查找指定市内所有地区（县）
	 * 
	 * @param cityId
	 * @return
	 */
	List<ITDistrict> findAllDistrictByCityId(String cityId);

	/**
	 * 根据ID查找地区（县）
	 * 
	 * @param districtId
	 * @return
	 */
	ITDistrict getDistrictById(String districtId);

	/**
	 * 根据省全名获得省ID
	 * 
	 * @param fullName
	 * @return
	 */
	String getProvinceIdByFullName(String fullName);

	/**
	 * 根据所属省编码，市全名查询市编码
	 * 
	 * @param provinceCode
	 * @param fullName
	 * @return 0 if not found
	 */
	String getCityIdByFullName(String provinceCode, String fullName);

	String getCityIdByName(String fullName);

	ITCity getCityByName(String fullName);

	/**
	 * 根据所属省编码，所属市编码，地区全名查询地区编码
	 * 
	 * @param provinceId
	 * @param cityId
	 * @param fullName
	 * @return
	 */
	String getDistrictIdByFullName(String provinceId, String cityId, String fullName);

	String getDistrictIdByName(String name);

	ITDistrict getDistrictByName(String name);

	/**
	 * 地区全名
	 * 
	 * @param provinceId
	 * @param cityId
	 * @param districtId
	 * @return
	 */
	String getLocationName(String provinceId, String cityId, String districtId);

	void reloadLocation();
}
