/**
 * 
 */
package com.fuhj.itower.api;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-9-10
 */
@Data @AllArgsConstructor @NoArgsConstructor public class StationDevice {
	private int stationDeviceId;
	private String stationSysId;
	private String deviceName;
	private String deviceCode;
	private String model;
	private String manufacturer;
	private String point;
	private Date updateTime;
	private String actualValue;
	private String units;
	private String deviceNameShort;
	/**
	 * @param stationSysId
	 * @param deviceName
	 * @param deviceCode
	 * @param model
	 * @param manufacturer
	 * @param point
	 * @param updateTime
	 * @param actualValue
	 * @param units
	 */
	public StationDevice(String stationSysId, String deviceName, String deviceCode, String model, String manufacturer, String point, Date updateTime,
			String actualValue, String units) {
		super();
		this.stationSysId = stationSysId;
		this.deviceName = deviceName;
		this.deviceCode = deviceCode;
		this.model = model;
		this.manufacturer = manufacturer;
		this.point = point;
		this.updateTime = updateTime;
		this.actualValue = actualValue;
		this.units = units;
	}
	
}
