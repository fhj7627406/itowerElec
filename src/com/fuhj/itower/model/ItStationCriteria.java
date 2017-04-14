package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class ItStationCriteria extends Criteria {

	public ItStationCriteria andItStationIdIsNull() {
		addCriterion("it_station_id is null");
		return this;
	}

	public ItStationCriteria andItStationIdIsNotNull() {
		addCriterion("it_station_id is not null");
		return this;
	}

	public ItStationCriteria andItStationIdEqualTo(int value) {
		addCriterion("it_station_id =", new Integer(value), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdNotEqualTo(int value) {
		addCriterion("it_station_id <>", new Integer(value), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdGreaterThan(int value) {
		addCriterion("it_station_id >", new Integer(value), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdGreaterThanOrEqualTo(int value) {
		addCriterion("it_station_id >=", new Integer(value), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdLessThan(int value) {
		addCriterion("it_station_id <", new Integer(value), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdLessThanOrEqualTo(int value) {
		addCriterion("it_station_id <=", new Integer(value), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdIn(List<Integer> values) {
		addCriterion("it_station_id in", values, "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdNotIn(List<Integer> values) {
		addCriterion("it_station_id not in", values, "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdBetween(int value1, int value2) {
		addCriterion("it_station_id between", new Integer(value1), new Integer(value2), "itStationId");
		return this;
	}

	public ItStationCriteria andItStationIdNotBetween(int value1, int value2) {
		addCriterion("it_station_id not between", new Integer(value1), new Integer(value2), "itStationId");
		return this;
	}

	public ItStationCriteria andItProvinceIdIsNull() {
		addCriterion("it_province_id is null");
		return this;
	}

	public ItStationCriteria andItProvinceIdIsNotNull() {
		addCriterion("it_province_id is not null");
		return this;
	}

	public ItStationCriteria andItProvinceIdEqualTo(String value) {
		addCriterion("it_province_id =", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdNotEqualTo(String value) {
		addCriterion("it_province_id <>", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdGreaterThan(String value) {
		addCriterion("it_province_id >", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_province_id >=", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdLessThan(String value) {
		addCriterion("it_province_id <", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdLessThanOrEqualTo(String value) {
		addCriterion("it_province_id <=", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdLike(String value) {
		addCriterion("it_province_id like", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdNotLike(String value) {
		addCriterion("it_province_id not like", value, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdIn(List<String> values) {
		addCriterion("it_province_id in", values, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdNotIn(List<String> values) {
		addCriterion("it_province_id not in", values, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdBetween(String value1, String value2) {
		addCriterion("it_province_id between", value1, value2, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItProvinceIdNotBetween(String value1, String value2) {
		addCriterion("it_province_id not between", value1, value2, "itProvinceId");
		return this;
	}

	public ItStationCriteria andItCityIdIsNull() {
		addCriterion("it_city_id is null");
		return this;
	}

	public ItStationCriteria andItCityIdIsNotNull() {
		addCriterion("it_city_id is not null");
		return this;
	}

	public ItStationCriteria andItCityIdEqualTo(String value) {
		addCriterion("it_city_id =", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdNotEqualTo(String value) {
		addCriterion("it_city_id <>", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdGreaterThan(String value) {
		addCriterion("it_city_id >", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_city_id >=", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdLessThan(String value) {
		addCriterion("it_city_id <", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdLessThanOrEqualTo(String value) {
		addCriterion("it_city_id <=", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdLike(String value) {
		addCriterion("it_city_id like", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdNotLike(String value) {
		addCriterion("it_city_id not like", value, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdIn(List<String> values) {
		addCriterion("it_city_id in", values, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdNotIn(List<String> values) {
		addCriterion("it_city_id not in", values, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdBetween(String value1, String value2) {
		addCriterion("it_city_id between", value1, value2, "itCityId");
		return this;
	}

	public ItStationCriteria andItCityIdNotBetween(String value1, String value2) {
		addCriterion("it_city_id not between", value1, value2, "itCityId");
		return this;
	}

	public ItStationCriteria andItDistrictIdIsNull() {
		addCriterion("it_district_id is null");
		return this;
	}

	public ItStationCriteria andItDistrictIdIsNotNull() {
		addCriterion("it_district_id is not null");
		return this;
	}

	public ItStationCriteria andItDistrictIdEqualTo(String value) {
		addCriterion("it_district_id =", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdNotEqualTo(String value) {
		addCriterion("it_district_id <>", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdGreaterThan(String value) {
		addCriterion("it_district_id >", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_district_id >=", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdLessThan(String value) {
		addCriterion("it_district_id <", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdLessThanOrEqualTo(String value) {
		addCriterion("it_district_id <=", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdLike(String value) {
		addCriterion("it_district_id like", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdNotLike(String value) {
		addCriterion("it_district_id not like", value, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdIn(List<String> values) {
		addCriterion("it_district_id in", values, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdNotIn(List<String> values) {
		addCriterion("it_district_id not in", values, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdBetween(String value1, String value2) {
		addCriterion("it_district_id between", value1, value2, "itDistrictId");
		return this;
	}

	public ItStationCriteria andItDistrictIdNotBetween(String value1, String value2) {
		addCriterion("it_district_id not between", value1, value2, "itDistrictId");
		return this;
	}

	public ItStationCriteria andStationNameIsNull() {
		addCriterion("station_name is null");
		return this;
	}

	public ItStationCriteria andStationNameIsNotNull() {
		addCriterion("station_name is not null");
		return this;
	}

	public ItStationCriteria andStationNameEqualTo(String value) {
		addCriterion("station_name =", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameNotEqualTo(String value) {
		addCriterion("station_name <>", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameGreaterThan(String value) {
		addCriterion("station_name >", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameGreaterThanOrEqualTo(String value) {
		addCriterion("station_name >=", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameLessThan(String value) {
		addCriterion("station_name <", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameLessThanOrEqualTo(String value) {
		addCriterion("station_name <=", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameLike(String value) {
		addCriterion("station_name like", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameNotLike(String value) {
		addCriterion("station_name not like", value, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameIn(List<String> values) {
		addCriterion("station_name in", values, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameNotIn(List<String> values) {
		addCriterion("station_name not in", values, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameBetween(String value1, String value2) {
		addCriterion("station_name between", value1, value2, "stationName");
		return this;
	}

	public ItStationCriteria andStationNameNotBetween(String value1, String value2) {
		addCriterion("station_name not between", value1, value2, "stationName");
		return this;
	}

	public ItStationCriteria andStationCodeIsNull() {
		addCriterion("station_code is null");
		return this;
	}

	public ItStationCriteria andStationCodeIsNotNull() {
		addCriterion("station_code is not null");
		return this;
	}

	public ItStationCriteria andStationCodeEqualTo(String value) {
		addCriterion("station_code =", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeNotEqualTo(String value) {
		addCriterion("station_code <>", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeGreaterThan(String value) {
		addCriterion("station_code >", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeGreaterThanOrEqualTo(String value) {
		addCriterion("station_code >=", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeLessThan(String value) {
		addCriterion("station_code <", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeLessThanOrEqualTo(String value) {
		addCriterion("station_code <=", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeLike(String value) {
		addCriterion("station_code like", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeNotLike(String value) {
		addCriterion("station_code not like", value, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeIn(List<String> values) {
		addCriterion("station_code in", values, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeNotIn(List<String> values) {
		addCriterion("station_code not in", values, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeBetween(String value1, String value2) {
		addCriterion("station_code between", value1, value2, "stationCode");
		return this;
	}

	public ItStationCriteria andStationCodeNotBetween(String value1, String value2) {
		addCriterion("station_code not between", value1, value2, "stationCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeIsNull() {
		addCriterion("station_sys_code is null");
		return this;
	}

	public ItStationCriteria andStationSysCodeIsNotNull() {
		addCriterion("station_sys_code is not null");
		return this;
	}

	public ItStationCriteria andStationSysCodeEqualTo(String value) {
		addCriterion("station_sys_code =", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeNotEqualTo(String value) {
		addCriterion("station_sys_code <>", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeGreaterThan(String value) {
		addCriterion("station_sys_code >", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeGreaterThanOrEqualTo(String value) {
		addCriterion("station_sys_code >=", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeLessThan(String value) {
		addCriterion("station_sys_code <", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeLessThanOrEqualTo(String value) {
		addCriterion("station_sys_code <=", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeLike(String value) {
		addCriterion("station_sys_code like", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeNotLike(String value) {
		addCriterion("station_sys_code not like", value, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeIn(List<String> values) {
		addCriterion("station_sys_code in", values, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeNotIn(List<String> values) {
		addCriterion("station_sys_code not in", values, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeBetween(String value1, String value2) {
		addCriterion("station_sys_code between", value1, value2, "stationSysCode");
		return this;
	}

	public ItStationCriteria andStationSysCodeNotBetween(String value1, String value2) {
		addCriterion("station_sys_code not between", value1, value2, "stationSysCode");
		return this;
	}

	public ItStationCriteria andLngIsNull() {
		addCriterion("lng is null");
		return this;
	}

	public ItStationCriteria andLngIsNotNull() {
		addCriterion("lng is not null");
		return this;
	}

	public ItStationCriteria andLngEqualTo(String value) {
		addCriterion("lng =", value, "lng");
		return this;
	}

	public ItStationCriteria andLngNotEqualTo(String value) {
		addCriterion("lng <>", value, "lng");
		return this;
	}

	public ItStationCriteria andLngGreaterThan(String value) {
		addCriterion("lng >", value, "lng");
		return this;
	}

	public ItStationCriteria andLngGreaterThanOrEqualTo(String value) {
		addCriterion("lng >=", value, "lng");
		return this;
	}

	public ItStationCriteria andLngLessThan(String value) {
		addCriterion("lng <", value, "lng");
		return this;
	}

	public ItStationCriteria andLngLessThanOrEqualTo(String value) {
		addCriterion("lng <=", value, "lng");
		return this;
	}

	public ItStationCriteria andLngLike(String value) {
		addCriterion("lng like", value, "lng");
		return this;
	}

	public ItStationCriteria andLngNotLike(String value) {
		addCriterion("lng not like", value, "lng");
		return this;
	}

	public ItStationCriteria andLngIn(List<String> values) {
		addCriterion("lng in", values, "lng");
		return this;
	}

	public ItStationCriteria andLngNotIn(List<String> values) {
		addCriterion("lng not in", values, "lng");
		return this;
	}

	public ItStationCriteria andLngBetween(String value1, String value2) {
		addCriterion("lng between", value1, value2, "lng");
		return this;
	}

	public ItStationCriteria andLngNotBetween(String value1, String value2) {
		addCriterion("lng not between", value1, value2, "lng");
		return this;
	}

	public ItStationCriteria andLatIsNull() {
		addCriterion("lat is null");
		return this;
	}

	public ItStationCriteria andLatIsNotNull() {
		addCriterion("lat is not null");
		return this;
	}

	public ItStationCriteria andLatEqualTo(String value) {
		addCriterion("lat =", value, "lat");
		return this;
	}

	public ItStationCriteria andLatNotEqualTo(String value) {
		addCriterion("lat <>", value, "lat");
		return this;
	}

	public ItStationCriteria andLatGreaterThan(String value) {
		addCriterion("lat >", value, "lat");
		return this;
	}

	public ItStationCriteria andLatGreaterThanOrEqualTo(String value) {
		addCriterion("lat >=", value, "lat");
		return this;
	}

	public ItStationCriteria andLatLessThan(String value) {
		addCriterion("lat <", value, "lat");
		return this;
	}

	public ItStationCriteria andLatLessThanOrEqualTo(String value) {
		addCriterion("lat <=", value, "lat");
		return this;
	}

	public ItStationCriteria andLatLike(String value) {
		addCriterion("lat like", value, "lat");
		return this;
	}

	public ItStationCriteria andLatNotLike(String value) {
		addCriterion("lat not like", value, "lat");
		return this;
	}

	public ItStationCriteria andLatIn(List<String> values) {
		addCriterion("lat in", values, "lat");
		return this;
	}

	public ItStationCriteria andLatNotIn(List<String> values) {
		addCriterion("lat not in", values, "lat");
		return this;
	}

	public ItStationCriteria andLatBetween(String value1, String value2) {
		addCriterion("lat between", value1, value2, "lat");
		return this;
	}

	public ItStationCriteria andLatNotBetween(String value1, String value2) {
		addCriterion("lat not between", value1, value2, "lat");
		return this;
	}

	public ItStationCriteria andAddressIsNull() {
		addCriterion("address is null");
		return this;
	}

	public ItStationCriteria andAddressIsNotNull() {
		addCriterion("address is not null");
		return this;
	}

	public ItStationCriteria andAddressEqualTo(String value) {
		addCriterion("address =", value, "address");
		return this;
	}

	public ItStationCriteria andAddressNotEqualTo(String value) {
		addCriterion("address <>", value, "address");
		return this;
	}

	public ItStationCriteria andAddressGreaterThan(String value) {
		addCriterion("address >", value, "address");
		return this;
	}

	public ItStationCriteria andAddressGreaterThanOrEqualTo(String value) {
		addCriterion("address >=", value, "address");
		return this;
	}

	public ItStationCriteria andAddressLessThan(String value) {
		addCriterion("address <", value, "address");
		return this;
	}

	public ItStationCriteria andAddressLessThanOrEqualTo(String value) {
		addCriterion("address <=", value, "address");
		return this;
	}

	public ItStationCriteria andAddressLike(String value) {
		addCriterion("address like", value, "address");
		return this;
	}

	public ItStationCriteria andAddressNotLike(String value) {
		addCriterion("address not like", value, "address");
		return this;
	}

	public ItStationCriteria andAddressIn(List<String> values) {
		addCriterion("address in", values, "address");
		return this;
	}

	public ItStationCriteria andAddressNotIn(List<String> values) {
		addCriterion("address not in", values, "address");
		return this;
	}

	public ItStationCriteria andAddressBetween(String value1, String value2) {
		addCriterion("address between", value1, value2, "address");
		return this;
	}

	public ItStationCriteria andAddressNotBetween(String value1, String value2) {
		addCriterion("address not between", value1, value2, "address");
		return this;
	}

	public ItStationCriteria andOriginIdIsNull() {
		addCriterion("origin_id is null");
		return this;
	}

	public ItStationCriteria andOriginIdIsNotNull() {
		addCriterion("origin_id is not null");
		return this;
	}

	public ItStationCriteria andOriginIdEqualTo(int value) {
		addCriterion("origin_id =", new Integer(value), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdNotEqualTo(int value) {
		addCriterion("origin_id <>", new Integer(value), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdGreaterThan(int value) {
		addCriterion("origin_id >", new Integer(value), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdGreaterThanOrEqualTo(int value) {
		addCriterion("origin_id >=", new Integer(value), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdLessThan(int value) {
		addCriterion("origin_id <", new Integer(value), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdLessThanOrEqualTo(int value) {
		addCriterion("origin_id <=", new Integer(value), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdIn(List<Integer> values) {
		addCriterion("origin_id in", values, "originId");
		return this;
	}

	public ItStationCriteria andOriginIdNotIn(List<Integer> values) {
		addCriterion("origin_id not in", values, "originId");
		return this;
	}

	public ItStationCriteria andOriginIdBetween(int value1, int value2) {
		addCriterion("origin_id between", new Integer(value1), new Integer(value2), "originId");
		return this;
	}

	public ItStationCriteria andOriginIdNotBetween(int value1, int value2) {
		addCriterion("origin_id not between", new Integer(value1), new Integer(value2), "originId");
		return this;
	}

	public ItStationCriteria andOperatorIsNull() {
		addCriterion("operator is null");
		return this;
	}

	public ItStationCriteria andOperatorIsNotNull() {
		addCriterion("operator is not null");
		return this;
	}

	public ItStationCriteria andOperatorEqualTo(int value) {
		addCriterion("operator =", new Integer(value), "operator");
		return this;
	}

	public ItStationCriteria andOperatorNotEqualTo(int value) {
		addCriterion("operator <>", new Integer(value), "operator");
		return this;
	}

	public ItStationCriteria andOperatorGreaterThan(int value) {
		addCriterion("operator >", new Integer(value), "operator");
		return this;
	}

	public ItStationCriteria andOperatorGreaterThanOrEqualTo(int value) {
		addCriterion("operator >=", new Integer(value), "operator");
		return this;
	}

	public ItStationCriteria andOperatorLessThan(int value) {
		addCriterion("operator <", new Integer(value), "operator");
		return this;
	}

	public ItStationCriteria andOperatorLessThanOrEqualTo(int value) {
		addCriterion("operator <=", new Integer(value), "operator");
		return this;
	}

	public ItStationCriteria andOperatorIn(List<Integer> values) {
		addCriterion("operator in", values, "operator");
		return this;
	}

	public ItStationCriteria andOperatorNotIn(List<Integer> values) {
		addCriterion("operator not in", values, "operator");
		return this;
	}

	public ItStationCriteria andOperatorBetween(int value1, int value2) {
		addCriterion("operator between", new Integer(value1), new Integer(value2), "operator");
		return this;
	}

	public ItStationCriteria andOperatorNotBetween(int value1, int value2) {
		addCriterion("operator not between", new Integer(value1), new Integer(value2), "operator");
		return this;
	}

	public ItStationCriteria andSceneIdIsNull() {
		addCriterion("scene_id is null");
		return this;
	}

	public ItStationCriteria andSceneIdIsNotNull() {
		addCriterion("scene_id is not null");
		return this;
	}

	public ItStationCriteria andSceneIdEqualTo(int value) {
		addCriterion("scene_id =", new Integer(value), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdNotEqualTo(int value) {
		addCriterion("scene_id <>", new Integer(value), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdGreaterThan(int value) {
		addCriterion("scene_id >", new Integer(value), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdGreaterThanOrEqualTo(int value) {
		addCriterion("scene_id >=", new Integer(value), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdLessThan(int value) {
		addCriterion("scene_id <", new Integer(value), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdLessThanOrEqualTo(int value) {
		addCriterion("scene_id <=", new Integer(value), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdIn(List<Integer> values) {
		addCriterion("scene_id in", values, "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdNotIn(List<Integer> values) {
		addCriterion("scene_id not in", values, "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdBetween(int value1, int value2) {
		addCriterion("scene_id between", new Integer(value1), new Integer(value2), "sceneId");
		return this;
	}

	public ItStationCriteria andSceneIdNotBetween(int value1, int value2) {
		addCriterion("scene_id not between", new Integer(value1), new Integer(value2), "sceneId");
		return this;
	}

	public ItStationCriteria andAliasCmIsNull() {
		addCriterion("alias_cm is null");
		return this;
	}

	public ItStationCriteria andAliasCmIsNotNull() {
		addCriterion("alias_cm is not null");
		return this;
	}

	public ItStationCriteria andAliasCmEqualTo(String value) {
		addCriterion("alias_cm =", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmNotEqualTo(String value) {
		addCriterion("alias_cm <>", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmGreaterThan(String value) {
		addCriterion("alias_cm >", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmGreaterThanOrEqualTo(String value) {
		addCriterion("alias_cm >=", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmLessThan(String value) {
		addCriterion("alias_cm <", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmLessThanOrEqualTo(String value) {
		addCriterion("alias_cm <=", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmLike(String value) {
		addCriterion("alias_cm like", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmNotLike(String value) {
		addCriterion("alias_cm not like", value, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmIn(List<String> values) {
		addCriterion("alias_cm in", values, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmNotIn(List<String> values) {
		addCriterion("alias_cm not in", values, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmBetween(String value1, String value2) {
		addCriterion("alias_cm between", value1, value2, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCmNotBetween(String value1, String value2) {
		addCriterion("alias_cm not between", value1, value2, "aliasCm");
		return this;
	}

	public ItStationCriteria andAliasCuIsNull() {
		addCriterion("alias_cu is null");
		return this;
	}

	public ItStationCriteria andAliasCuIsNotNull() {
		addCriterion("alias_cu is not null");
		return this;
	}

	public ItStationCriteria andAliasCuEqualTo(String value) {
		addCriterion("alias_cu =", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuNotEqualTo(String value) {
		addCriterion("alias_cu <>", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuGreaterThan(String value) {
		addCriterion("alias_cu >", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuGreaterThanOrEqualTo(String value) {
		addCriterion("alias_cu >=", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuLessThan(String value) {
		addCriterion("alias_cu <", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuLessThanOrEqualTo(String value) {
		addCriterion("alias_cu <=", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuLike(String value) {
		addCriterion("alias_cu like", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuNotLike(String value) {
		addCriterion("alias_cu not like", value, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuIn(List<String> values) {
		addCriterion("alias_cu in", values, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuNotIn(List<String> values) {
		addCriterion("alias_cu not in", values, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuBetween(String value1, String value2) {
		addCriterion("alias_cu between", value1, value2, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCuNotBetween(String value1, String value2) {
		addCriterion("alias_cu not between", value1, value2, "aliasCu");
		return this;
	}

	public ItStationCriteria andAliasCtIsNull() {
		addCriterion("alias_ct is null");
		return this;
	}

	public ItStationCriteria andAliasCtIsNotNull() {
		addCriterion("alias_ct is not null");
		return this;
	}

	public ItStationCriteria andAliasCtEqualTo(String value) {
		addCriterion("alias_ct =", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtNotEqualTo(String value) {
		addCriterion("alias_ct <>", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtGreaterThan(String value) {
		addCriterion("alias_ct >", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtGreaterThanOrEqualTo(String value) {
		addCriterion("alias_ct >=", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtLessThan(String value) {
		addCriterion("alias_ct <", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtLessThanOrEqualTo(String value) {
		addCriterion("alias_ct <=", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtLike(String value) {
		addCriterion("alias_ct like", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtNotLike(String value) {
		addCriterion("alias_ct not like", value, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtIn(List<String> values) {
		addCriterion("alias_ct in", values, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtNotIn(List<String> values) {
		addCriterion("alias_ct not in", values, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtBetween(String value1, String value2) {
		addCriterion("alias_ct between", value1, value2, "aliasCt");
		return this;
	}

	public ItStationCriteria andAliasCtNotBetween(String value1, String value2) {
		addCriterion("alias_ct not between", value1, value2, "aliasCt");
		return this;
	}

	public ItStationCriteria andStationTypeIdIsNull() {
		addCriterion("station_type_id is null");
		return this;
	}

	public ItStationCriteria andStationTypeIdIsNotNull() {
		addCriterion("station_type_id is not null");
		return this;
	}

	public ItStationCriteria andStationTypeIdEqualTo(int value) {
		addCriterion("station_type_id =", new Integer(value), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdNotEqualTo(int value) {
		addCriterion("station_type_id <>", new Integer(value), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdGreaterThan(int value) {
		addCriterion("station_type_id >", new Integer(value), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdGreaterThanOrEqualTo(int value) {
		addCriterion("station_type_id >=", new Integer(value), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdLessThan(int value) {
		addCriterion("station_type_id <", new Integer(value), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdLessThanOrEqualTo(int value) {
		addCriterion("station_type_id <=", new Integer(value), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdIn(List<Integer> values) {
		addCriterion("station_type_id in", values, "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdNotIn(List<Integer> values) {
		addCriterion("station_type_id not in", values, "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdBetween(int value1, int value2) {
		addCriterion("station_type_id between", new Integer(value1), new Integer(value2), "stationTypeId");
		return this;
	}

	public ItStationCriteria andStationTypeIdNotBetween(int value1, int value2) {
		addCriterion("station_type_id not between", new Integer(value1), new Integer(value2), "stationTypeId");
		return this;
	}

	public ItStationCriteria andAreaManagerIsNull() {
		addCriterion("area_manager is null");
		return this;
	}

	public ItStationCriteria andAreaManagerIsNotNull() {
		addCriterion("area_manager is not null");
		return this;
	}

	public ItStationCriteria andAreaManagerEqualTo(String value) {
		addCriterion("area_manager =", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerNotEqualTo(String value) {
		addCriterion("area_manager <>", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerGreaterThan(String value) {
		addCriterion("area_manager >", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerGreaterThanOrEqualTo(String value) {
		addCriterion("area_manager >=", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerLessThan(String value) {
		addCriterion("area_manager <", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerLessThanOrEqualTo(String value) {
		addCriterion("area_manager <=", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerLike(String value) {
		addCriterion("area_manager like", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerNotLike(String value) {
		addCriterion("area_manager not like", value, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerIn(List<String> values) {
		addCriterion("area_manager in", values, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerNotIn(List<String> values) {
		addCriterion("area_manager not in", values, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerBetween(String value1, String value2) {
		addCriterion("area_manager between", value1, value2, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerNotBetween(String value1, String value2) {
		addCriterion("area_manager not between", value1, value2, "areaManager");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneIsNull() {
		addCriterion("area_manager_phone is null");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneIsNotNull() {
		addCriterion("area_manager_phone is not null");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneEqualTo(String value) {
		addCriterion("area_manager_phone =", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneNotEqualTo(String value) {
		addCriterion("area_manager_phone <>", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneGreaterThan(String value) {
		addCriterion("area_manager_phone >", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneGreaterThanOrEqualTo(String value) {
		addCriterion("area_manager_phone >=", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneLessThan(String value) {
		addCriterion("area_manager_phone <", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneLessThanOrEqualTo(String value) {
		addCriterion("area_manager_phone <=", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneLike(String value) {
		addCriterion("area_manager_phone like", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneNotLike(String value) {
		addCriterion("area_manager_phone not like", value, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneIn(List<String> values) {
		addCriterion("area_manager_phone in", values, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneNotIn(List<String> values) {
		addCriterion("area_manager_phone not in", values, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneBetween(String value1, String value2) {
		addCriterion("area_manager_phone between", value1, value2, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andAreaManagerPhoneNotBetween(String value1, String value2) {
		addCriterion("area_manager_phone not between", value1, value2, "areaManagerPhone");
		return this;
	}

	public ItStationCriteria andFsuManufactorIsNull() {
		addCriterion("fsu_manufactor is null");
		return this;
	}

	public ItStationCriteria andFsuManufactorIsNotNull() {
		addCriterion("fsu_manufactor is not null");
		return this;
	}

	public ItStationCriteria andFsuManufactorEqualTo(String value) {
		addCriterion("fsu_manufactor =", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorNotEqualTo(String value) {
		addCriterion("fsu_manufactor <>", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorGreaterThan(String value) {
		addCriterion("fsu_manufactor >", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorGreaterThanOrEqualTo(String value) {
		addCriterion("fsu_manufactor >=", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorLessThan(String value) {
		addCriterion("fsu_manufactor <", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorLessThanOrEqualTo(String value) {
		addCriterion("fsu_manufactor <=", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorLike(String value) {
		addCriterion("fsu_manufactor like", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorNotLike(String value) {
		addCriterion("fsu_manufactor not like", value, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorIn(List<String> values) {
		addCriterion("fsu_manufactor in", values, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorNotIn(List<String> values) {
		addCriterion("fsu_manufactor not in", values, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorBetween(String value1, String value2) {
		addCriterion("fsu_manufactor between", value1, value2, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andFsuManufactorNotBetween(String value1, String value2) {
		addCriterion("fsu_manufactor not between", value1, value2, "fsuManufactor");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpIsNull() {
		addCriterion("maintenance_corp is null");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpIsNotNull() {
		addCriterion("maintenance_corp is not null");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpEqualTo(String value) {
		addCriterion("maintenance_corp =", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpNotEqualTo(String value) {
		addCriterion("maintenance_corp <>", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpGreaterThan(String value) {
		addCriterion("maintenance_corp >", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpGreaterThanOrEqualTo(String value) {
		addCriterion("maintenance_corp >=", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpLessThan(String value) {
		addCriterion("maintenance_corp <", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpLessThanOrEqualTo(String value) {
		addCriterion("maintenance_corp <=", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpLike(String value) {
		addCriterion("maintenance_corp like", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpNotLike(String value) {
		addCriterion("maintenance_corp not like", value, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpIn(List<String> values) {
		addCriterion("maintenance_corp in", values, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpNotIn(List<String> values) {
		addCriterion("maintenance_corp not in", values, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpBetween(String value1, String value2) {
		addCriterion("maintenance_corp between", value1, value2, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andMaintenanceCorpNotBetween(String value1, String value2) {
		addCriterion("maintenance_corp not between", value1, value2, "maintenanceCorp");
		return this;
	}

	public ItStationCriteria andAcceptanceDateIsNull() {
		addCriterion("acceptance_date is null");
		return this;
	}

	public ItStationCriteria andAcceptanceDateIsNotNull() {
		addCriterion("acceptance_date is not null");
		return this;
	}

	public ItStationCriteria andAcceptanceDateEqualTo(Date value) {
		addCriterionForJDBCDate("acceptance_date =", value, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateNotEqualTo(Date value) {
		addCriterionForJDBCDate("acceptance_date <>", value, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateGreaterThan(Date value) {
		addCriterionForJDBCDate("acceptance_date >", value, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateGreaterThanOrEqualTo(Date value) {
		addCriterionForJDBCDate("acceptance_date >=", value, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateLessThan(Date value) {
		addCriterionForJDBCDate("acceptance_date <", value, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateLessThanOrEqualTo(Date value) {
		addCriterionForJDBCDate("acceptance_date <=", value, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateIn(List<Date> values) {
		addCriterionForJDBCDate("acceptance_date in", values, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateNotIn(List<Date> values) {
		addCriterionForJDBCDate("acceptance_date not in", values, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateBetween(Date value1, Date value2) {
		addCriterionForJDBCDate("acceptance_date between", value1, value2, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andAcceptanceDateNotBetween(Date value1, Date value2) {
		addCriterionForJDBCDate("acceptance_date not between", value1, value2, "acceptanceDate");
		return this;
	}

	public ItStationCriteria andOutsideCustomerIsNull() {
		addCriterion("outside_customer is null");
		return this;
	}

	public ItStationCriteria andOutsideCustomerIsNotNull() {
		addCriterion("outside_customer is not null");
		return this;
	}

	public ItStationCriteria andOutsideCustomerEqualTo(String value) {
		addCriterion("outside_customer =", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerNotEqualTo(String value) {
		addCriterion("outside_customer <>", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerGreaterThan(String value) {
		addCriterion("outside_customer >", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerGreaterThanOrEqualTo(String value) {
		addCriterion("outside_customer >=", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerLessThan(String value) {
		addCriterion("outside_customer <", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerLessThanOrEqualTo(String value) {
		addCriterion("outside_customer <=", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerLike(String value) {
		addCriterion("outside_customer like", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerNotLike(String value) {
		addCriterion("outside_customer not like", value, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerIn(List<String> values) {
		addCriterion("outside_customer in", values, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerNotIn(List<String> values) {
		addCriterion("outside_customer not in", values, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerBetween(String value1, String value2) {
		addCriterion("outside_customer between", value1, value2, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andOutsideCustomerNotBetween(String value1, String value2) {
		addCriterion("outside_customer not between", value1, value2, "outsideCustomer");
		return this;
	}

	public ItStationCriteria andRemarkIsNull() {
		addCriterion("remark is null");
		return this;
	}

	public ItStationCriteria andRemarkIsNotNull() {
		addCriterion("remark is not null");
		return this;
	}

	public ItStationCriteria andRemarkEqualTo(String value) {
		addCriterion("remark =", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkNotEqualTo(String value) {
		addCriterion("remark <>", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkGreaterThan(String value) {
		addCriterion("remark >", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkGreaterThanOrEqualTo(String value) {
		addCriterion("remark >=", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkLessThan(String value) {
		addCriterion("remark <", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkLessThanOrEqualTo(String value) {
		addCriterion("remark <=", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkLike(String value) {
		addCriterion("remark like", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkNotLike(String value) {
		addCriterion("remark not like", value, "remark");
		return this;
	}

	public ItStationCriteria andRemarkIn(List<String> values) {
		addCriterion("remark in", values, "remark");
		return this;
	}

	public ItStationCriteria andRemarkNotIn(List<String> values) {
		addCriterion("remark not in", values, "remark");
		return this;
	}

	public ItStationCriteria andRemarkBetween(String value1, String value2) {
		addCriterion("remark between", value1, value2, "remark");
		return this;
	}

	public ItStationCriteria andRemarkNotBetween(String value1, String value2) {
		addCriterion("remark not between", value1, value2, "remark");
		return this;
	}

	public ItStationCriteria andStatusIsNull() {
		addCriterion("status is null");
		return this;
	}

	public ItStationCriteria andStatusIsNotNull() {
		addCriterion("status is not null");
		return this;
	}

	public ItStationCriteria andStatusEqualTo(int value) {
		addCriterion("status =", new Integer(value), "status");
		return this;
	}

	public ItStationCriteria andStatusNotEqualTo(int value) {
		addCriterion("status <>", new Integer(value), "status");
		return this;
	}

	public ItStationCriteria andStatusGreaterThan(int value) {
		addCriterion("status >", new Integer(value), "status");
		return this;
	}

	public ItStationCriteria andStatusGreaterThanOrEqualTo(int value) {
		addCriterion("status >=", new Integer(value), "status");
		return this;
	}

	public ItStationCriteria andStatusLessThan(int value) {
		addCriterion("status <", new Integer(value), "status");
		return this;
	}

	public ItStationCriteria andStatusLessThanOrEqualTo(int value) {
		addCriterion("status <=", new Integer(value), "status");
		return this;
	}

	public ItStationCriteria andStatusIn(List<Integer> values) {
		addCriterion("status in", values, "status");
		return this;
	}

	public ItStationCriteria andStatusNotIn(List<Integer> values) {
		addCriterion("status not in", values, "status");
		return this;
	}

	public ItStationCriteria andStatusBetween(int value1, int value2) {
		addCriterion("status between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public ItStationCriteria andStatusNotBetween(int value1, int value2) {
		addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public ItStationCriteria andCreateTimeIsNull() {
		addCriterion("create_time is null");
		return this;
	}

	public ItStationCriteria andCreateTimeIsNotNull() {
		addCriterion("create_time is not null");
		return this;
	}

	public ItStationCriteria andCreateTimeEqualTo(Date value) {
		addCriterion("create_time =", value, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeNotEqualTo(Date value) {
		addCriterion("create_time <>", value, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeGreaterThan(Date value) {
		addCriterion("create_time >", value, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
		addCriterion("create_time >=", value, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeLessThan(Date value) {
		addCriterion("create_time <", value, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeLessThanOrEqualTo(Date value) {
		addCriterion("create_time <=", value, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeIn(List<Date> values) {
		addCriterion("create_time in", values, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeNotIn(List<Date> values) {
		addCriterion("create_time not in", values, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeBetween(Date value1, Date value2) {
		addCriterion("create_time between", value1, value2, "createTime");
		return this;
	}

	public ItStationCriteria andCreateTimeNotBetween(Date value1, Date value2) {
		addCriterion("create_time not between", value1, value2, "createTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeIsNull() {
		addCriterion("update_time is null");
		return this;
	}

	public ItStationCriteria andUpdateTimeIsNotNull() {
		addCriterion("update_time is not null");
		return this;
	}

	public ItStationCriteria andUpdateTimeEqualTo(Date value) {
		addCriterion("update_time =", value, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeNotEqualTo(Date value) {
		addCriterion("update_time <>", value, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeGreaterThan(Date value) {
		addCriterion("update_time >", value, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
		addCriterion("update_time >=", value, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeLessThan(Date value) {
		addCriterion("update_time <", value, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeLessThanOrEqualTo(Date value) {
		addCriterion("update_time <=", value, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeIn(List<Date> values) {
		addCriterion("update_time in", values, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeNotIn(List<Date> values) {
		addCriterion("update_time not in", values, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeBetween(Date value1, Date value2) {
		addCriterion("update_time between", value1, value2, "updateTime");
		return this;
	}

	public ItStationCriteria andUpdateTimeNotBetween(Date value1, Date value2) {
		addCriterion("update_time not between", value1, value2, "updateTime");
		return this;
	}
}