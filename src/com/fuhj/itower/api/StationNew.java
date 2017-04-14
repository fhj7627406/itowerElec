/**
 * 
 */
package com.fuhj.itower.api;

import lombok.Data;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-9-10
 */
@Data public class StationNew {
	private String queryIndex;
	private String stationSysId;
	private String stationCode;
	private String stationName;
	private String stationAddr;
	private String stationStatus;
	private String stationType;
	private String itProvinceId;
	private String itCityId;
	private String itDistrictId;
	private double lat;
	private double lng;
}
