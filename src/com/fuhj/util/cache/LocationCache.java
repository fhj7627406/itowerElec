/**
 * 
 */
package com.fuhj.util.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fuhj.itower.model.ITCity;
import com.fuhj.itower.model.ITDistrict;
import com.fuhj.itower.model.ITProvince;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-22
 */
public class LocationCache {
	public static final Map<String, ITProvince> PROVINCE_MAP = new HashMap<String, ITProvince>();
	public static final Map<String, ITCity> CITY_MAP = new HashMap<String, ITCity>();
	public static final Map<String, ITDistrict> DISTRICT_MAP = new HashMap<String, ITDistrict>();

	public static final Map<String, List<ITCity>> PROVINCE_CITY_MAP = new HashMap<String, List<ITCity>>();
	public static final Map<String, List<ITDistrict>> CITY_DISTRICT_MAP = new HashMap<String, List<ITDistrict>>();

	public static final Map<String, ITCity> DEFAULT_CITY_MAP = new HashMap<String, ITCity>();
	public static final Map<String, ITDistrict> DEFAULT_DISTRICT_MAP = new HashMap<String, ITDistrict>();

	public static final List<ITProvince> ALL_PROVINCE = new ArrayList<ITProvince>();
	public static ITProvince defaultProvince = null;

	public synchronized static void clear() {
		PROVINCE_MAP.clear();
		CITY_MAP.clear();
		DISTRICT_MAP.clear();
		PROVINCE_CITY_MAP.clear();
		CITY_DISTRICT_MAP.clear();
		DEFAULT_CITY_MAP.clear();
		DEFAULT_DISTRICT_MAP.clear();
		ALL_PROVINCE.clear();
		defaultProvince = null;
	}
}
