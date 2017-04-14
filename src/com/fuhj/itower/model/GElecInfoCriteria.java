package com.fuhj.itower.model;


import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class GElecInfoCriteria extends Criteria {

    public GElecInfoCriteria andGelecInfoIdIsNull() {
        addCriterion("gelec_info_id is null");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdIsNotNull() {
        addCriterion("gelec_info_id is not null");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdEqualTo(int value) {
        addCriterion("gelec_info_id =", new Integer(value), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdNotEqualTo(int value) {
        addCriterion("gelec_info_id <>", new Integer(value), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdGreaterThan(int value) {
        addCriterion("gelec_info_id >", new Integer(value), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdGreaterThanOrEqualTo(int value) {
        addCriterion("gelec_info_id >=", new Integer(value), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdLessThan(int value) {
        addCriterion("gelec_info_id <", new Integer(value), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdLessThanOrEqualTo(int value) {
        addCriterion("gelec_info_id <=", new Integer(value), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdIn(List<Integer> values) {
        addCriterion("gelec_info_id in", values, "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdNotIn(List<Integer> values) {
        addCriterion("gelec_info_id not in", values, "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdBetween(int value1, int value2) {
        addCriterion("gelec_info_id between", new Integer(value1), new Integer(value2), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGelecInfoIdNotBetween(int value1, int value2) {
        addCriterion("gelec_info_id not between", new Integer(value1), new Integer(value2), "gelecInfoId");
        return this;
    }

    public GElecInfoCriteria andGCodeIsNull() {
        addCriterion("g_code is null");
        return this;
    }

    public GElecInfoCriteria andGCodeIsNotNull() {
        addCriterion("g_code is not null");
        return this;
    }

    public GElecInfoCriteria andGCodeEqualTo(String value) {
        addCriterion("g_code =", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeNotEqualTo(String value) {
        addCriterion("g_code <>", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeGreaterThan(String value) {
        addCriterion("g_code >", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeGreaterThanOrEqualTo(String value) {
        addCriterion("g_code >=", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeLessThan(String value) {
        addCriterion("g_code <", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeLessThanOrEqualTo(String value) {
        addCriterion("g_code <=", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeLike(String value) {
        addCriterion("g_code like", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeNotLike(String value) {
        addCriterion("g_code not like", value, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeIn(List<String> values) {
        addCriterion("g_code in", values, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeNotIn(List<String> values) {
        addCriterion("g_code not in", values, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeBetween(String value1, String value2) {
        addCriterion("g_code between", value1, value2, "gCode");
        return this;
    }

    public GElecInfoCriteria andGCodeNotBetween(String value1, String value2) {
        addCriterion("g_code not between", value1, value2, "gCode");
        return this;
    }

    public GElecInfoCriteria andProvinceIsNull() {
        addCriterion("province is null");
        return this;
    }

    public GElecInfoCriteria andProvinceIsNotNull() {
        addCriterion("province is not null");
        return this;
    }

    public GElecInfoCriteria andProvinceEqualTo(String value) {
        addCriterion("province =", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceNotEqualTo(String value) {
        addCriterion("province <>", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceGreaterThan(String value) {
        addCriterion("province >", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceGreaterThanOrEqualTo(String value) {
        addCriterion("province >=", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceLessThan(String value) {
        addCriterion("province <", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceLessThanOrEqualTo(String value) {
        addCriterion("province <=", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceLike(String value) {
        addCriterion("province like", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceNotLike(String value) {
        addCriterion("province not like", value, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceIn(List<String> values) {
        addCriterion("province in", values, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceNotIn(List<String> values) {
        addCriterion("province not in", values, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceBetween(String value1, String value2) {
        addCriterion("province between", value1, value2, "province");
        return this;
    }

    public GElecInfoCriteria andProvinceNotBetween(String value1, String value2) {
        addCriterion("province not between", value1, value2, "province");
        return this;
    }

    public GElecInfoCriteria andCityIsNull() {
        addCriterion("city is null");
        return this;
    }

    public GElecInfoCriteria andCityIsNotNull() {
        addCriterion("city is not null");
        return this;
    }

    public GElecInfoCriteria andCityEqualTo(String value) {
        addCriterion("city =", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityNotEqualTo(String value) {
        addCriterion("city <>", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityGreaterThan(String value) {
        addCriterion("city >", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityGreaterThanOrEqualTo(String value) {
        addCriterion("city >=", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityLessThan(String value) {
        addCriterion("city <", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityLessThanOrEqualTo(String value) {
        addCriterion("city <=", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityLike(String value) {
        addCriterion("city like", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityNotLike(String value) {
        addCriterion("city not like", value, "city");
        return this;
    }

    public GElecInfoCriteria andCityIn(List<String> values) {
        addCriterion("city in", values, "city");
        return this;
    }

    public GElecInfoCriteria andCityNotIn(List<String> values) {
        addCriterion("city not in", values, "city");
        return this;
    }

    public GElecInfoCriteria andCityBetween(String value1, String value2) {
        addCriterion("city between", value1, value2, "city");
        return this;
    }

    public GElecInfoCriteria andCityNotBetween(String value1, String value2) {
        addCriterion("city not between", value1, value2, "city");
        return this;
    }

    public GElecInfoCriteria andDistrictIsNull() {
        addCriterion("district is null");
        return this;
    }

    public GElecInfoCriteria andDistrictIsNotNull() {
        addCriterion("district is not null");
        return this;
    }

    public GElecInfoCriteria andDistrictEqualTo(String value) {
        addCriterion("district =", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictNotEqualTo(String value) {
        addCriterion("district <>", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictGreaterThan(String value) {
        addCriterion("district >", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictGreaterThanOrEqualTo(String value) {
        addCriterion("district >=", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictLessThan(String value) {
        addCriterion("district <", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictLessThanOrEqualTo(String value) {
        addCriterion("district <=", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictLike(String value) {
        addCriterion("district like", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictNotLike(String value) {
        addCriterion("district not like", value, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictIn(List<String> values) {
        addCriterion("district in", values, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictNotIn(List<String> values) {
        addCriterion("district not in", values, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictBetween(String value1, String value2) {
        addCriterion("district between", value1, value2, "district");
        return this;
    }

    public GElecInfoCriteria andDistrictNotBetween(String value1, String value2) {
        addCriterion("district not between", value1, value2, "district");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdIsNull() {
        addCriterion("it_province_id is null");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdIsNotNull() {
        addCriterion("it_province_id is not null");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdEqualTo(String value) {
        addCriterion("it_province_id =", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdNotEqualTo(String value) {
        addCriterion("it_province_id <>", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdGreaterThan(String value) {
        addCriterion("it_province_id >", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_province_id >=", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdLessThan(String value) {
        addCriterion("it_province_id <", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdLessThanOrEqualTo(String value) {
        addCriterion("it_province_id <=", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdLike(String value) {
        addCriterion("it_province_id like", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdNotLike(String value) {
        addCriterion("it_province_id not like", value, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdIn(List<String> values) {
        addCriterion("it_province_id in", values, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdNotIn(List<String> values) {
        addCriterion("it_province_id not in", values, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdBetween(String value1, String value2) {
        addCriterion("it_province_id between", value1, value2, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItProvinceIdNotBetween(String value1, String value2) {
        addCriterion("it_province_id not between", value1, value2, "itProvinceId");
        return this;
    }

    public GElecInfoCriteria andItCityIdIsNull() {
        addCriterion("it_city_id is null");
        return this;
    }

    public GElecInfoCriteria andItCityIdIsNotNull() {
        addCriterion("it_city_id is not null");
        return this;
    }

    public GElecInfoCriteria andItCityIdEqualTo(String value) {
        addCriterion("it_city_id =", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdNotEqualTo(String value) {
        addCriterion("it_city_id <>", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdGreaterThan(String value) {
        addCriterion("it_city_id >", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_city_id >=", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdLessThan(String value) {
        addCriterion("it_city_id <", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdLessThanOrEqualTo(String value) {
        addCriterion("it_city_id <=", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdLike(String value) {
        addCriterion("it_city_id like", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdNotLike(String value) {
        addCriterion("it_city_id not like", value, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdIn(List<String> values) {
        addCriterion("it_city_id in", values, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdNotIn(List<String> values) {
        addCriterion("it_city_id not in", values, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdBetween(String value1, String value2) {
        addCriterion("it_city_id between", value1, value2, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItCityIdNotBetween(String value1, String value2) {
        addCriterion("it_city_id not between", value1, value2, "itCityId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdIsNull() {
        addCriterion("it_district_id is null");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdIsNotNull() {
        addCriterion("it_district_id is not null");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdEqualTo(String value) {
        addCriterion("it_district_id =", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdNotEqualTo(String value) {
        addCriterion("it_district_id <>", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdGreaterThan(String value) {
        addCriterion("it_district_id >", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_district_id >=", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdLessThan(String value) {
        addCriterion("it_district_id <", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdLessThanOrEqualTo(String value) {
        addCriterion("it_district_id <=", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdLike(String value) {
        addCriterion("it_district_id like", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdNotLike(String value) {
        addCriterion("it_district_id not like", value, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdIn(List<String> values) {
        addCriterion("it_district_id in", values, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdNotIn(List<String> values) {
        addCriterion("it_district_id not in", values, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdBetween(String value1, String value2) {
        addCriterion("it_district_id between", value1, value2, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItDistrictIdNotBetween(String value1, String value2) {
        addCriterion("it_district_id not between", value1, value2, "itDistrictId");
        return this;
    }

    public GElecInfoCriteria andItBillIdIsNull() {
        addCriterion("it_bill_id is null");
        return this;
    }

    public GElecInfoCriteria andItBillIdIsNotNull() {
        addCriterion("it_bill_id is not null");
        return this;
    }

    public GElecInfoCriteria andItBillIdEqualTo(int value) {
        addCriterion("it_bill_id =", new Integer(value), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdNotEqualTo(int value) {
        addCriterion("it_bill_id <>", new Integer(value), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdGreaterThan(int value) {
        addCriterion("it_bill_id >", new Integer(value), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdGreaterThanOrEqualTo(int value) {
        addCriterion("it_bill_id >=", new Integer(value), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdLessThan(int value) {
        addCriterion("it_bill_id <", new Integer(value), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdLessThanOrEqualTo(int value) {
        addCriterion("it_bill_id <=", new Integer(value), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdIn(List<Integer> values) {
        addCriterion("it_bill_id in", values, "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdNotIn(List<Integer> values) {
        addCriterion("it_bill_id not in", values, "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdBetween(int value1, int value2) {
        addCriterion("it_bill_id between", new Integer(value1), new Integer(value2), "itBillId");
        return this;
    }

    public GElecInfoCriteria andItBillIdNotBetween(int value1, int value2) {
        addCriterion("it_bill_id not between", new Integer(value1), new Integer(value2), "itBillId");
        return this;
    }

    public GElecInfoCriteria andBillCodeIsNull() {
        addCriterion("bill_code is null");
        return this;
    }

    public GElecInfoCriteria andBillCodeIsNotNull() {
        addCriterion("bill_code is not null");
        return this;
    }

    public GElecInfoCriteria andBillCodeEqualTo(String value) {
        addCriterion("bill_code =", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeNotEqualTo(String value) {
        addCriterion("bill_code <>", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeGreaterThan(String value) {
        addCriterion("bill_code >", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeGreaterThanOrEqualTo(String value) {
        addCriterion("bill_code >=", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeLessThan(String value) {
        addCriterion("bill_code <", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeLessThanOrEqualTo(String value) {
        addCriterion("bill_code <=", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeLike(String value) {
        addCriterion("bill_code like", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeNotLike(String value) {
        addCriterion("bill_code not like", value, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeIn(List<String> values) {
        addCriterion("bill_code in", values, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeNotIn(List<String> values) {
        addCriterion("bill_code not in", values, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeBetween(String value1, String value2) {
        addCriterion("bill_code between", value1, value2, "billCode");
        return this;
    }

    public GElecInfoCriteria andBillCodeNotBetween(String value1, String value2) {
        addCriterion("bill_code not between", value1, value2, "billCode");
        return this;
    }

    public GElecInfoCriteria andFaultSourceIsNull() {
        addCriterion("fault_source is null");
        return this;
    }

    public GElecInfoCriteria andFaultSourceIsNotNull() {
        addCriterion("fault_source is not null");
        return this;
    }

    public GElecInfoCriteria andFaultSourceEqualTo(String value) {
        addCriterion("fault_source =", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceNotEqualTo(String value) {
        addCriterion("fault_source <>", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceGreaterThan(String value) {
        addCriterion("fault_source >", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceGreaterThanOrEqualTo(String value) {
        addCriterion("fault_source >=", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceLessThan(String value) {
        addCriterion("fault_source <", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceLessThanOrEqualTo(String value) {
        addCriterion("fault_source <=", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceLike(String value) {
        addCriterion("fault_source like", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceNotLike(String value) {
        addCriterion("fault_source not like", value, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceIn(List<String> values) {
        addCriterion("fault_source in", values, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceNotIn(List<String> values) {
        addCriterion("fault_source not in", values, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceBetween(String value1, String value2) {
        addCriterion("fault_source between", value1, value2, "faultSource");
        return this;
    }

    public GElecInfoCriteria andFaultSourceNotBetween(String value1, String value2) {
        addCriterion("fault_source not between", value1, value2, "faultSource");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailIsNull() {
        addCriterion("alarm_detail is null");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailIsNotNull() {
        addCriterion("alarm_detail is not null");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailEqualTo(String value) {
        addCriterion("alarm_detail =", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailNotEqualTo(String value) {
        addCriterion("alarm_detail <>", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailGreaterThan(String value) {
        addCriterion("alarm_detail >", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_detail >=", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailLessThan(String value) {
        addCriterion("alarm_detail <", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailLessThanOrEqualTo(String value) {
        addCriterion("alarm_detail <=", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailLike(String value) {
        addCriterion("alarm_detail like", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailNotLike(String value) {
        addCriterion("alarm_detail not like", value, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailIn(List<String> values) {
        addCriterion("alarm_detail in", values, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailNotIn(List<String> values) {
        addCriterion("alarm_detail not in", values, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailBetween(String value1, String value2) {
        addCriterion("alarm_detail between", value1, value2, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andAlarmDetailNotBetween(String value1, String value2) {
        addCriterion("alarm_detail not between", value1, value2, "alarmDetail");
        return this;
    }

    public GElecInfoCriteria andStationNameIsNull() {
        addCriterion("station_name is null");
        return this;
    }

    public GElecInfoCriteria andStationNameIsNotNull() {
        addCriterion("station_name is not null");
        return this;
    }

    public GElecInfoCriteria andStationNameEqualTo(String value) {
        addCriterion("station_name =", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameNotEqualTo(String value) {
        addCriterion("station_name <>", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameGreaterThan(String value) {
        addCriterion("station_name >", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameGreaterThanOrEqualTo(String value) {
        addCriterion("station_name >=", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameLessThan(String value) {
        addCriterion("station_name <", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameLessThanOrEqualTo(String value) {
        addCriterion("station_name <=", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameLike(String value) {
        addCriterion("station_name like", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameNotLike(String value) {
        addCriterion("station_name not like", value, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameIn(List<String> values) {
        addCriterion("station_name in", values, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameNotIn(List<String> values) {
        addCriterion("station_name not in", values, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameBetween(String value1, String value2) {
        addCriterion("station_name between", value1, value2, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationNameNotBetween(String value1, String value2) {
        addCriterion("station_name not between", value1, value2, "stationName");
        return this;
    }

    public GElecInfoCriteria andStationCodeIsNull() {
        addCriterion("station_code is null");
        return this;
    }

    public GElecInfoCriteria andStationCodeIsNotNull() {
        addCriterion("station_code is not null");
        return this;
    }

    public GElecInfoCriteria andStationCodeEqualTo(String value) {
        addCriterion("station_code =", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeNotEqualTo(String value) {
        addCriterion("station_code <>", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeGreaterThan(String value) {
        addCriterion("station_code >", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeGreaterThanOrEqualTo(String value) {
        addCriterion("station_code >=", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeLessThan(String value) {
        addCriterion("station_code <", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeLessThanOrEqualTo(String value) {
        addCriterion("station_code <=", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeLike(String value) {
        addCriterion("station_code like", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeNotLike(String value) {
        addCriterion("station_code not like", value, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeIn(List<String> values) {
        addCriterion("station_code in", values, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeNotIn(List<String> values) {
        addCriterion("station_code not in", values, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeBetween(String value1, String value2) {
        addCriterion("station_code between", value1, value2, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationCodeNotBetween(String value1, String value2) {
        addCriterion("station_code not between", value1, value2, "stationCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeIsNull() {
        addCriterion("station_SYS_Code is null");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeIsNotNull() {
        addCriterion("station_SYS_Code is not null");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeEqualTo(String value) {
        addCriterion("station_SYS_Code =", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeNotEqualTo(String value) {
        addCriterion("station_SYS_Code <>", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeGreaterThan(String value) {
        addCriterion("station_SYS_Code >", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeGreaterThanOrEqualTo(String value) {
        addCriterion("station_SYS_Code >=", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeLessThan(String value) {
        addCriterion("station_SYS_Code <", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeLessThanOrEqualTo(String value) {
        addCriterion("station_SYS_Code <=", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeLike(String value) {
        addCriterion("station_SYS_Code like", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeNotLike(String value) {
        addCriterion("station_SYS_Code not like", value, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeIn(List<String> values) {
        addCriterion("station_SYS_Code in", values, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeNotIn(List<String> values) {
        addCriterion("station_SYS_Code not in", values, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeBetween(String value1, String value2) {
        addCriterion("station_SYS_Code between", value1, value2, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andStationSysCodeNotBetween(String value1, String value2) {
        addCriterion("station_SYS_Code not between", value1, value2, "stationSysCode");
        return this;
    }

    public GElecInfoCriteria andOperatorIsNull() {
        addCriterion("operator is null");
        return this;
    }

    public GElecInfoCriteria andOperatorIsNotNull() {
        addCriterion("operator is not null");
        return this;
    }

    public GElecInfoCriteria andOperatorEqualTo(String value) {
        addCriterion("operator =", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorNotEqualTo(String value) {
        addCriterion("operator <>", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorGreaterThan(String value) {
        addCriterion("operator >", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorGreaterThanOrEqualTo(String value) {
        addCriterion("operator >=", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorLessThan(String value) {
        addCriterion("operator <", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorLessThanOrEqualTo(String value) {
        addCriterion("operator <=", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorLike(String value) {
        addCriterion("operator like", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorNotLike(String value) {
        addCriterion("operator not like", value, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorIn(List<String> values) {
        addCriterion("operator in", values, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorNotIn(List<String> values) {
        addCriterion("operator not in", values, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorBetween(String value1, String value2) {
        addCriterion("operator between", value1, value2, "operator");
        return this;
    }

    public GElecInfoCriteria andOperatorNotBetween(String value1, String value2) {
        addCriterion("operator not between", value1, value2, "operator");
        return this;
    }

    public GElecInfoCriteria andOperCodeIsNull() {
        addCriterion("oper_code is null");
        return this;
    }

    public GElecInfoCriteria andOperCodeIsNotNull() {
        addCriterion("oper_code is not null");
        return this;
    }

    public GElecInfoCriteria andOperCodeEqualTo(String value) {
        addCriterion("oper_code =", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeNotEqualTo(String value) {
        addCriterion("oper_code <>", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeGreaterThan(String value) {
        addCriterion("oper_code >", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeGreaterThanOrEqualTo(String value) {
        addCriterion("oper_code >=", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeLessThan(String value) {
        addCriterion("oper_code <", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeLessThanOrEqualTo(String value) {
        addCriterion("oper_code <=", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeLike(String value) {
        addCriterion("oper_code like", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeNotLike(String value) {
        addCriterion("oper_code not like", value, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeIn(List<String> values) {
        addCriterion("oper_code in", values, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeNotIn(List<String> values) {
        addCriterion("oper_code not in", values, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeBetween(String value1, String value2) {
        addCriterion("oper_code between", value1, value2, "operCode");
        return this;
    }

    public GElecInfoCriteria andOperCodeNotBetween(String value1, String value2) {
        addCriterion("oper_code not between", value1, value2, "operCode");
        return this;
    }

    public GElecInfoCriteria andStartTimeIsNull() {
        addCriterion("start_time is null");
        return this;
    }

    public GElecInfoCriteria andStartTimeIsNotNull() {
        addCriterion("start_time is not null");
        return this;
    }

    public GElecInfoCriteria andStartTimeEqualTo(Date value) {
        addCriterion("start_time =", value, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeNotEqualTo(Date value) {
        addCriterion("start_time <>", value, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeGreaterThan(Date value) {
        addCriterion("start_time >", value, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("start_time >=", value, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeLessThan(Date value) {
        addCriterion("start_time <", value, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeLessThanOrEqualTo(Date value) {
        addCriterion("start_time <=", value, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeIn(List<Date> values) {
        addCriterion("start_time in", values, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeNotIn(List<Date> values) {
        addCriterion("start_time not in", values, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeBetween(Date value1, Date value2) {
        addCriterion("start_time between", value1, value2, "startTime");
        return this;
    }

    public GElecInfoCriteria andStartTimeNotBetween(Date value1, Date value2) {
        addCriterion("start_time not between", value1, value2, "startTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeIsNull() {
        addCriterion("end_time is null");
        return this;
    }

    public GElecInfoCriteria andEndTimeIsNotNull() {
        addCriterion("end_time is not null");
        return this;
    }

    public GElecInfoCriteria andEndTimeEqualTo(Date value) {
        addCriterion("end_time =", value, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeNotEqualTo(Date value) {
        addCriterion("end_time <>", value, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeGreaterThan(Date value) {
        addCriterion("end_time >", value, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("end_time >=", value, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeLessThan(Date value) {
        addCriterion("end_time <", value, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeLessThanOrEqualTo(Date value) {
        addCriterion("end_time <=", value, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeIn(List<Date> values) {
        addCriterion("end_time in", values, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeNotIn(List<Date> values) {
        addCriterion("end_time not in", values, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeBetween(Date value1, Date value2) {
        addCriterion("end_time between", value1, value2, "endTime");
        return this;
    }

    public GElecInfoCriteria andEndTimeNotBetween(Date value1, Date value2) {
        addCriterion("end_time not between", value1, value2, "endTime");
        return this;
    }

    public GElecInfoCriteria andDurationIsNull() {
        addCriterion("duration is null");
        return this;
    }

    public GElecInfoCriteria andDurationIsNotNull() {
        addCriterion("duration is not null");
        return this;
    }

    public GElecInfoCriteria andDurationEqualTo(String value) {
        addCriterion("duration =", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationNotEqualTo(String value) {
        addCriterion("duration <>", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationGreaterThan(String value) {
        addCriterion("duration >", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationGreaterThanOrEqualTo(String value) {
        addCriterion("duration >=", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationLessThan(String value) {
        addCriterion("duration <", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationLessThanOrEqualTo(String value) {
        addCriterion("duration <=", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationLike(String value) {
        addCriterion("duration like", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationNotLike(String value) {
        addCriterion("duration not like", value, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationIn(List<String> values) {
        addCriterion("duration in", values, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationNotIn(List<String> values) {
        addCriterion("duration not in", values, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationBetween(String value1, String value2) {
        addCriterion("duration between", value1, value2, "duration");
        return this;
    }

    public GElecInfoCriteria andDurationNotBetween(String value1, String value2) {
        addCriterion("duration not between", value1, value2, "duration");
        return this;
    }

    public GElecInfoCriteria andOdometerIsNull() {
        addCriterion("odometer is null");
        return this;
    }

    public GElecInfoCriteria andOdometerIsNotNull() {
        addCriterion("odometer is not null");
        return this;
    }

    public GElecInfoCriteria andOdometerEqualTo(String value) {
        addCriterion("odometer =", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerNotEqualTo(String value) {
        addCriterion("odometer <>", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerGreaterThan(String value) {
        addCriterion("odometer >", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerGreaterThanOrEqualTo(String value) {
        addCriterion("odometer >=", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerLessThan(String value) {
        addCriterion("odometer <", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerLessThanOrEqualTo(String value) {
        addCriterion("odometer <=", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerLike(String value) {
        addCriterion("odometer like", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerNotLike(String value) {
        addCriterion("odometer not like", value, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerIn(List<String> values) {
        addCriterion("odometer in", values, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerNotIn(List<String> values) {
        addCriterion("odometer not in", values, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerBetween(String value1, String value2) {
        addCriterion("odometer between", value1, value2, "odometer");
        return this;
    }

    public GElecInfoCriteria andOdometerNotBetween(String value1, String value2) {
        addCriterion("odometer not between", value1, value2, "odometer");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceIsNull() {
        addCriterion("petrol_price is null");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceIsNotNull() {
        addCriterion("petrol_price is not null");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceEqualTo(String value) {
        addCriterion("petrol_price =", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceNotEqualTo(String value) {
        addCriterion("petrol_price <>", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceGreaterThan(String value) {
        addCriterion("petrol_price >", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceGreaterThanOrEqualTo(String value) {
        addCriterion("petrol_price >=", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceLessThan(String value) {
        addCriterion("petrol_price <", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceLessThanOrEqualTo(String value) {
        addCriterion("petrol_price <=", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceLike(String value) {
        addCriterion("petrol_price like", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceNotLike(String value) {
        addCriterion("petrol_price not like", value, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceIn(List<String> values) {
        addCriterion("petrol_price in", values, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceNotIn(List<String> values) {
        addCriterion("petrol_price not in", values, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceBetween(String value1, String value2) {
        addCriterion("petrol_price between", value1, value2, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andPetrolPriceNotBetween(String value1, String value2) {
        addCriterion("petrol_price not between", value1, value2, "petrolPrice");
        return this;
    }

    public GElecInfoCriteria andMachineCountIsNull() {
        addCriterion("machine_count is null");
        return this;
    }

    public GElecInfoCriteria andMachineCountIsNotNull() {
        addCriterion("machine_count is not null");
        return this;
    }

    public GElecInfoCriteria andMachineCountEqualTo(int value) {
        addCriterion("machine_count =", new Integer(value), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountNotEqualTo(int value) {
        addCriterion("machine_count <>", new Integer(value), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountGreaterThan(int value) {
        addCriterion("machine_count >", new Integer(value), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountGreaterThanOrEqualTo(int value) {
        addCriterion("machine_count >=", new Integer(value), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountLessThan(int value) {
        addCriterion("machine_count <", new Integer(value), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountLessThanOrEqualTo(int value) {
        addCriterion("machine_count <=", new Integer(value), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountIn(List<Integer> values) {
        addCriterion("machine_count in", values, "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountNotIn(List<Integer> values) {
        addCriterion("machine_count not in", values, "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountBetween(int value1, int value2) {
        addCriterion("machine_count between", new Integer(value1), new Integer(value2), "machineCount");
        return this;
    }

    public GElecInfoCriteria andMachineCountNotBetween(int value1, int value2) {
        addCriterion("machine_count not between", new Integer(value1), new Integer(value2), "machineCount");
        return this;
    }

    public GElecInfoCriteria andAreaTypeIsNull() {
        addCriterion("area_type is null");
        return this;
    }

    public GElecInfoCriteria andAreaTypeIsNotNull() {
        addCriterion("area_type is not null");
        return this;
    }

    public GElecInfoCriteria andAreaTypeEqualTo(String value) {
        addCriterion("area_type =", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeNotEqualTo(String value) {
        addCriterion("area_type <>", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeGreaterThan(String value) {
        addCriterion("area_type >", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeGreaterThanOrEqualTo(String value) {
        addCriterion("area_type >=", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeLessThan(String value) {
        addCriterion("area_type <", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeLessThanOrEqualTo(String value) {
        addCriterion("area_type <=", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeLike(String value) {
        addCriterion("area_type like", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeNotLike(String value) {
        addCriterion("area_type not like", value, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeIn(List<String> values) {
        addCriterion("area_type in", values, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeNotIn(List<String> values) {
        addCriterion("area_type not in", values, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeBetween(String value1, String value2) {
        addCriterion("area_type between", value1, value2, "areaType");
        return this;
    }

    public GElecInfoCriteria andAreaTypeNotBetween(String value1, String value2) {
        addCriterion("area_type not between", value1, value2, "areaType");
        return this;
    }

    public GElecInfoCriteria andDataOriginIsNull() {
        addCriterion("data_origin is null");
        return this;
    }

    public GElecInfoCriteria andDataOriginIsNotNull() {
        addCriterion("data_origin is not null");
        return this;
    }

    public GElecInfoCriteria andDataOriginEqualTo(String value) {
        addCriterion("data_origin =", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginNotEqualTo(String value) {
        addCriterion("data_origin <>", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginGreaterThan(String value) {
        addCriterion("data_origin >", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginGreaterThanOrEqualTo(String value) {
        addCriterion("data_origin >=", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginLessThan(String value) {
        addCriterion("data_origin <", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginLessThanOrEqualTo(String value) {
        addCriterion("data_origin <=", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginLike(String value) {
        addCriterion("data_origin like", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginNotLike(String value) {
        addCriterion("data_origin not like", value, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginIn(List<String> values) {
        addCriterion("data_origin in", values, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginNotIn(List<String> values) {
        addCriterion("data_origin not in", values, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginBetween(String value1, String value2) {
        addCriterion("data_origin between", value1, value2, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andDataOriginNotBetween(String value1, String value2) {
        addCriterion("data_origin not between", value1, value2, "dataOrigin");
        return this;
    }

    public GElecInfoCriteria andReasonIsNull() {
        addCriterion("reason is null");
        return this;
    }

    public GElecInfoCriteria andReasonIsNotNull() {
        addCriterion("reason is not null");
        return this;
    }

    public GElecInfoCriteria andReasonEqualTo(String value) {
        addCriterion("reason =", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonNotEqualTo(String value) {
        addCriterion("reason <>", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonGreaterThan(String value) {
        addCriterion("reason >", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonGreaterThanOrEqualTo(String value) {
        addCriterion("reason >=", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonLessThan(String value) {
        addCriterion("reason <", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonLessThanOrEqualTo(String value) {
        addCriterion("reason <=", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonLike(String value) {
        addCriterion("reason like", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonNotLike(String value) {
        addCriterion("reason not like", value, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonIn(List<String> values) {
        addCriterion("reason in", values, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonNotIn(List<String> values) {
        addCriterion("reason not in", values, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonBetween(String value1, String value2) {
        addCriterion("reason between", value1, value2, "reason");
        return this;
    }

    public GElecInfoCriteria andReasonNotBetween(String value1, String value2) {
        addCriterion("reason not between", value1, value2, "reason");
        return this;
    }

    public GElecInfoCriteria andMachinePowerIsNull() {
        addCriterion("machine_power is null");
        return this;
    }

    public GElecInfoCriteria andMachinePowerIsNotNull() {
        addCriterion("machine_power is not null");
        return this;
    }

    public GElecInfoCriteria andMachinePowerEqualTo(String value) {
        addCriterion("machine_power =", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerNotEqualTo(String value) {
        addCriterion("machine_power <>", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerGreaterThan(String value) {
        addCriterion("machine_power >", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerGreaterThanOrEqualTo(String value) {
        addCriterion("machine_power >=", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerLessThan(String value) {
        addCriterion("machine_power <", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerLessThanOrEqualTo(String value) {
        addCriterion("machine_power <=", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerLike(String value) {
        addCriterion("machine_power like", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerNotLike(String value) {
        addCriterion("machine_power not like", value, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerIn(List<String> values) {
        addCriterion("machine_power in", values, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerNotIn(List<String> values) {
        addCriterion("machine_power not in", values, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerBetween(String value1, String value2) {
        addCriterion("machine_power between", value1, value2, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachinePowerNotBetween(String value1, String value2) {
        addCriterion("machine_power not between", value1, value2, "machinePower");
        return this;
    }

    public GElecInfoCriteria andMachineTypeIsNull() {
        addCriterion("machine_type is null");
        return this;
    }

    public GElecInfoCriteria andMachineTypeIsNotNull() {
        addCriterion("machine_type is not null");
        return this;
    }

    public GElecInfoCriteria andMachineTypeEqualTo(String value) {
        addCriterion("machine_type =", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeNotEqualTo(String value) {
        addCriterion("machine_type <>", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeGreaterThan(String value) {
        addCriterion("machine_type >", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeGreaterThanOrEqualTo(String value) {
        addCriterion("machine_type >=", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeLessThan(String value) {
        addCriterion("machine_type <", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeLessThanOrEqualTo(String value) {
        addCriterion("machine_type <=", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeLike(String value) {
        addCriterion("machine_type like", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeNotLike(String value) {
        addCriterion("machine_type not like", value, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeIn(List<String> values) {
        addCriterion("machine_type in", values, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeNotIn(List<String> values) {
        addCriterion("machine_type not in", values, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeBetween(String value1, String value2) {
        addCriterion("machine_type between", value1, value2, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineTypeNotBetween(String value1, String value2) {
        addCriterion("machine_type not between", value1, value2, "machineType");
        return this;
    }

    public GElecInfoCriteria andMachineNoIsNull() {
        addCriterion("machine_NO is null");
        return this;
    }

    public GElecInfoCriteria andMachineNoIsNotNull() {
        addCriterion("machine_NO is not null");
        return this;
    }

    public GElecInfoCriteria andMachineNoEqualTo(String value) {
        addCriterion("machine_NO =", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoNotEqualTo(String value) {
        addCriterion("machine_NO <>", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoGreaterThan(String value) {
        addCriterion("machine_NO >", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoGreaterThanOrEqualTo(String value) {
        addCriterion("machine_NO >=", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoLessThan(String value) {
        addCriterion("machine_NO <", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoLessThanOrEqualTo(String value) {
        addCriterion("machine_NO <=", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoLike(String value) {
        addCriterion("machine_NO like", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoNotLike(String value) {
        addCriterion("machine_NO not like", value, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoIn(List<String> values) {
        addCriterion("machine_NO in", values, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoNotIn(List<String> values) {
        addCriterion("machine_NO not in", values, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoBetween(String value1, String value2) {
        addCriterion("machine_NO between", value1, value2, "machineNo");
        return this;
    }

    public GElecInfoCriteria andMachineNoNotBetween(String value1, String value2) {
        addCriterion("machine_NO not between", value1, value2, "machineNo");
        return this;
    }

    public GElecInfoCriteria andPersonIsNull() {
        addCriterion("person is null");
        return this;
    }

    public GElecInfoCriteria andPersonIsNotNull() {
        addCriterion("person is not null");
        return this;
    }

    public GElecInfoCriteria andPersonEqualTo(String value) {
        addCriterion("person =", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonNotEqualTo(String value) {
        addCriterion("person <>", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonGreaterThan(String value) {
        addCriterion("person >", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonGreaterThanOrEqualTo(String value) {
        addCriterion("person >=", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonLessThan(String value) {
        addCriterion("person <", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonLessThanOrEqualTo(String value) {
        addCriterion("person <=", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonLike(String value) {
        addCriterion("person like", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonNotLike(String value) {
        addCriterion("person not like", value, "person");
        return this;
    }

    public GElecInfoCriteria andPersonIn(List<String> values) {
        addCriterion("person in", values, "person");
        return this;
    }

    public GElecInfoCriteria andPersonNotIn(List<String> values) {
        addCriterion("person not in", values, "person");
        return this;
    }

    public GElecInfoCriteria andPersonBetween(String value1, String value2) {
        addCriterion("person between", value1, value2, "person");
        return this;
    }

    public GElecInfoCriteria andPersonNotBetween(String value1, String value2) {
        addCriterion("person not between", value1, value2, "person");
        return this;
    }

    public GElecInfoCriteria andContactIsNull() {
        addCriterion("contact is null");
        return this;
    }

    public GElecInfoCriteria andContactIsNotNull() {
        addCriterion("contact is not null");
        return this;
    }

    public GElecInfoCriteria andContactEqualTo(String value) {
        addCriterion("contact =", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactNotEqualTo(String value) {
        addCriterion("contact <>", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactGreaterThan(String value) {
        addCriterion("contact >", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactGreaterThanOrEqualTo(String value) {
        addCriterion("contact >=", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactLessThan(String value) {
        addCriterion("contact <", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactLessThanOrEqualTo(String value) {
        addCriterion("contact <=", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactLike(String value) {
        addCriterion("contact like", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactNotLike(String value) {
        addCriterion("contact not like", value, "contact");
        return this;
    }

    public GElecInfoCriteria andContactIn(List<String> values) {
        addCriterion("contact in", values, "contact");
        return this;
    }

    public GElecInfoCriteria andContactNotIn(List<String> values) {
        addCriterion("contact not in", values, "contact");
        return this;
    }

    public GElecInfoCriteria andContactBetween(String value1, String value2) {
        addCriterion("contact between", value1, value2, "contact");
        return this;
    }

    public GElecInfoCriteria andContactNotBetween(String value1, String value2) {
        addCriterion("contact not between", value1, value2, "contact");
        return this;
    }

    public GElecInfoCriteria andStartVoltageIsNull() {
        addCriterion("start_voltage is null");
        return this;
    }

    public GElecInfoCriteria andStartVoltageIsNotNull() {
        addCriterion("start_voltage is not null");
        return this;
    }

    public GElecInfoCriteria andStartVoltageEqualTo(String value) {
        addCriterion("start_voltage =", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageNotEqualTo(String value) {
        addCriterion("start_voltage <>", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageGreaterThan(String value) {
        addCriterion("start_voltage >", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageGreaterThanOrEqualTo(String value) {
        addCriterion("start_voltage >=", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageLessThan(String value) {
        addCriterion("start_voltage <", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageLessThanOrEqualTo(String value) {
        addCriterion("start_voltage <=", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageLike(String value) {
        addCriterion("start_voltage like", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageNotLike(String value) {
        addCriterion("start_voltage not like", value, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageIn(List<String> values) {
        addCriterion("start_voltage in", values, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageNotIn(List<String> values) {
        addCriterion("start_voltage not in", values, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageBetween(String value1, String value2) {
        addCriterion("start_voltage between", value1, value2, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartVoltageNotBetween(String value1, String value2) {
        addCriterion("start_voltage not between", value1, value2, "startVoltage");
        return this;
    }

    public GElecInfoCriteria andStartLngIsNull() {
        addCriterion("start_lng is null");
        return this;
    }

    public GElecInfoCriteria andStartLngIsNotNull() {
        addCriterion("start_lng is not null");
        return this;
    }

    public GElecInfoCriteria andStartLngEqualTo(double value) {
        addCriterion("start_lng =", new Double(value), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngNotEqualTo(double value) {
        addCriterion("start_lng <>", new Double(value), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngGreaterThan(double value) {
        addCriterion("start_lng >", new Double(value), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngGreaterThanOrEqualTo(double value) {
        addCriterion("start_lng >=", new Double(value), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngLessThan(double value) {
        addCriterion("start_lng <", new Double(value), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngLessThanOrEqualTo(double value) {
        addCriterion("start_lng <=", new Double(value), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngIn(List<Double> values) {
        addCriterion("start_lng in", values, "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngNotIn(List<Double> values) {
        addCriterion("start_lng not in", values, "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngBetween(double value1, double value2) {
        addCriterion("start_lng between", new Double(value1), new Double(value2), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLngNotBetween(double value1, double value2) {
        addCriterion("start_lng not between", new Double(value1), new Double(value2), "startLng");
        return this;
    }

    public GElecInfoCriteria andStartLatIsNull() {
        addCriterion("start_lat is null");
        return this;
    }

    public GElecInfoCriteria andStartLatIsNotNull() {
        addCriterion("start_lat is not null");
        return this;
    }

    public GElecInfoCriteria andStartLatEqualTo(double value) {
        addCriterion("start_lat =", new Double(value), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatNotEqualTo(double value) {
        addCriterion("start_lat <>", new Double(value), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatGreaterThan(double value) {
        addCriterion("start_lat >", new Double(value), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatGreaterThanOrEqualTo(double value) {
        addCriterion("start_lat >=", new Double(value), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatLessThan(double value) {
        addCriterion("start_lat <", new Double(value), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatLessThanOrEqualTo(double value) {
        addCriterion("start_lat <=", new Double(value), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatIn(List<Double> values) {
        addCriterion("start_lat in", values, "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatNotIn(List<Double> values) {
        addCriterion("start_lat not in", values, "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatBetween(double value1, double value2) {
        addCriterion("start_lat between", new Double(value1), new Double(value2), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartLatNotBetween(double value1, double value2) {
        addCriterion("start_lat not between", new Double(value1), new Double(value2), "startLat");
        return this;
    }

    public GElecInfoCriteria andStartAddrIsNull() {
        addCriterion("start_addr is null");
        return this;
    }

    public GElecInfoCriteria andStartAddrIsNotNull() {
        addCriterion("start_addr is not null");
        return this;
    }

    public GElecInfoCriteria andStartAddrEqualTo(String value) {
        addCriterion("start_addr =", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrNotEqualTo(String value) {
        addCriterion("start_addr <>", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrGreaterThan(String value) {
        addCriterion("start_addr >", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrGreaterThanOrEqualTo(String value) {
        addCriterion("start_addr >=", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrLessThan(String value) {
        addCriterion("start_addr <", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrLessThanOrEqualTo(String value) {
        addCriterion("start_addr <=", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrLike(String value) {
        addCriterion("start_addr like", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrNotLike(String value) {
        addCriterion("start_addr not like", value, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrIn(List<String> values) {
        addCriterion("start_addr in", values, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrNotIn(List<String> values) {
        addCriterion("start_addr not in", values, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrBetween(String value1, String value2) {
        addCriterion("start_addr between", value1, value2, "startAddr");
        return this;
    }

    public GElecInfoCriteria andStartAddrNotBetween(String value1, String value2) {
        addCriterion("start_addr not between", value1, value2, "startAddr");
        return this;
    }

    public GElecInfoCriteria andEndVoltageIsNull() {
        addCriterion("end_voltage is null");
        return this;
    }

    public GElecInfoCriteria andEndVoltageIsNotNull() {
        addCriterion("end_voltage is not null");
        return this;
    }

    public GElecInfoCriteria andEndVoltageEqualTo(String value) {
        addCriterion("end_voltage =", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageNotEqualTo(String value) {
        addCriterion("end_voltage <>", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageGreaterThan(String value) {
        addCriterion("end_voltage >", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageGreaterThanOrEqualTo(String value) {
        addCriterion("end_voltage >=", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageLessThan(String value) {
        addCriterion("end_voltage <", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageLessThanOrEqualTo(String value) {
        addCriterion("end_voltage <=", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageLike(String value) {
        addCriterion("end_voltage like", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageNotLike(String value) {
        addCriterion("end_voltage not like", value, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageIn(List<String> values) {
        addCriterion("end_voltage in", values, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageNotIn(List<String> values) {
        addCriterion("end_voltage not in", values, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageBetween(String value1, String value2) {
        addCriterion("end_voltage between", value1, value2, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndVoltageNotBetween(String value1, String value2) {
        addCriterion("end_voltage not between", value1, value2, "endVoltage");
        return this;
    }

    public GElecInfoCriteria andEndLngIsNull() {
        addCriterion("end_lng is null");
        return this;
    }

    public GElecInfoCriteria andEndLngIsNotNull() {
        addCriterion("end_lng is not null");
        return this;
    }

    public GElecInfoCriteria andEndLngEqualTo(double value) {
        addCriterion("end_lng =", new Double(value), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngNotEqualTo(double value) {
        addCriterion("end_lng <>", new Double(value), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngGreaterThan(double value) {
        addCriterion("end_lng >", new Double(value), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngGreaterThanOrEqualTo(double value) {
        addCriterion("end_lng >=", new Double(value), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngLessThan(double value) {
        addCriterion("end_lng <", new Double(value), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngLessThanOrEqualTo(double value) {
        addCriterion("end_lng <=", new Double(value), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngIn(List<Double> values) {
        addCriterion("end_lng in", values, "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngNotIn(List<Double> values) {
        addCriterion("end_lng not in", values, "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngBetween(double value1, double value2) {
        addCriterion("end_lng between", new Double(value1), new Double(value2), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLngNotBetween(double value1, double value2) {
        addCriterion("end_lng not between", new Double(value1), new Double(value2), "endLng");
        return this;
    }

    public GElecInfoCriteria andEndLatIsNull() {
        addCriterion("end_lat is null");
        return this;
    }

    public GElecInfoCriteria andEndLatIsNotNull() {
        addCriterion("end_lat is not null");
        return this;
    }

    public GElecInfoCriteria andEndLatEqualTo(double value) {
        addCriterion("end_lat =", new Double(value), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatNotEqualTo(double value) {
        addCriterion("end_lat <>", new Double(value), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatGreaterThan(double value) {
        addCriterion("end_lat >", new Double(value), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatGreaterThanOrEqualTo(double value) {
        addCriterion("end_lat >=", new Double(value), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatLessThan(double value) {
        addCriterion("end_lat <", new Double(value), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatLessThanOrEqualTo(double value) {
        addCriterion("end_lat <=", new Double(value), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatIn(List<Double> values) {
        addCriterion("end_lat in", values, "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatNotIn(List<Double> values) {
        addCriterion("end_lat not in", values, "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatBetween(double value1, double value2) {
        addCriterion("end_lat between", new Double(value1), new Double(value2), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndLatNotBetween(double value1, double value2) {
        addCriterion("end_lat not between", new Double(value1), new Double(value2), "endLat");
        return this;
    }

    public GElecInfoCriteria andEndAddrIsNull() {
        addCriterion("end_addr is null");
        return this;
    }

    public GElecInfoCriteria andEndAddrIsNotNull() {
        addCriterion("end_addr is not null");
        return this;
    }

    public GElecInfoCriteria andEndAddrEqualTo(String value) {
        addCriterion("end_addr =", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrNotEqualTo(String value) {
        addCriterion("end_addr <>", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrGreaterThan(String value) {
        addCriterion("end_addr >", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrGreaterThanOrEqualTo(String value) {
        addCriterion("end_addr >=", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrLessThan(String value) {
        addCriterion("end_addr <", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrLessThanOrEqualTo(String value) {
        addCriterion("end_addr <=", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrLike(String value) {
        addCriterion("end_addr like", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrNotLike(String value) {
        addCriterion("end_addr not like", value, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrIn(List<String> values) {
        addCriterion("end_addr in", values, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrNotIn(List<String> values) {
        addCriterion("end_addr not in", values, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrBetween(String value1, String value2) {
        addCriterion("end_addr between", value1, value2, "endAddr");
        return this;
    }

    public GElecInfoCriteria andEndAddrNotBetween(String value1, String value2) {
        addCriterion("end_addr not between", value1, value2, "endAddr");
        return this;
    }

    public GElecInfoCriteria andPic1IsNull() {
        addCriterion("pic1 is null");
        return this;
    }

    public GElecInfoCriteria andPic1IsNotNull() {
        addCriterion("pic1 is not null");
        return this;
    }

    public GElecInfoCriteria andPic1EqualTo(String value) {
        addCriterion("pic1 =", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1NotEqualTo(String value) {
        addCriterion("pic1 <>", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1GreaterThan(String value) {
        addCriterion("pic1 >", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1GreaterThanOrEqualTo(String value) {
        addCriterion("pic1 >=", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1LessThan(String value) {
        addCriterion("pic1 <", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1LessThanOrEqualTo(String value) {
        addCriterion("pic1 <=", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1Like(String value) {
        addCriterion("pic1 like", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1NotLike(String value) {
        addCriterion("pic1 not like", value, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1In(List<String> values) {
        addCriterion("pic1 in", values, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1NotIn(List<String> values) {
        addCriterion("pic1 not in", values, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1Between(String value1, String value2) {
        addCriterion("pic1 between", value1, value2, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic1NotBetween(String value1, String value2) {
        addCriterion("pic1 not between", value1, value2, "pic1");
        return this;
    }

    public GElecInfoCriteria andPic2IsNull() {
        addCriterion("pic2 is null");
        return this;
    }

    public GElecInfoCriteria andPic2IsNotNull() {
        addCriterion("pic2 is not null");
        return this;
    }

    public GElecInfoCriteria andPic2EqualTo(String value) {
        addCriterion("pic2 =", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2NotEqualTo(String value) {
        addCriterion("pic2 <>", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2GreaterThan(String value) {
        addCriterion("pic2 >", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2GreaterThanOrEqualTo(String value) {
        addCriterion("pic2 >=", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2LessThan(String value) {
        addCriterion("pic2 <", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2LessThanOrEqualTo(String value) {
        addCriterion("pic2 <=", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2Like(String value) {
        addCriterion("pic2 like", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2NotLike(String value) {
        addCriterion("pic2 not like", value, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2In(List<String> values) {
        addCriterion("pic2 in", values, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2NotIn(List<String> values) {
        addCriterion("pic2 not in", values, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2Between(String value1, String value2) {
        addCriterion("pic2 between", value1, value2, "pic2");
        return this;
    }

    public GElecInfoCriteria andPic2NotBetween(String value1, String value2) {
        addCriterion("pic2 not between", value1, value2, "pic2");
        return this;
    }

    public GElecInfoCriteria andCreateTimeIsNull() {
        addCriterion("create_time is null");
        return this;
    }

    public GElecInfoCriteria andCreateTimeIsNotNull() {
        addCriterion("create_time is not null");
        return this;
    }

    public GElecInfoCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("create_time =", value, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("create_time <>", value, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("create_time >", value, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("create_time >=", value, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeLessThan(Date value) {
        addCriterion("create_time <", value, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("create_time <=", value, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("create_time in", values, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("create_time not in", values, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("create_time between", value1, value2, "createTime");
        return this;
    }

    public GElecInfoCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("create_time not between", value1, value2, "createTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeIsNull() {
        addCriterion("update_time is null");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeIsNotNull() {
        addCriterion("update_time is not null");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeEqualTo(Date value) {
        addCriterion("update_time =", value, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeNotEqualTo(Date value) {
        addCriterion("update_time <>", value, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeGreaterThan(Date value) {
        addCriterion("update_time >", value, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("update_time >=", value, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeLessThan(Date value) {
        addCriterion("update_time <", value, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeLessThanOrEqualTo(Date value) {
        addCriterion("update_time <=", value, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeIn(List<Date> values) {
        addCriterion("update_time in", values, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeNotIn(List<Date> values) {
        addCriterion("update_time not in", values, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeBetween(Date value1, Date value2) {
        addCriterion("update_time between", value1, value2, "updateTime");
        return this;
    }

    public GElecInfoCriteria andUpdateTimeNotBetween(Date value1, Date value2) {
        addCriterion("update_time not between", value1, value2, "updateTime");
        return this;
    }

    public GElecInfoCriteria andCreatorIdIsNull() {
        addCriterion("creator_id is null");
        return this;
    }

    public GElecInfoCriteria andCreatorIdIsNotNull() {
        addCriterion("creator_id is not null");
        return this;
    }

    public GElecInfoCriteria andCreatorIdEqualTo(int value) {
        addCriterion("creator_id =", new Integer(value), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdNotEqualTo(int value) {
        addCriterion("creator_id <>", new Integer(value), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdGreaterThan(int value) {
        addCriterion("creator_id >", new Integer(value), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdGreaterThanOrEqualTo(int value) {
        addCriterion("creator_id >=", new Integer(value), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdLessThan(int value) {
        addCriterion("creator_id <", new Integer(value), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdLessThanOrEqualTo(int value) {
        addCriterion("creator_id <=", new Integer(value), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdIn(List<Integer> values) {
        addCriterion("creator_id in", values, "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdNotIn(List<Integer> values) {
        addCriterion("creator_id not in", values, "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdBetween(int value1, int value2) {
        addCriterion("creator_id between", new Integer(value1), new Integer(value2), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorIdNotBetween(int value1, int value2) {
        addCriterion("creator_id not between", new Integer(value1), new Integer(value2), "creatorId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdIsNull() {
        addCriterion("creator_agent_id is null");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdIsNotNull() {
        addCriterion("creator_agent_id is not null");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdEqualTo(int value) {
        addCriterion("creator_agent_id =", new Integer(value), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdNotEqualTo(int value) {
        addCriterion("creator_agent_id <>", new Integer(value), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdGreaterThan(int value) {
        addCriterion("creator_agent_id >", new Integer(value), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdGreaterThanOrEqualTo(int value) {
        addCriterion("creator_agent_id >=", new Integer(value), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdLessThan(int value) {
        addCriterion("creator_agent_id <", new Integer(value), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdLessThanOrEqualTo(int value) {
        addCriterion("creator_agent_id <=", new Integer(value), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdIn(List<Integer> values) {
        addCriterion("creator_agent_id in", values, "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdNotIn(List<Integer> values) {
        addCriterion("creator_agent_id not in", values, "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdBetween(int value1, int value2) {
        addCriterion("creator_agent_id between", new Integer(value1), new Integer(value2), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andCreatorAgentIdNotBetween(int value1, int value2) {
        addCriterion("creator_agent_id not between", new Integer(value1), new Integer(value2), "creatorAgentId");
        return this;
    }

    public GElecInfoCriteria andStatusIsNull() {
        addCriterion("status is null");
        return this;
    }

    public GElecInfoCriteria andStatusIsNotNull() {
        addCriterion("status is not null");
        return this;
    }

    public GElecInfoCriteria andStatusEqualTo(int value) {
        addCriterion("status =", new Integer(value), "status");
        return this;
    }

    public GElecInfoCriteria andStatusNotEqualTo(int value) {
        addCriterion("status <>", new Integer(value), "status");
        return this;
    }

    public GElecInfoCriteria andStatusGreaterThan(int value) {
        addCriterion("status >", new Integer(value), "status");
        return this;
    }

    public GElecInfoCriteria andStatusGreaterThanOrEqualTo(int value) {
        addCriterion("status >=", new Integer(value), "status");
        return this;
    }

    public GElecInfoCriteria andStatusLessThan(int value) {
        addCriterion("status <", new Integer(value), "status");
        return this;
    }

    public GElecInfoCriteria andStatusLessThanOrEqualTo(int value) {
        addCriterion("status <=", new Integer(value), "status");
        return this;
    }

    public GElecInfoCriteria andStatusIn(List<Integer> values) {
        addCriterion("status in", values, "status");
        return this;
    }

    public GElecInfoCriteria andStatusNotIn(List<Integer> values) {
        addCriterion("status not in", values, "status");
        return this;
    }

    public GElecInfoCriteria andStatusBetween(int value1, int value2) {
        addCriterion("status between", new Integer(value1), new Integer(value2), "status");
        return this;
    }

    public GElecInfoCriteria andStatusNotBetween(int value1, int value2) {
        addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
        return this;
    }

    public GElecInfoCriteria andRemarkIsNull() {
        addCriterion("remark is null");
        return this;
    }

    public GElecInfoCriteria andRemarkIsNotNull() {
        addCriterion("remark is not null");
        return this;
    }

    public GElecInfoCriteria andRemarkEqualTo(String value) {
        addCriterion("remark =", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkNotEqualTo(String value) {
        addCriterion("remark <>", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkGreaterThan(String value) {
        addCriterion("remark >", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("remark >=", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkLessThan(String value) {
        addCriterion("remark <", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("remark <=", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkLike(String value) {
        addCriterion("remark like", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkNotLike(String value) {
        addCriterion("remark not like", value, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkIn(List<String> values) {
        addCriterion("remark in", values, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkNotIn(List<String> values) {
        addCriterion("remark not in", values, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("remark between", value1, value2, "remark");
        return this;
    }

    public GElecInfoCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("remark not between", value1, value2, "remark");
        return this;
    }
}