package com.fuhj.itower.model;

import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class StaAgtStaffCriteria extends Criteria {

	public StaAgtStaffCriteria andSasIdIsNull() {
		addCriterion("sas_id is null");
		return this;
	}

	public StaAgtStaffCriteria andSasIdIsNotNull() {
		addCriterion("sas_id is not null");
		return this;
	}

	public StaAgtStaffCriteria andSasIdEqualTo(int value) {
		addCriterion("sas_id =", new Integer(value), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdNotEqualTo(int value) {
		addCriterion("sas_id <>", new Integer(value), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdGreaterThan(int value) {
		addCriterion("sas_id >", new Integer(value), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdGreaterThanOrEqualTo(int value) {
		addCriterion("sas_id >=", new Integer(value), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdLessThan(int value) {
		addCriterion("sas_id <", new Integer(value), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdLessThanOrEqualTo(int value) {
		addCriterion("sas_id <=", new Integer(value), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdIn(List<Integer> values) {
		addCriterion("sas_id in", values, "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdNotIn(List<Integer> values) {
		addCriterion("sas_id not in", values, "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdBetween(int value1, int value2) {
		addCriterion("sas_id between", new Integer(value1), new Integer(value2), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andSasIdNotBetween(int value1, int value2) {
		addCriterion("sas_id not between", new Integer(value1), new Integer(value2), "sasId");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeIsNull() {
		addCriterion("stationCode is null");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeIsNotNull() {
		addCriterion("stationCode is not null");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeEqualTo(String value) {
		addCriterion("stationCode =", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeNotEqualTo(String value) {
		addCriterion("stationCode <>", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeGreaterThan(String value) {
		addCriterion("stationCode >", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeGreaterThanOrEqualTo(String value) {
		addCriterion("stationCode >=", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeLessThan(String value) {
		addCriterion("stationCode <", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeLessThanOrEqualTo(String value) {
		addCriterion("stationCode <=", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeLike(String value) {
		addCriterion("stationCode like", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeNotLike(String value) {
		addCriterion("stationCode not like", value, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeIn(List<String> values) {
		addCriterion("stationCode in", values, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeNotIn(List<String> values) {
		addCriterion("stationCode not in", values, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeBetween(String value1, String value2) {
		addCriterion("stationCode between", value1, value2, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andStationcodeNotBetween(String value1, String value2) {
		addCriterion("stationCode not between", value1, value2, "stationcode");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameIsNull() {
		addCriterion("agstaffName is null");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameIsNotNull() {
		addCriterion("agstaffName is not null");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameEqualTo(String value) {
		addCriterion("agstaffName =", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameNotEqualTo(String value) {
		addCriterion("agstaffName <>", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameGreaterThan(String value) {
		addCriterion("agstaffName >", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameGreaterThanOrEqualTo(String value) {
		addCriterion("agstaffName >=", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameLessThan(String value) {
		addCriterion("agstaffName <", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameLessThanOrEqualTo(String value) {
		addCriterion("agstaffName <=", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameLike(String value) {
		addCriterion("agstaffName like", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameNotLike(String value) {
		addCriterion("agstaffName not like", value, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameIn(List<String> values) {
		addCriterion("agstaffName in", values, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameNotIn(List<String> values) {
		addCriterion("agstaffName not in", values, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameBetween(String value1, String value2) {
		addCriterion("agstaffName between", value1, value2, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstaffnameNotBetween(String value1, String value2) {
		addCriterion("agstaffName not between", value1, value2, "agstaffname");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelIsNull() {
		addCriterion("agstaffTel is null");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelIsNotNull() {
		addCriterion("agstaffTel is not null");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelEqualTo(String value) {
		addCriterion("agstaffTel =", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelNotEqualTo(String value) {
		addCriterion("agstaffTel <>", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelGreaterThan(String value) {
		addCriterion("agstaffTel >", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelGreaterThanOrEqualTo(String value) {
		addCriterion("agstaffTel >=", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelLessThan(String value) {
		addCriterion("agstaffTel <", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelLessThanOrEqualTo(String value) {
		addCriterion("agstaffTel <=", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelLike(String value) {
		addCriterion("agstaffTel like", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelNotLike(String value) {
		addCriterion("agstaffTel not like", value, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelIn(List<String> values) {
		addCriterion("agstaffTel in", values, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelNotIn(List<String> values) {
		addCriterion("agstaffTel not in", values, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelBetween(String value1, String value2) {
		addCriterion("agstaffTel between", value1, value2, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andAgstafftelNotBetween(String value1, String value2) {
		addCriterion("agstaffTel not between", value1, value2, "agstafftel");
		return this;
	}

	public StaAgtStaffCriteria andRemarkIsNull() {
		addCriterion("remark is null");
		return this;
	}

	public StaAgtStaffCriteria andRemarkIsNotNull() {
		addCriterion("remark is not null");
		return this;
	}

	public StaAgtStaffCriteria andRemarkEqualTo(String value) {
		addCriterion("remark =", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkNotEqualTo(String value) {
		addCriterion("remark <>", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkGreaterThan(String value) {
		addCriterion("remark >", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkGreaterThanOrEqualTo(String value) {
		addCriterion("remark >=", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkLessThan(String value) {
		addCriterion("remark <", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkLessThanOrEqualTo(String value) {
		addCriterion("remark <=", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkLike(String value) {
		addCriterion("remark like", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkNotLike(String value) {
		addCriterion("remark not like", value, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkIn(List<String> values) {
		addCriterion("remark in", values, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkNotIn(List<String> values) {
		addCriterion("remark not in", values, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkBetween(String value1, String value2) {
		addCriterion("remark between", value1, value2, "remark");
		return this;
	}

	public StaAgtStaffCriteria andRemarkNotBetween(String value1, String value2) {
		addCriterion("remark not between", value1, value2, "remark");
		return this;
	}

	public StaAgtStaffCriteria andStatusIsNull() {
		addCriterion("status is null");
		return this;
	}

	public StaAgtStaffCriteria andStatusIsNotNull() {
		addCriterion("status is not null");
		return this;
	}

	public StaAgtStaffCriteria andStatusEqualTo(int value) {
		addCriterion("status =", new Integer(value), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusNotEqualTo(int value) {
		addCriterion("status <>", new Integer(value), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusGreaterThan(int value) {
		addCriterion("status >", new Integer(value), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusGreaterThanOrEqualTo(int value) {
		addCriterion("status >=", new Integer(value), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusLessThan(int value) {
		addCriterion("status <", new Integer(value), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusLessThanOrEqualTo(int value) {
		addCriterion("status <=", new Integer(value), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusIn(List<Integer> values) {
		addCriterion("status in", values, "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusNotIn(List<Integer> values) {
		addCriterion("status not in", values, "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusBetween(int value1, int value2) {
		addCriterion("status between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public StaAgtStaffCriteria andStatusNotBetween(int value1, int value2) {
		addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
		return this;
	}
}