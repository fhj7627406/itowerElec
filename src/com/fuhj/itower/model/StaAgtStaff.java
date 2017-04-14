package com.fuhj.itower.model;

public class StaAgtStaff extends BaseModel {
	private int sasId;

	private String stationcode;

	private String agstaffname;

	private String agstafftel;

	private String remark;

	private int status;

	/**
	 * 
	 */
	public StaAgtStaff() {
		super();
	}

	/**
	 * @param agstaffname
	 * @param agstafftel
	 */
	public StaAgtStaff(String agstaffname, String agstafftel) {
		super();
		this.agstaffname = agstaffname;
		this.agstafftel = agstafftel;
	}

	public int getSasId() {
		return sasId;
	}

	public void setSasId(int sasId) {
		this.sasId = sasId;
	}

	public String getStationcode() {
		return stationcode;
	}

	public void setStationcode(String stationcode) {
		this.stationcode = stationcode == null ? null : stationcode.trim();
	}

	public String getAgstaffname() {
		return agstaffname;
	}

	public void setAgstaffname(String agstaffname) {
		this.agstaffname = agstaffname == null ? null : agstaffname.trim();
	}

	public String getAgstafftel() {
		return agstafftel;
	}

	public void setAgstafftel(String agstafftel) {
		this.agstafftel = agstafftel == null ? null : agstafftel.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}