package com.fuhj.itower.model;

import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class ITProvinceCriteria extends Criteria {

	public ITProvinceCriteria andItProvinceIdIsNull() {
		addCriterion("it_province_id is null");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdIsNotNull() {
		addCriterion("it_province_id is not null");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdEqualTo(String value) {
		addCriterion("it_province_id =", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdNotEqualTo(String value) {
		addCriterion("it_province_id <>", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdGreaterThan(String value) {
		addCriterion("it_province_id >", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_province_id >=", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdLessThan(String value) {
		addCriterion("it_province_id <", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdLessThanOrEqualTo(String value) {
		addCriterion("it_province_id <=", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdLike(String value) {
		addCriterion("it_province_id like", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdNotLike(String value) {
		addCriterion("it_province_id not like", value, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdIn(List<String> values) {
		addCriterion("it_province_id in", values, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdNotIn(List<String> values) {
		addCriterion("it_province_id not in", values, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdBetween(String value1, String value2) {
		addCriterion("it_province_id between", value1, value2, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andItProvinceIdNotBetween(String value1, String value2) {
		addCriterion("it_province_id not between", value1, value2, "itProvinceId");
		return this;
	}

	public ITProvinceCriteria andPnameIsNull() {
		addCriterion("pname is null");
		return this;
	}

	public ITProvinceCriteria andPnameIsNotNull() {
		addCriterion("pname is not null");
		return this;
	}

	public ITProvinceCriteria andPnameEqualTo(String value) {
		addCriterion("pname =", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameNotEqualTo(String value) {
		addCriterion("pname <>", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameGreaterThan(String value) {
		addCriterion("pname >", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameGreaterThanOrEqualTo(String value) {
		addCriterion("pname >=", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameLessThan(String value) {
		addCriterion("pname <", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameLessThanOrEqualTo(String value) {
		addCriterion("pname <=", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameLike(String value) {
		addCriterion("pname like", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameNotLike(String value) {
		addCriterion("pname not like", value, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameIn(List<String> values) {
		addCriterion("pname in", values, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameNotIn(List<String> values) {
		addCriterion("pname not in", values, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameBetween(String value1, String value2) {
		addCriterion("pname between", value1, value2, "pname");
		return this;
	}

	public ITProvinceCriteria andPnameNotBetween(String value1, String value2) {
		addCriterion("pname not between", value1, value2, "pname");
		return this;
	}

	public ITProvinceCriteria andSortruleIsNull() {
		addCriterion("sortrule is null");
		return this;
	}

	public ITProvinceCriteria andSortruleIsNotNull() {
		addCriterion("sortrule is not null");
		return this;
	}

	public ITProvinceCriteria andSortruleEqualTo(int value) {
		addCriterion("sortrule =", new Integer(value), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleNotEqualTo(int value) {
		addCriterion("sortrule <>", new Integer(value), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleGreaterThan(int value) {
		addCriterion("sortrule >", new Integer(value), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleGreaterThanOrEqualTo(int value) {
		addCriterion("sortrule >=", new Integer(value), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleLessThan(int value) {
		addCriterion("sortrule <", new Integer(value), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleLessThanOrEqualTo(int value) {
		addCriterion("sortrule <=", new Integer(value), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleIn(List<Integer> values) {
		addCriterion("sortrule in", values, "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleNotIn(List<Integer> values) {
		addCriterion("sortrule not in", values, "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleBetween(int value1, int value2) {
		addCriterion("sortrule between", new Integer(value1), new Integer(value2), "sortrule");
		return this;
	}

	public ITProvinceCriteria andSortruleNotBetween(int value1, int value2) {
		addCriterion("sortrule not between", new Integer(value1), new Integer(value2), "sortrule");
		return this;
	}
}