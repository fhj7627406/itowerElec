package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class ZbzItemCriteria extends Criteria {

	public ZbzItemCriteria andIdIsNull() {
		addCriterion("id is null");
		return this;
	}

	public ZbzItemCriteria andIdIsNotNull() {
		addCriterion("id is not null");
		return this;
	}

	public ZbzItemCriteria andIdEqualTo(int value) {
		addCriterion("id =", new Integer(value), "id");
		return this;
	}

	public ZbzItemCriteria andIdNotEqualTo(int value) {
		addCriterion("id <>", new Integer(value), "id");
		return this;
	}

	public ZbzItemCriteria andIdGreaterThan(int value) {
		addCriterion("id >", new Integer(value), "id");
		return this;
	}

	public ZbzItemCriteria andIdGreaterThanOrEqualTo(int value) {
		addCriterion("id >=", new Integer(value), "id");
		return this;
	}

	public ZbzItemCriteria andIdLessThan(int value) {
		addCriterion("id <", new Integer(value), "id");
		return this;
	}

	public ZbzItemCriteria andIdLessThanOrEqualTo(int value) {
		addCriterion("id <=", new Integer(value), "id");
		return this;
	}

	public ZbzItemCriteria andIdIn(List<Integer> values) {
		addCriterion("id in", values, "id");
		return this;
	}

	public ZbzItemCriteria andIdNotIn(List<Integer> values) {
		addCriterion("id not in", values, "id");
		return this;
	}

	public ZbzItemCriteria andIdBetween(int value1, int value2) {
		addCriterion("id between", new Integer(value1), new Integer(value2), "id");
		return this;
	}

	public ZbzItemCriteria andIdNotBetween(int value1, int value2) {
		addCriterion("id not between", new Integer(value1), new Integer(value2), "id");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdIsNull() {
		addCriterion("it_province_id is null");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdIsNotNull() {
		addCriterion("it_province_id is not null");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdEqualTo(String value) {
		addCriterion("it_province_id =", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdNotEqualTo(String value) {
		addCriterion("it_province_id <>", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdGreaterThan(String value) {
		addCriterion("it_province_id >", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_province_id >=", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdLessThan(String value) {
		addCriterion("it_province_id <", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdLessThanOrEqualTo(String value) {
		addCriterion("it_province_id <=", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdLike(String value) {
		addCriterion("it_province_id like", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdNotLike(String value) {
		addCriterion("it_province_id not like", value, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdIn(List<String> values) {
		addCriterion("it_province_id in", values, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdNotIn(List<String> values) {
		addCriterion("it_province_id not in", values, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdBetween(String value1, String value2) {
		addCriterion("it_province_id between", value1, value2, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItProvinceIdNotBetween(String value1, String value2) {
		addCriterion("it_province_id not between", value1, value2, "itProvinceId");
		return this;
	}

	public ZbzItemCriteria andItCityIdIsNull() {
		addCriterion("it_city_id is null");
		return this;
	}

	public ZbzItemCriteria andItCityIdIsNotNull() {
		addCriterion("it_city_id is not null");
		return this;
	}

	public ZbzItemCriteria andItCityIdEqualTo(String value) {
		addCriterion("it_city_id =", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdNotEqualTo(String value) {
		addCriterion("it_city_id <>", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdGreaterThan(String value) {
		addCriterion("it_city_id >", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_city_id >=", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdLessThan(String value) {
		addCriterion("it_city_id <", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdLessThanOrEqualTo(String value) {
		addCriterion("it_city_id <=", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdLike(String value) {
		addCriterion("it_city_id like", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdNotLike(String value) {
		addCriterion("it_city_id not like", value, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdIn(List<String> values) {
		addCriterion("it_city_id in", values, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdNotIn(List<String> values) {
		addCriterion("it_city_id not in", values, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdBetween(String value1, String value2) {
		addCriterion("it_city_id between", value1, value2, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItCityIdNotBetween(String value1, String value2) {
		addCriterion("it_city_id not between", value1, value2, "itCityId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdIsNull() {
		addCriterion("it_district_id is null");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdIsNotNull() {
		addCriterion("it_district_id is not null");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdEqualTo(String value) {
		addCriterion("it_district_id =", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdNotEqualTo(String value) {
		addCriterion("it_district_id <>", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdGreaterThan(String value) {
		addCriterion("it_district_id >", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_district_id >=", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdLessThan(String value) {
		addCriterion("it_district_id <", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdLessThanOrEqualTo(String value) {
		addCriterion("it_district_id <=", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdLike(String value) {
		addCriterion("it_district_id like", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdNotLike(String value) {
		addCriterion("it_district_id not like", value, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdIn(List<String> values) {
		addCriterion("it_district_id in", values, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdNotIn(List<String> values) {
		addCriterion("it_district_id not in", values, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdBetween(String value1, String value2) {
		addCriterion("it_district_id between", value1, value2, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andItDistrictIdNotBetween(String value1, String value2) {
		addCriterion("it_district_id not between", value1, value2, "itDistrictId");
		return this;
	}

	public ZbzItemCriteria andStationIdIsNull() {
		addCriterion("station_id is null");
		return this;
	}

	public ZbzItemCriteria andStationIdIsNotNull() {
		addCriterion("station_id is not null");
		return this;
	}

	public ZbzItemCriteria andStationIdEqualTo(int value) {
		addCriterion("station_id =", new Integer(value), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdNotEqualTo(int value) {
		addCriterion("station_id <>", new Integer(value), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdGreaterThan(int value) {
		addCriterion("station_id >", new Integer(value), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdGreaterThanOrEqualTo(int value) {
		addCriterion("station_id >=", new Integer(value), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdLessThan(int value) {
		addCriterion("station_id <", new Integer(value), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdLessThanOrEqualTo(int value) {
		addCriterion("station_id <=", new Integer(value), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdIn(List<Integer> values) {
		addCriterion("station_id in", values, "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdNotIn(List<Integer> values) {
		addCriterion("station_id not in", values, "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdBetween(int value1, int value2) {
		addCriterion("station_id between", new Integer(value1), new Integer(value2), "stationId");
		return this;
	}

	public ZbzItemCriteria andStationIdNotBetween(int value1, int value2) {
		addCriterion("station_id not between", new Integer(value1), new Integer(value2), "stationId");
		return this;
	}

	public ZbzItemCriteria andUpdateUserIsNull() {
		addCriterion("update_user is null");
		return this;
	}

	public ZbzItemCriteria andUpdateUserIsNotNull() {
		addCriterion("update_user is not null");
		return this;
	}

	public ZbzItemCriteria andUpdateUserEqualTo(int value) {
		addCriterion("update_user =", new Integer(value), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserNotEqualTo(int value) {
		addCriterion("update_user <>", new Integer(value), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserGreaterThan(int value) {
		addCriterion("update_user >", new Integer(value), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserGreaterThanOrEqualTo(int value) {
		addCriterion("update_user >=", new Integer(value), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserLessThan(int value) {
		addCriterion("update_user <", new Integer(value), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserLessThanOrEqualTo(int value) {
		addCriterion("update_user <=", new Integer(value), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserIn(List<Integer> values) {
		addCriterion("update_user in", values, "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserNotIn(List<Integer> values) {
		addCriterion("update_user not in", values, "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserBetween(int value1, int value2) {
		addCriterion("update_user between", new Integer(value1), new Integer(value2), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateUserNotBetween(int value1, int value2) {
		addCriterion("update_user not between", new Integer(value1), new Integer(value2), "updateUser");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeIsNull() {
		addCriterion("update_time is null");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeIsNotNull() {
		addCriterion("update_time is not null");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeEqualTo(Date value) {
		addCriterion("update_time =", value, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeNotEqualTo(Date value) {
		addCriterion("update_time <>", value, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeGreaterThan(Date value) {
		addCriterion("update_time >", value, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
		addCriterion("update_time >=", value, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeLessThan(Date value) {
		addCriterion("update_time <", value, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeLessThanOrEqualTo(Date value) {
		addCriterion("update_time <=", value, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeIn(List<Date> values) {
		addCriterion("update_time in", values, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeNotIn(List<Date> values) {
		addCriterion("update_time not in", values, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeBetween(Date value1, Date value2) {
		addCriterion("update_time between", value1, value2, "updateTime");
		return this;
	}

	public ZbzItemCriteria andUpdateTimeNotBetween(Date value1, Date value2) {
		addCriterion("update_time not between", value1, value2, "updateTime");
		return this;
	}

	public ZbzItemCriteria andStatusIsNull() {
		addCriterion("status is null");
		return this;
	}

	public ZbzItemCriteria andStatusIsNotNull() {
		addCriterion("status is not null");
		return this;
	}

	public ZbzItemCriteria andStatusEqualTo(int value) {
		addCriterion("status =", new Integer(value), "status");
		return this;
	}

	public ZbzItemCriteria andStatusNotEqualTo(int value) {
		addCriterion("status <>", new Integer(value), "status");
		return this;
	}

	public ZbzItemCriteria andStatusGreaterThan(int value) {
		addCriterion("status >", new Integer(value), "status");
		return this;
	}

	public ZbzItemCriteria andStatusGreaterThanOrEqualTo(int value) {
		addCriterion("status >=", new Integer(value), "status");
		return this;
	}

	public ZbzItemCriteria andStatusLessThan(int value) {
		addCriterion("status <", new Integer(value), "status");
		return this;
	}

	public ZbzItemCriteria andStatusLessThanOrEqualTo(int value) {
		addCriterion("status <=", new Integer(value), "status");
		return this;
	}

	public ZbzItemCriteria andStatusIn(List<Integer> values) {
		addCriterion("status in", values, "status");
		return this;
	}

	public ZbzItemCriteria andStatusNotIn(List<Integer> values) {
		addCriterion("status not in", values, "status");
		return this;
	}

	public ZbzItemCriteria andStatusBetween(int value1, int value2) {
		addCriterion("status between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public ZbzItemCriteria andStatusNotBetween(int value1, int value2) {
		addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public ZbzItemCriteria andRemarkIsNull() {
		addCriterion("remark is null");
		return this;
	}

	public ZbzItemCriteria andRemarkIsNotNull() {
		addCriterion("remark is not null");
		return this;
	}

	public ZbzItemCriteria andRemarkEqualTo(String value) {
		addCriterion("remark =", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkNotEqualTo(String value) {
		addCriterion("remark <>", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkGreaterThan(String value) {
		addCriterion("remark >", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkGreaterThanOrEqualTo(String value) {
		addCriterion("remark >=", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkLessThan(String value) {
		addCriterion("remark <", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkLessThanOrEqualTo(String value) {
		addCriterion("remark <=", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkLike(String value) {
		addCriterion("remark like", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkNotLike(String value) {
		addCriterion("remark not like", value, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkIn(List<String> values) {
		addCriterion("remark in", values, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkNotIn(List<String> values) {
		addCriterion("remark not in", values, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkBetween(String value1, String value2) {
		addCriterion("remark between", value1, value2, "remark");
		return this;
	}

	public ZbzItemCriteria andRemarkNotBetween(String value1, String value2) {
		addCriterion("remark not between", value1, value2, "remark");
		return this;
	}
}