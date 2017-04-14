/**
 * 
 */
package com.fuhj.itower.ui.model;

import java.util.Date;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-6-19
 */
public class FSUMonitorModel {
	// 站址ID（运监数据库）
	private String stationId;
	// 站址名
	private String stationName;
	// 站址编码
	private String stationCode;
	// FSU厂家
	private String fsuCorp;
	// 负责人
	private String charge;
	// 维护人电话
	private String chargePhone;
	// 注册时间
	private Date regTime;
	// 离线时间
	private Date offlineTime;
	// 站址状态
	private String stationStatus;
	// 站址来源
	private String stationFrom;

	/**
	 * @return the stationId
	 */
	public String getStationId() {
		return stationId;
	}

	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return the stationCode
	 */
	public String getStationCode() {
		return stationCode;
	}

	/**
	 * @param stationCode the stationCode to set
	 */
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	/**
	 * @return the fsuCorp
	 */
	public String getFsuCorp() {
		return fsuCorp;
	}

	/**
	 * @param fsuCorp the fsuCorp to set
	 */
	public void setFsuCorp(String fsuCorp) {
		this.fsuCorp = fsuCorp;
	}

	/**
	 * @return the charge
	 */
	public String getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}

	/**
	 * @return the chargePhone
	 */
	public String getChargePhone() {
		return chargePhone;
	}

	/**
	 * @param chargePhone the chargePhone to set
	 */
	public void setChargePhone(String chargePhone) {
		this.chargePhone = chargePhone;
	}

	/**
	 * @return the regTime
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	/**
	 * @return the offlineTime
	 */
	public Date getOfflineTime() {
		return offlineTime;
	}

	/**
	 * @param offlineTime the offlineTime to set
	 */
	public void setOfflineTime(Date offlineTime) {
		this.offlineTime = offlineTime;
	}

	/**
	 * @return the stationStatus
	 */
	public String getStationStatus() {
		return stationStatus;
	}

	/**
	 * @param stationStatus the stationStatus to set
	 */
	public void setStationStatus(String stationStatus) {
		this.stationStatus = stationStatus;
	}

	/**
	 * @return the stationFrom
	 */
	public String getStationFrom() {
		return stationFrom;
	}

	/**
	 * @param stationFrom the stationFrom to set
	 */
	public void setStationFrom(String stationFrom) {
		this.stationFrom = stationFrom;
	}

}
