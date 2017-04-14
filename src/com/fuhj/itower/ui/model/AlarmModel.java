/**
 * 
 */
package com.fuhj.itower.ui.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fuhj.itower.model.StaAgtStaff;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-18
 */
@Data @NoArgsConstructor @AllArgsConstructor public class AlarmModel {
	private int index;
	private String province;
	private String city;
	private String district;
	private String itProvinceId;
	private String itCityId;
	private String itDistrictId;
	private String troubleno;
	private String billid;
	private String stationsid;
	private String stationname;
	private String stationcode;
	private String alarmName;
	private String alarmDetail;
	private String did;
	private Date alarmtime;
	private int alarmduration;
	private String voltage;

	private String fsuStatus;
	private String fsuManufacturer;
	private String stationFrom;
	private String agentMaintainCorp;
	private String alarmConfirm;
	private Date alarmConfirmTime;
	private String alarmConfirmRemark;

	private String prevoltage;
	private int spareelecduration;
	private int wayofduration;
	private int eleccountdown;
	private int elecWarninglevel;
	private StaAgtStaff sas;

	/**
	 * @param alarmSiteName
	 * @param alarmSiteid
	 * @param alarmTime
	 */
	public AlarmModel(String billid, String troubleno, String alarmName, String alarmDetail, Date alarmtime, String stationsid, String stationcode,
			String stationname, int alarmduration, String fsuStatus, String fsuManufacturer, String stationFrom, String agentMaintainCorp,
			String alarmConfirm, Date alarmConfirmTime, String alarmConfirmRemark) {
		super();
		this.billid = billid;
		this.troubleno = troubleno;
		this.stationsid = stationsid;
		this.stationname = stationname;
		this.alarmName = alarmName;
		this.alarmDetail = alarmDetail;
		this.stationcode = stationcode;
		this.alarmtime = alarmtime;
		this.alarmduration = alarmduration;
		this.fsuStatus = fsuStatus;
		this.fsuManufacturer = fsuManufacturer;
		this.stationFrom = stationFrom;
		this.agentMaintainCorp = agentMaintainCorp;
		this.alarmConfirm = alarmConfirm;
		this.alarmConfirmTime = alarmConfirmTime;
		this.alarmConfirmRemark = alarmConfirmRemark;
		this.spareelecduration = 360;
		this.wayofduration = 120;
	}
}
