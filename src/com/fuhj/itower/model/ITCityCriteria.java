package com.fuhj.itower.model;

import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class ITCityCriteria extends Criteria {

	public ITCityCriteria andItCityIdIsNull() {
		addCriterion("it_city_id is null");
		return this;
	}

	public ITCityCriteria andItCityIdIsNotNull() {
		addCriterion("it_city_id is not null");
		return this;
	}

	public ITCityCriteria andItCityIdEqualTo(String value) {
		addCriterion("it_city_id =", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdNotEqualTo(String value) {
		addCriterion("it_city_id <>", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdGreaterThan(String value) {
		addCriterion("it_city_id >", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_city_id >=", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdLessThan(String value) {
		addCriterion("it_city_id <", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdLessThanOrEqualTo(String value) {
		addCriterion("it_city_id <=", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdLike(String value) {
		addCriterion("it_city_id like", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdNotLike(String value) {
		addCriterion("it_city_id not like", value, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdIn(List<String> values) {
		addCriterion("it_city_id in", values, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdNotIn(List<String> values) {
		addCriterion("it_city_id not in", values, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdBetween(String value1, String value2) {
		addCriterion("it_city_id between", value1, value2, "itCityId");
		return this;
	}

	public ITCityCriteria andItCityIdNotBetween(String value1, String value2) {
		addCriterion("it_city_id not between", value1, value2, "itCityId");
		return this;
	}

	public ITCityCriteria andItProvinceIdIsNull() {
		addCriterion("it_province_id is null");
		return this;
	}

	public ITCityCriteria andItProvinceIdIsNotNull() {
		addCriterion("it_province_id is not null");
		return this;
	}

	public ITCityCriteria andItProvinceIdEqualTo(String value) {
		addCriterion("it_province_id =", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdNotEqualTo(String value) {
		addCriterion("it_province_id <>", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdGreaterThan(String value) {
		addCriterion("it_province_id >", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_province_id >=", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdLessThan(String value) {
		addCriterion("it_province_id <", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdLessThanOrEqualTo(String value) {
		addCriterion("it_province_id <=", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdLike(String value) {
		addCriterion("it_province_id like", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdNotLike(String value) {
		addCriterion("it_province_id not like", value, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdIn(List<String> values) {
		addCriterion("it_province_id in", values, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdNotIn(List<String> values) {
		addCriterion("it_province_id not in", values, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdBetween(String value1, String value2) {
		addCriterion("it_province_id between", value1, value2, "itProvinceId");
		return this;
	}

	public ITCityCriteria andItProvinceIdNotBetween(String value1, String value2) {
		addCriterion("it_province_id not between", value1, value2, "itProvinceId");
		return this;
	}

	public ITCityCriteria andCnameIsNull() {
		addCriterion("cname is null");
		return this;
	}

	public ITCityCriteria andCnameIsNotNull() {
		addCriterion("cname is not null");
		return this;
	}

	public ITCityCriteria andCnameEqualTo(String value) {
		addCriterion("cname =", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameNotEqualTo(String value) {
		addCriterion("cname <>", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameGreaterThan(String value) {
		addCriterion("cname >", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameGreaterThanOrEqualTo(String value) {
		addCriterion("cname >=", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameLessThan(String value) {
		addCriterion("cname <", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameLessThanOrEqualTo(String value) {
		addCriterion("cname <=", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameLike(String value) {
		addCriterion("cname like", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameNotLike(String value) {
		addCriterion("cname not like", value, "cname");
		return this;
	}

	public ITCityCriteria andCnameIn(List<String> values) {
		addCriterion("cname in", values, "cname");
		return this;
	}

	public ITCityCriteria andCnameNotIn(List<String> values) {
		addCriterion("cname not in", values, "cname");
		return this;
	}

	public ITCityCriteria andCnameBetween(String value1, String value2) {
		addCriterion("cname between", value1, value2, "cname");
		return this;
	}

	public ITCityCriteria andCnameNotBetween(String value1, String value2) {
		addCriterion("cname not between", value1, value2, "cname");
		return this;
	}

	public ITCityCriteria andSortruleIsNull() {
		addCriterion("sortrule is null");
		return this;
	}

	public ITCityCriteria andSortruleIsNotNull() {
		addCriterion("sortrule is not null");
		return this;
	}

	public ITCityCriteria andSortruleEqualTo(int value) {
		addCriterion("sortrule =", new Integer(value), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleNotEqualTo(int value) {
		addCriterion("sortrule <>", new Integer(value), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleGreaterThan(int value) {
		addCriterion("sortrule >", new Integer(value), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleGreaterThanOrEqualTo(int value) {
		addCriterion("sortrule >=", new Integer(value), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleLessThan(int value) {
		addCriterion("sortrule <", new Integer(value), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleLessThanOrEqualTo(int value) {
		addCriterion("sortrule <=", new Integer(value), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleIn(List<Integer> values) {
		addCriterion("sortrule in", values, "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleNotIn(List<Integer> values) {
		addCriterion("sortrule not in", values, "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleBetween(int value1, int value2) {
		addCriterion("sortrule between", new Integer(value1), new Integer(value2), "sortrule");
		return this;
	}

	public ITCityCriteria andSortruleNotBetween(int value1, int value2) {
		addCriterion("sortrule not between", new Integer(value1), new Integer(value2), "sortrule");
		return this;
	}
}