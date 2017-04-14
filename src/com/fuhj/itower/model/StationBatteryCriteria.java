package com.fuhj.itower.model;

import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class StationBatteryCriteria extends Criteria {

	public StationBatteryCriteria andStationBatteryIdIsNull() {
		addCriterion("station_battery_id is null");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdIsNotNull() {
		addCriterion("station_battery_id is not null");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdEqualTo(int value) {
		addCriterion("station_battery_id =", new Integer(value), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdNotEqualTo(int value) {
		addCriterion("station_battery_id <>", new Integer(value), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdGreaterThan(int value) {
		addCriterion("station_battery_id >", new Integer(value), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdGreaterThanOrEqualTo(int value) {
		addCriterion("station_battery_id >=", new Integer(value), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdLessThan(int value) {
		addCriterion("station_battery_id <", new Integer(value), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdLessThanOrEqualTo(int value) {
		addCriterion("station_battery_id <=", new Integer(value), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdIn(List<Integer> values) {
		addCriterion("station_battery_id in", values, "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdNotIn(List<Integer> values) {
		addCriterion("station_battery_id not in", values, "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdBetween(int value1, int value2) {
		addCriterion("station_battery_id between", new Integer(value1), new Integer(value2), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationBatteryIdNotBetween(int value1, int value2) {
		addCriterion("station_battery_id not between", new Integer(value1), new Integer(value2), "stationBatteryId");
		return this;
	}

	public StationBatteryCriteria andStationcodeIsNull() {
		addCriterion("stationCode is null");
		return this;
	}

	public StationBatteryCriteria andStationcodeIsNotNull() {
		addCriterion("stationCode is not null");
		return this;
	}

	public StationBatteryCriteria andStationcodeEqualTo(String value) {
		addCriterion("stationCode =", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeNotEqualTo(String value) {
		addCriterion("stationCode <>", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeGreaterThan(String value) {
		addCriterion("stationCode >", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeGreaterThanOrEqualTo(String value) {
		addCriterion("stationCode >=", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeLessThan(String value) {
		addCriterion("stationCode <", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeLessThanOrEqualTo(String value) {
		addCriterion("stationCode <=", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeLike(String value) {
		addCriterion("stationCode like", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeNotLike(String value) {
		addCriterion("stationCode not like", value, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeIn(List<String> values) {
		addCriterion("stationCode in", values, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeNotIn(List<String> values) {
		addCriterion("stationCode not in", values, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeBetween(String value1, String value2) {
		addCriterion("stationCode between", value1, value2, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationcodeNotBetween(String value1, String value2) {
		addCriterion("stationCode not between", value1, value2, "stationcode");
		return this;
	}

	public StationBatteryCriteria andStationsidIsNull() {
		addCriterion("stationSid is null");
		return this;
	}

	public StationBatteryCriteria andStationsidIsNotNull() {
		addCriterion("stationSid is not null");
		return this;
	}

	public StationBatteryCriteria andStationsidEqualTo(String value) {
		addCriterion("stationSid =", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidNotEqualTo(String value) {
		addCriterion("stationSid <>", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidGreaterThan(String value) {
		addCriterion("stationSid >", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidGreaterThanOrEqualTo(String value) {
		addCriterion("stationSid >=", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidLessThan(String value) {
		addCriterion("stationSid <", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidLessThanOrEqualTo(String value) {
		addCriterion("stationSid <=", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidLike(String value) {
		addCriterion("stationSid like", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidNotLike(String value) {
		addCriterion("stationSid not like", value, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidIn(List<String> values) {
		addCriterion("stationSid in", values, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidNotIn(List<String> values) {
		addCriterion("stationSid not in", values, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidBetween(String value1, String value2) {
		addCriterion("stationSid between", value1, value2, "stationsid");
		return this;
	}

	public StationBatteryCriteria andStationsidNotBetween(String value1, String value2) {
		addCriterion("stationSid not between", value1, value2, "stationsid");
		return this;
	}

	public StationBatteryCriteria andBatteryidIsNull() {
		addCriterion("batteryId is null");
		return this;
	}

	public StationBatteryCriteria andBatteryidIsNotNull() {
		addCriterion("batteryId is not null");
		return this;
	}

	public StationBatteryCriteria andBatteryidEqualTo(String value) {
		addCriterion("batteryId =", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidNotEqualTo(String value) {
		addCriterion("batteryId <>", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidGreaterThan(String value) {
		addCriterion("batteryId >", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidGreaterThanOrEqualTo(String value) {
		addCriterion("batteryId >=", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidLessThan(String value) {
		addCriterion("batteryId <", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidLessThanOrEqualTo(String value) {
		addCriterion("batteryId <=", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidLike(String value) {
		addCriterion("batteryId like", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidNotLike(String value) {
		addCriterion("batteryId not like", value, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidIn(List<String> values) {
		addCriterion("batteryId in", values, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidNotIn(List<String> values) {
		addCriterion("batteryId not in", values, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidBetween(String value1, String value2) {
		addCriterion("batteryId between", value1, value2, "batteryid");
		return this;
	}

	public StationBatteryCriteria andBatteryidNotBetween(String value1, String value2) {
		addCriterion("batteryId not between", value1, value2, "batteryid");
		return this;
	}
}