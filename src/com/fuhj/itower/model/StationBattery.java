package com.fuhj.itower.model;

public class StationBattery extends BaseModel {
	private int stationBatteryId;

	public static final String STATION_BATTERY_ID = "station_battery_id";

	private String stationcode;

	public static final String STATIONCODE = "stationCode";

	private String stationsid;

	public static final String STATIONSID = "stationSid";

	private String batteryid;

	public static final String BATTERYID = "batteryId";

	public StationBattery() {

	}

	/**
	 * @param stationcode
	 * @param stationsid
	 * @param batteryid
	 */
	public StationBattery(String stationcode, String stationsid, String batteryid) {
		super();
		this.stationcode = stationcode;
		this.stationsid = stationsid;
		this.batteryid = batteryid;
	}

	public int getStationBatteryId() {
		return stationBatteryId;
	}

	public void setStationBatteryId(int stationBatteryId) {
		this.stationBatteryId = stationBatteryId;
	}

	public String getStationcode() {
		return stationcode;
	}

	public void setStationcode(String stationcode) {
		this.stationcode = stationcode == null ? null : stationcode.trim();
	}

	public String getStationsid() {
		return stationsid;
	}

	public void setStationsid(String stationsid) {
		this.stationsid = stationsid == null ? null : stationsid.trim();
	}

	public String getBatteryid() {
		return batteryid;
	}

	public void setBatteryid(String batteryid) {
		this.batteryid = batteryid == null ? null : batteryid.trim();
	}
}