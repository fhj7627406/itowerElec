package com.fuhj.itower.model;


import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class AlarmHistoryCriteria extends Criteria {

    public AlarmHistoryCriteria andAlarmHistoryIdIsNull() {
        addCriterion("alarm_history_id is null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdIsNotNull() {
        addCriterion("alarm_history_id is not null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdEqualTo(int value) {
        addCriterion("alarm_history_id =", new Integer(value), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdNotEqualTo(int value) {
        addCriterion("alarm_history_id <>", new Integer(value), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdGreaterThan(int value) {
        addCriterion("alarm_history_id >", new Integer(value), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdGreaterThanOrEqualTo(int value) {
        addCriterion("alarm_history_id >=", new Integer(value), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdLessThan(int value) {
        addCriterion("alarm_history_id <", new Integer(value), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdLessThanOrEqualTo(int value) {
        addCriterion("alarm_history_id <=", new Integer(value), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdIn(List<Integer> values) {
        addCriterion("alarm_history_id in", values, "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdNotIn(List<Integer> values) {
        addCriterion("alarm_history_id not in", values, "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdBetween(int value1, int value2) {
        addCriterion("alarm_history_id between", new Integer(value1), new Integer(value2), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmHistoryIdNotBetween(int value1, int value2) {
        addCriterion("alarm_history_id not between", new Integer(value1), new Integer(value2), "alarmHistoryId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdIsNull() {
        addCriterion("log_id is null");
        return this;
    }

    public AlarmHistoryCriteria andLogIdIsNotNull() {
        addCriterion("log_id is not null");
        return this;
    }

    public AlarmHistoryCriteria andLogIdEqualTo(int value) {
        addCriterion("log_id =", new Integer(value), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdNotEqualTo(int value) {
        addCriterion("log_id <>", new Integer(value), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdGreaterThan(int value) {
        addCriterion("log_id >", new Integer(value), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdGreaterThanOrEqualTo(int value) {
        addCriterion("log_id >=", new Integer(value), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdLessThan(int value) {
        addCriterion("log_id <", new Integer(value), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdLessThanOrEqualTo(int value) {
        addCriterion("log_id <=", new Integer(value), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdIn(List<Integer> values) {
        addCriterion("log_id in", values, "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdNotIn(List<Integer> values) {
        addCriterion("log_id not in", values, "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdBetween(int value1, int value2) {
        addCriterion("log_id between", new Integer(value1), new Integer(value2), "logId");
        return this;
    }

    public AlarmHistoryCriteria andLogIdNotBetween(int value1, int value2) {
        addCriterion("log_id not between", new Integer(value1), new Integer(value2), "logId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdIsNull() {
        addCriterion("it_province_id is null");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdIsNotNull() {
        addCriterion("it_province_id is not null");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdEqualTo(String value) {
        addCriterion("it_province_id =", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdNotEqualTo(String value) {
        addCriterion("it_province_id <>", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdGreaterThan(String value) {
        addCriterion("it_province_id >", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_province_id >=", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdLessThan(String value) {
        addCriterion("it_province_id <", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdLessThanOrEqualTo(String value) {
        addCriterion("it_province_id <=", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdLike(String value) {
        addCriterion("it_province_id like", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdNotLike(String value) {
        addCriterion("it_province_id not like", value, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdIn(List<String> values) {
        addCriterion("it_province_id in", values, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdNotIn(List<String> values) {
        addCriterion("it_province_id not in", values, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdBetween(String value1, String value2) {
        addCriterion("it_province_id between", value1, value2, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItProvinceIdNotBetween(String value1, String value2) {
        addCriterion("it_province_id not between", value1, value2, "itProvinceId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdIsNull() {
        addCriterion("it_city_id is null");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdIsNotNull() {
        addCriterion("it_city_id is not null");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdEqualTo(String value) {
        addCriterion("it_city_id =", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdNotEqualTo(String value) {
        addCriterion("it_city_id <>", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdGreaterThan(String value) {
        addCriterion("it_city_id >", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_city_id >=", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdLessThan(String value) {
        addCriterion("it_city_id <", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdLessThanOrEqualTo(String value) {
        addCriterion("it_city_id <=", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdLike(String value) {
        addCriterion("it_city_id like", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdNotLike(String value) {
        addCriterion("it_city_id not like", value, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdIn(List<String> values) {
        addCriterion("it_city_id in", values, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdNotIn(List<String> values) {
        addCriterion("it_city_id not in", values, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdBetween(String value1, String value2) {
        addCriterion("it_city_id between", value1, value2, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItCityIdNotBetween(String value1, String value2) {
        addCriterion("it_city_id not between", value1, value2, "itCityId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdIsNull() {
        addCriterion("it_district_id is null");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdIsNotNull() {
        addCriterion("it_district_id is not null");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdEqualTo(String value) {
        addCriterion("it_district_id =", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdNotEqualTo(String value) {
        addCriterion("it_district_id <>", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdGreaterThan(String value) {
        addCriterion("it_district_id >", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_district_id >=", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdLessThan(String value) {
        addCriterion("it_district_id <", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdLessThanOrEqualTo(String value) {
        addCriterion("it_district_id <=", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdLike(String value) {
        addCriterion("it_district_id like", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdNotLike(String value) {
        addCriterion("it_district_id not like", value, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdIn(List<String> values) {
        addCriterion("it_district_id in", values, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdNotIn(List<String> values) {
        addCriterion("it_district_id not in", values, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdBetween(String value1, String value2) {
        addCriterion("it_district_id between", value1, value2, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andItDistrictIdNotBetween(String value1, String value2) {
        addCriterion("it_district_id not between", value1, value2, "itDistrictId");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeIsNull() {
        addCriterion("alarm_type is null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeIsNotNull() {
        addCriterion("alarm_type is not null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeEqualTo(int value) {
        addCriterion("alarm_type =", new Integer(value), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeNotEqualTo(int value) {
        addCriterion("alarm_type <>", new Integer(value), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeGreaterThan(int value) {
        addCriterion("alarm_type >", new Integer(value), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeGreaterThanOrEqualTo(int value) {
        addCriterion("alarm_type >=", new Integer(value), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeLessThan(int value) {
        addCriterion("alarm_type <", new Integer(value), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeLessThanOrEqualTo(int value) {
        addCriterion("alarm_type <=", new Integer(value), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeIn(List<Integer> values) {
        addCriterion("alarm_type in", values, "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeNotIn(List<Integer> values) {
        addCriterion("alarm_type not in", values, "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeBetween(int value1, int value2) {
        addCriterion("alarm_type between", new Integer(value1), new Integer(value2), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andAlarmTypeNotBetween(int value1, int value2) {
        addCriterion("alarm_type not between", new Integer(value1), new Integer(value2), "alarmType");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoIsNull() {
        addCriterion("troubleNO is null");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoIsNotNull() {
        addCriterion("troubleNO is not null");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoEqualTo(String value) {
        addCriterion("troubleNO =", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoNotEqualTo(String value) {
        addCriterion("troubleNO <>", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoGreaterThan(String value) {
        addCriterion("troubleNO >", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoGreaterThanOrEqualTo(String value) {
        addCriterion("troubleNO >=", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoLessThan(String value) {
        addCriterion("troubleNO <", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoLessThanOrEqualTo(String value) {
        addCriterion("troubleNO <=", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoLike(String value) {
        addCriterion("troubleNO like", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoNotLike(String value) {
        addCriterion("troubleNO not like", value, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoIn(List<String> values) {
        addCriterion("troubleNO in", values, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoNotIn(List<String> values) {
        addCriterion("troubleNO not in", values, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoBetween(String value1, String value2) {
        addCriterion("troubleNO between", value1, value2, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andTroublenoNotBetween(String value1, String value2) {
        addCriterion("troubleNO not between", value1, value2, "troubleno");
        return this;
    }

    public AlarmHistoryCriteria andBillidIsNull() {
        addCriterion("billId is null");
        return this;
    }

    public AlarmHistoryCriteria andBillidIsNotNull() {
        addCriterion("billId is not null");
        return this;
    }

    public AlarmHistoryCriteria andBillidEqualTo(String value) {
        addCriterion("billId =", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidNotEqualTo(String value) {
        addCriterion("billId <>", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidGreaterThan(String value) {
        addCriterion("billId >", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidGreaterThanOrEqualTo(String value) {
        addCriterion("billId >=", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidLessThan(String value) {
        addCriterion("billId <", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidLessThanOrEqualTo(String value) {
        addCriterion("billId <=", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidLike(String value) {
        addCriterion("billId like", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidNotLike(String value) {
        addCriterion("billId not like", value, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidIn(List<String> values) {
        addCriterion("billId in", values, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidNotIn(List<String> values) {
        addCriterion("billId not in", values, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidBetween(String value1, String value2) {
        addCriterion("billId between", value1, value2, "billid");
        return this;
    }

    public AlarmHistoryCriteria andBillidNotBetween(String value1, String value2) {
        addCriterion("billId not between", value1, value2, "billid");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeIsNull() {
        addCriterion("stationCode is null");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeIsNotNull() {
        addCriterion("stationCode is not null");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeEqualTo(String value) {
        addCriterion("stationCode =", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeNotEqualTo(String value) {
        addCriterion("stationCode <>", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeGreaterThan(String value) {
        addCriterion("stationCode >", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeGreaterThanOrEqualTo(String value) {
        addCriterion("stationCode >=", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeLessThan(String value) {
        addCriterion("stationCode <", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeLessThanOrEqualTo(String value) {
        addCriterion("stationCode <=", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeLike(String value) {
        addCriterion("stationCode like", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeNotLike(String value) {
        addCriterion("stationCode not like", value, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeIn(List<String> values) {
        addCriterion("stationCode in", values, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeNotIn(List<String> values) {
        addCriterion("stationCode not in", values, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeBetween(String value1, String value2) {
        addCriterion("stationCode between", value1, value2, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationcodeNotBetween(String value1, String value2) {
        addCriterion("stationCode not between", value1, value2, "stationcode");
        return this;
    }

    public AlarmHistoryCriteria andStationnameIsNull() {
        addCriterion("stationName is null");
        return this;
    }

    public AlarmHistoryCriteria andStationnameIsNotNull() {
        addCriterion("stationName is not null");
        return this;
    }

    public AlarmHistoryCriteria andStationnameEqualTo(String value) {
        addCriterion("stationName =", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameNotEqualTo(String value) {
        addCriterion("stationName <>", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameGreaterThan(String value) {
        addCriterion("stationName >", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameGreaterThanOrEqualTo(String value) {
        addCriterion("stationName >=", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameLessThan(String value) {
        addCriterion("stationName <", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameLessThanOrEqualTo(String value) {
        addCriterion("stationName <=", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameLike(String value) {
        addCriterion("stationName like", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameNotLike(String value) {
        addCriterion("stationName not like", value, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameIn(List<String> values) {
        addCriterion("stationName in", values, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameNotIn(List<String> values) {
        addCriterion("stationName not in", values, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameBetween(String value1, String value2) {
        addCriterion("stationName between", value1, value2, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andStationnameNotBetween(String value1, String value2) {
        addCriterion("stationName not between", value1, value2, "stationname");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeIsNull() {
        addCriterion("alarmTime is null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeIsNotNull() {
        addCriterion("alarmTime is not null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeEqualTo(Date value) {
        addCriterion("alarmTime =", value, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeNotEqualTo(Date value) {
        addCriterion("alarmTime <>", value, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeGreaterThan(Date value) {
        addCriterion("alarmTime >", value, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeGreaterThanOrEqualTo(Date value) {
        addCriterion("alarmTime >=", value, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeLessThan(Date value) {
        addCriterion("alarmTime <", value, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeLessThanOrEqualTo(Date value) {
        addCriterion("alarmTime <=", value, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeIn(List<Date> values) {
        addCriterion("alarmTime in", values, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeNotIn(List<Date> values) {
        addCriterion("alarmTime not in", values, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeBetween(Date value1, Date value2) {
        addCriterion("alarmTime between", value1, value2, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmtimeNotBetween(Date value1, Date value2) {
        addCriterion("alarmTime not between", value1, value2, "alarmtime");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationIsNull() {
        addCriterion("alarmDuration is null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationIsNotNull() {
        addCriterion("alarmDuration is not null");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationEqualTo(int value) {
        addCriterion("alarmDuration =", new Integer(value), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationNotEqualTo(int value) {
        addCriterion("alarmDuration <>", new Integer(value), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationGreaterThan(int value) {
        addCriterion("alarmDuration >", new Integer(value), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationGreaterThanOrEqualTo(int value) {
        addCriterion("alarmDuration >=", new Integer(value), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationLessThan(int value) {
        addCriterion("alarmDuration <", new Integer(value), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationLessThanOrEqualTo(int value) {
        addCriterion("alarmDuration <=", new Integer(value), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationIn(List<Integer> values) {
        addCriterion("alarmDuration in", values, "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationNotIn(List<Integer> values) {
        addCriterion("alarmDuration not in", values, "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationBetween(int value1, int value2) {
        addCriterion("alarmDuration between", new Integer(value1), new Integer(value2), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andAlarmdurationNotBetween(int value1, int value2) {
        addCriterion("alarmDuration not between", new Integer(value1), new Integer(value2), "alarmduration");
        return this;
    }

    public AlarmHistoryCriteria andVoltageIsNull() {
        addCriterion("voltage is null");
        return this;
    }

    public AlarmHistoryCriteria andVoltageIsNotNull() {
        addCriterion("voltage is not null");
        return this;
    }

    public AlarmHistoryCriteria andVoltageEqualTo(String value) {
        addCriterion("voltage =", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageNotEqualTo(String value) {
        addCriterion("voltage <>", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageGreaterThan(String value) {
        addCriterion("voltage >", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageGreaterThanOrEqualTo(String value) {
        addCriterion("voltage >=", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageLessThan(String value) {
        addCriterion("voltage <", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageLessThanOrEqualTo(String value) {
        addCriterion("voltage <=", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageLike(String value) {
        addCriterion("voltage like", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageNotLike(String value) {
        addCriterion("voltage not like", value, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageIn(List<String> values) {
        addCriterion("voltage in", values, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageNotIn(List<String> values) {
        addCriterion("voltage not in", values, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageBetween(String value1, String value2) {
        addCriterion("voltage between", value1, value2, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andVoltageNotBetween(String value1, String value2) {
        addCriterion("voltage not between", value1, value2, "voltage");
        return this;
    }

    public AlarmHistoryCriteria andChargeIsNull() {
        addCriterion("charge is null");
        return this;
    }

    public AlarmHistoryCriteria andChargeIsNotNull() {
        addCriterion("charge is not null");
        return this;
    }

    public AlarmHistoryCriteria andChargeEqualTo(String value) {
        addCriterion("charge =", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeNotEqualTo(String value) {
        addCriterion("charge <>", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeGreaterThan(String value) {
        addCriterion("charge >", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeGreaterThanOrEqualTo(String value) {
        addCriterion("charge >=", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeLessThan(String value) {
        addCriterion("charge <", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeLessThanOrEqualTo(String value) {
        addCriterion("charge <=", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeLike(String value) {
        addCriterion("charge like", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeNotLike(String value) {
        addCriterion("charge not like", value, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeIn(List<String> values) {
        addCriterion("charge in", values, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeNotIn(List<String> values) {
        addCriterion("charge not in", values, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeBetween(String value1, String value2) {
        addCriterion("charge between", value1, value2, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargeNotBetween(String value1, String value2) {
        addCriterion("charge not between", value1, value2, "charge");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneIsNull() {
        addCriterion("chargePhone is null");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneIsNotNull() {
        addCriterion("chargePhone is not null");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneEqualTo(String value) {
        addCriterion("chargePhone =", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneNotEqualTo(String value) {
        addCriterion("chargePhone <>", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneGreaterThan(String value) {
        addCriterion("chargePhone >", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneGreaterThanOrEqualTo(String value) {
        addCriterion("chargePhone >=", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneLessThan(String value) {
        addCriterion("chargePhone <", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneLessThanOrEqualTo(String value) {
        addCriterion("chargePhone <=", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneLike(String value) {
        addCriterion("chargePhone like", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneNotLike(String value) {
        addCriterion("chargePhone not like", value, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneIn(List<String> values) {
        addCriterion("chargePhone in", values, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneNotIn(List<String> values) {
        addCriterion("chargePhone not in", values, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneBetween(String value1, String value2) {
        addCriterion("chargePhone between", value1, value2, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andChargephoneNotBetween(String value1, String value2) {
        addCriterion("chargePhone not between", value1, value2, "chargephone");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageIsNull() {
        addCriterion("preVoltage is null");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageIsNotNull() {
        addCriterion("preVoltage is not null");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageEqualTo(String value) {
        addCriterion("preVoltage =", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageNotEqualTo(String value) {
        addCriterion("preVoltage <>", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageGreaterThan(String value) {
        addCriterion("preVoltage >", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageGreaterThanOrEqualTo(String value) {
        addCriterion("preVoltage >=", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageLessThan(String value) {
        addCriterion("preVoltage <", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageLessThanOrEqualTo(String value) {
        addCriterion("preVoltage <=", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageLike(String value) {
        addCriterion("preVoltage like", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageNotLike(String value) {
        addCriterion("preVoltage not like", value, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageIn(List<String> values) {
        addCriterion("preVoltage in", values, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageNotIn(List<String> values) {
        addCriterion("preVoltage not in", values, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageBetween(String value1, String value2) {
        addCriterion("preVoltage between", value1, value2, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andPrevoltageNotBetween(String value1, String value2) {
        addCriterion("preVoltage not between", value1, value2, "prevoltage");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationIsNull() {
        addCriterion("spareElecDuration is null");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationIsNotNull() {
        addCriterion("spareElecDuration is not null");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationEqualTo(int value) {
        addCriterion("spareElecDuration =", new Integer(value), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationNotEqualTo(int value) {
        addCriterion("spareElecDuration <>", new Integer(value), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationGreaterThan(int value) {
        addCriterion("spareElecDuration >", new Integer(value), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationGreaterThanOrEqualTo(int value) {
        addCriterion("spareElecDuration >=", new Integer(value), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationLessThan(int value) {
        addCriterion("spareElecDuration <", new Integer(value), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationLessThanOrEqualTo(int value) {
        addCriterion("spareElecDuration <=", new Integer(value), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationIn(List<Integer> values) {
        addCriterion("spareElecDuration in", values, "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationNotIn(List<Integer> values) {
        addCriterion("spareElecDuration not in", values, "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationBetween(int value1, int value2) {
        addCriterion("spareElecDuration between", new Integer(value1), new Integer(value2), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andSpareelecdurationNotBetween(int value1, int value2) {
        addCriterion("spareElecDuration not between", new Integer(value1), new Integer(value2), "spareelecduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationIsNull() {
        addCriterion("wayOfDuration is null");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationIsNotNull() {
        addCriterion("wayOfDuration is not null");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationEqualTo(int value) {
        addCriterion("wayOfDuration =", new Integer(value), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationNotEqualTo(int value) {
        addCriterion("wayOfDuration <>", new Integer(value), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationGreaterThan(int value) {
        addCriterion("wayOfDuration >", new Integer(value), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationGreaterThanOrEqualTo(int value) {
        addCriterion("wayOfDuration >=", new Integer(value), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationLessThan(int value) {
        addCriterion("wayOfDuration <", new Integer(value), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationLessThanOrEqualTo(int value) {
        addCriterion("wayOfDuration <=", new Integer(value), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationIn(List<Integer> values) {
        addCriterion("wayOfDuration in", values, "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationNotIn(List<Integer> values) {
        addCriterion("wayOfDuration not in", values, "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationBetween(int value1, int value2) {
        addCriterion("wayOfDuration between", new Integer(value1), new Integer(value2), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andWayofdurationNotBetween(int value1, int value2) {
        addCriterion("wayOfDuration not between", new Integer(value1), new Integer(value2), "wayofduration");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownIsNull() {
        addCriterion("elecCountdown is null");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownIsNotNull() {
        addCriterion("elecCountdown is not null");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownEqualTo(int value) {
        addCriterion("elecCountdown =", new Integer(value), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownNotEqualTo(int value) {
        addCriterion("elecCountdown <>", new Integer(value), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownGreaterThan(int value) {
        addCriterion("elecCountdown >", new Integer(value), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownGreaterThanOrEqualTo(int value) {
        addCriterion("elecCountdown >=", new Integer(value), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownLessThan(int value) {
        addCriterion("elecCountdown <", new Integer(value), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownLessThanOrEqualTo(int value) {
        addCriterion("elecCountdown <=", new Integer(value), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownIn(List<Integer> values) {
        addCriterion("elecCountdown in", values, "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownNotIn(List<Integer> values) {
        addCriterion("elecCountdown not in", values, "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownBetween(int value1, int value2) {
        addCriterion("elecCountdown between", new Integer(value1), new Integer(value2), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andEleccountdownNotBetween(int value1, int value2) {
        addCriterion("elecCountdown not between", new Integer(value1), new Integer(value2), "eleccountdown");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginIsNull() {
        addCriterion("generBegin is null");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginIsNotNull() {
        addCriterion("generBegin is not null");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginEqualTo(Date value) {
        addCriterion("generBegin =", value, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginNotEqualTo(Date value) {
        addCriterion("generBegin <>", value, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginGreaterThan(Date value) {
        addCriterion("generBegin >", value, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginGreaterThanOrEqualTo(Date value) {
        addCriterion("generBegin >=", value, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginLessThan(Date value) {
        addCriterion("generBegin <", value, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginLessThanOrEqualTo(Date value) {
        addCriterion("generBegin <=", value, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginIn(List<Date> values) {
        addCriterion("generBegin in", values, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginNotIn(List<Date> values) {
        addCriterion("generBegin not in", values, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginBetween(Date value1, Date value2) {
        addCriterion("generBegin between", value1, value2, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerbeginNotBetween(Date value1, Date value2) {
        addCriterion("generBegin not between", value1, value2, "generbegin");
        return this;
    }

    public AlarmHistoryCriteria andGenerendIsNull() {
        addCriterion("generEnd is null");
        return this;
    }

    public AlarmHistoryCriteria andGenerendIsNotNull() {
        addCriterion("generEnd is not null");
        return this;
    }

    public AlarmHistoryCriteria andGenerendEqualTo(Date value) {
        addCriterion("generEnd =", value, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendNotEqualTo(Date value) {
        addCriterion("generEnd <>", value, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendGreaterThan(Date value) {
        addCriterion("generEnd >", value, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendGreaterThanOrEqualTo(Date value) {
        addCriterion("generEnd >=", value, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendLessThan(Date value) {
        addCriterion("generEnd <", value, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendLessThanOrEqualTo(Date value) {
        addCriterion("generEnd <=", value, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendIn(List<Date> values) {
        addCriterion("generEnd in", values, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendNotIn(List<Date> values) {
        addCriterion("generEnd not in", values, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendBetween(Date value1, Date value2) {
        addCriterion("generEnd between", value1, value2, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerendNotBetween(Date value1, Date value2) {
        addCriterion("generEnd not between", value1, value2, "generend");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonIsNull() {
        addCriterion("generPerson is null");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonIsNotNull() {
        addCriterion("generPerson is not null");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonEqualTo(String value) {
        addCriterion("generPerson =", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonNotEqualTo(String value) {
        addCriterion("generPerson <>", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonGreaterThan(String value) {
        addCriterion("generPerson >", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonGreaterThanOrEqualTo(String value) {
        addCriterion("generPerson >=", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonLessThan(String value) {
        addCriterion("generPerson <", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonLessThanOrEqualTo(String value) {
        addCriterion("generPerson <=", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonLike(String value) {
        addCriterion("generPerson like", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonNotLike(String value) {
        addCriterion("generPerson not like", value, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonIn(List<String> values) {
        addCriterion("generPerson in", values, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonNotIn(List<String> values) {
        addCriterion("generPerson not in", values, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonBetween(String value1, String value2) {
        addCriterion("generPerson between", value1, value2, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andGenerpersonNotBetween(String value1, String value2) {
        addCriterion("generPerson not between", value1, value2, "generperson");
        return this;
    }

    public AlarmHistoryCriteria andStatusIsNull() {
        addCriterion("status is null");
        return this;
    }

    public AlarmHistoryCriteria andStatusIsNotNull() {
        addCriterion("status is not null");
        return this;
    }

    public AlarmHistoryCriteria andStatusEqualTo(int value) {
        addCriterion("status =", new Integer(value), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusNotEqualTo(int value) {
        addCriterion("status <>", new Integer(value), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusGreaterThan(int value) {
        addCriterion("status >", new Integer(value), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusGreaterThanOrEqualTo(int value) {
        addCriterion("status >=", new Integer(value), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusLessThan(int value) {
        addCriterion("status <", new Integer(value), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusLessThanOrEqualTo(int value) {
        addCriterion("status <=", new Integer(value), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusIn(List<Integer> values) {
        addCriterion("status in", values, "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusNotIn(List<Integer> values) {
        addCriterion("status not in", values, "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusBetween(int value1, int value2) {
        addCriterion("status between", new Integer(value1), new Integer(value2), "status");
        return this;
    }

    public AlarmHistoryCriteria andStatusNotBetween(int value1, int value2) {
        addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
        return this;
    }
}