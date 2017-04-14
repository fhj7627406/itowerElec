package com.fuhj.itower.model;

import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class ITDistrictCriteria extends Criteria {

	public ITDistrictCriteria andItDistrictIdIsNull() {
		addCriterion("it_district_id is null");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdIsNotNull() {
		addCriterion("it_district_id is not null");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdEqualTo(String value) {
		addCriterion("it_district_id =", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdNotEqualTo(String value) {
		addCriterion("it_district_id <>", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdGreaterThan(String value) {
		addCriterion("it_district_id >", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_district_id >=", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdLessThan(String value) {
		addCriterion("it_district_id <", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdLessThanOrEqualTo(String value) {
		addCriterion("it_district_id <=", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdLike(String value) {
		addCriterion("it_district_id like", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdNotLike(String value) {
		addCriterion("it_district_id not like", value, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdIn(List<String> values) {
		addCriterion("it_district_id in", values, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdNotIn(List<String> values) {
		addCriterion("it_district_id not in", values, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdBetween(String value1, String value2) {
		addCriterion("it_district_id between", value1, value2, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItDistrictIdNotBetween(String value1, String value2) {
		addCriterion("it_district_id not between", value1, value2, "itDistrictId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdIsNull() {
		addCriterion("it_province_id is null");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdIsNotNull() {
		addCriterion("it_province_id is not null");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdEqualTo(String value) {
		addCriterion("it_province_id =", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdNotEqualTo(String value) {
		addCriterion("it_province_id <>", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdGreaterThan(String value) {
		addCriterion("it_province_id >", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_province_id >=", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdLessThan(String value) {
		addCriterion("it_province_id <", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdLessThanOrEqualTo(String value) {
		addCriterion("it_province_id <=", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdLike(String value) {
		addCriterion("it_province_id like", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdNotLike(String value) {
		addCriterion("it_province_id not like", value, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdIn(List<String> values) {
		addCriterion("it_province_id in", values, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdNotIn(List<String> values) {
		addCriterion("it_province_id not in", values, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdBetween(String value1, String value2) {
		addCriterion("it_province_id between", value1, value2, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItProvinceIdNotBetween(String value1, String value2) {
		addCriterion("it_province_id not between", value1, value2, "itProvinceId");
		return this;
	}

	public ITDistrictCriteria andItCityIdIsNull() {
		addCriterion("it_city_id is null");
		return this;
	}

	public ITDistrictCriteria andItCityIdIsNotNull() {
		addCriterion("it_city_id is not null");
		return this;
	}

	public ITDistrictCriteria andItCityIdEqualTo(String value) {
		addCriterion("it_city_id =", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdNotEqualTo(String value) {
		addCriterion("it_city_id <>", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdGreaterThan(String value) {
		addCriterion("it_city_id >", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_city_id >=", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdLessThan(String value) {
		addCriterion("it_city_id <", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdLessThanOrEqualTo(String value) {
		addCriterion("it_city_id <=", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdLike(String value) {
		addCriterion("it_city_id like", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdNotLike(String value) {
		addCriterion("it_city_id not like", value, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdIn(List<String> values) {
		addCriterion("it_city_id in", values, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdNotIn(List<String> values) {
		addCriterion("it_city_id not in", values, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdBetween(String value1, String value2) {
		addCriterion("it_city_id between", value1, value2, "itCityId");
		return this;
	}

	public ITDistrictCriteria andItCityIdNotBetween(String value1, String value2) {
		addCriterion("it_city_id not between", value1, value2, "itCityId");
		return this;
	}

	public ITDistrictCriteria andDnameIsNull() {
		addCriterion("dname is null");
		return this;
	}

	public ITDistrictCriteria andDnameIsNotNull() {
		addCriterion("dname is not null");
		return this;
	}

	public ITDistrictCriteria andDnameEqualTo(String value) {
		addCriterion("dname =", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameNotEqualTo(String value) {
		addCriterion("dname <>", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameGreaterThan(String value) {
		addCriterion("dname >", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameGreaterThanOrEqualTo(String value) {
		addCriterion("dname >=", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameLessThan(String value) {
		addCriterion("dname <", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameLessThanOrEqualTo(String value) {
		addCriterion("dname <=", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameLike(String value) {
		addCriterion("dname like", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameNotLike(String value) {
		addCriterion("dname not like", value, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameIn(List<String> values) {
		addCriterion("dname in", values, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameNotIn(List<String> values) {
		addCriterion("dname not in", values, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameBetween(String value1, String value2) {
		addCriterion("dname between", value1, value2, "dname");
		return this;
	}

	public ITDistrictCriteria andDnameNotBetween(String value1, String value2) {
		addCriterion("dname not between", value1, value2, "dname");
		return this;
	}

	public ITDistrictCriteria andDshortnameIsNull() {
		addCriterion("dshortname is null");
		return this;
	}

	public ITDistrictCriteria andDshortnameIsNotNull() {
		addCriterion("dshortname is not null");
		return this;
	}

	public ITDistrictCriteria andDshortnameEqualTo(String value) {
		addCriterion("dshortname =", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameNotEqualTo(String value) {
		addCriterion("dshortname <>", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameGreaterThan(String value) {
		addCriterion("dshortname >", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameGreaterThanOrEqualTo(String value) {
		addCriterion("dshortname >=", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameLessThan(String value) {
		addCriterion("dshortname <", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameLessThanOrEqualTo(String value) {
		addCriterion("dshortname <=", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameLike(String value) {
		addCriterion("dshortname like", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameNotLike(String value) {
		addCriterion("dshortname not like", value, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameIn(List<String> values) {
		addCriterion("dshortname in", values, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameNotIn(List<String> values) {
		addCriterion("dshortname not in", values, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameBetween(String value1, String value2) {
		addCriterion("dshortname between", value1, value2, "dshortname");
		return this;
	}

	public ITDistrictCriteria andDshortnameNotBetween(String value1, String value2) {
		addCriterion("dshortname not between", value1, value2, "dshortname");
		return this;
	}

	public ITDistrictCriteria andSortruleIsNull() {
		addCriterion("sortrule is null");
		return this;
	}

	public ITDistrictCriteria andSortruleIsNotNull() {
		addCriterion("sortrule is not null");
		return this;
	}

	public ITDistrictCriteria andSortruleEqualTo(int value) {
		addCriterion("sortrule =", new Integer(value), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleNotEqualTo(int value) {
		addCriterion("sortrule <>", new Integer(value), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleGreaterThan(int value) {
		addCriterion("sortrule >", new Integer(value), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleGreaterThanOrEqualTo(int value) {
		addCriterion("sortrule >=", new Integer(value), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleLessThan(int value) {
		addCriterion("sortrule <", new Integer(value), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleLessThanOrEqualTo(int value) {
		addCriterion("sortrule <=", new Integer(value), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleIn(List<Integer> values) {
		addCriterion("sortrule in", values, "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleNotIn(List<Integer> values) {
		addCriterion("sortrule not in", values, "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleBetween(int value1, int value2) {
		addCriterion("sortrule between", new Integer(value1), new Integer(value2), "sortrule");
		return this;
	}

	public ITDistrictCriteria andSortruleNotBetween(int value1, int value2) {
		addCriterion("sortrule not between", new Integer(value1), new Integer(value2), "sortrule");
		return this;
	}
}