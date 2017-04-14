package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class FSUCondItemCriteria extends Criteria {

	public FSUCondItemCriteria andIdIsNull() {
		addCriterion("id is null");
		return this;
	}

	public FSUCondItemCriteria andIdIsNotNull() {
		addCriterion("id is not null");
		return this;
	}

	public FSUCondItemCriteria andIdEqualTo(int value) {
		addCriterion("id =", new Integer(value), "id");
		return this;
	}

	public FSUCondItemCriteria andIdNotEqualTo(int value) {
		addCriterion("id <>", new Integer(value), "id");
		return this;
	}

	public FSUCondItemCriteria andIdGreaterThan(int value) {
		addCriterion("id >", new Integer(value), "id");
		return this;
	}

	public FSUCondItemCriteria andIdGreaterThanOrEqualTo(int value) {
		addCriterion("id >=", new Integer(value), "id");
		return this;
	}

	public FSUCondItemCriteria andIdLessThan(int value) {
		addCriterion("id <", new Integer(value), "id");
		return this;
	}

	public FSUCondItemCriteria andIdLessThanOrEqualTo(int value) {
		addCriterion("id <=", new Integer(value), "id");
		return this;
	}

	public FSUCondItemCriteria andIdIn(List<Integer> values) {
		addCriterion("id in", values, "id");
		return this;
	}

	public FSUCondItemCriteria andIdNotIn(List<Integer> values) {
		addCriterion("id not in", values, "id");
		return this;
	}

	public FSUCondItemCriteria andIdBetween(int value1, int value2) {
		addCriterion("id between", new Integer(value1), new Integer(value2), "id");
		return this;
	}

	public FSUCondItemCriteria andIdNotBetween(int value1, int value2) {
		addCriterion("id not between", new Integer(value1), new Integer(value2), "id");
		return this;
	}

	public FSUCondItemCriteria andQueryidIsNull() {
		addCriterion("queryId is null");
		return this;
	}

	public FSUCondItemCriteria andQueryidIsNotNull() {
		addCriterion("queryId is not null");
		return this;
	}

	public FSUCondItemCriteria andQueryidEqualTo(long value) {
		addCriterion("queryId =", new Long(value), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidNotEqualTo(long value) {
		addCriterion("queryId <>", new Long(value), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidGreaterThan(long value) {
		addCriterion("queryId >", new Long(value), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidGreaterThanOrEqualTo(long value) {
		addCriterion("queryId >=", new Long(value), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidLessThan(long value) {
		addCriterion("queryId <", new Long(value), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidLessThanOrEqualTo(long value) {
		addCriterion("queryId <=", new Long(value), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidIn(List<Long> values) {
		addCriterion("queryId in", values, "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidNotIn(List<Long> values) {
		addCriterion("queryId not in", values, "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidBetween(long value1, long value2) {
		addCriterion("queryId between", new Long(value1), new Long(value2), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQueryidNotBetween(long value1, long value2) {
		addCriterion("queryId not between", new Long(value1), new Long(value2), "queryid");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeIsNull() {
		addCriterion("queryTime is null");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeIsNotNull() {
		addCriterion("queryTime is not null");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeEqualTo(Date value) {
		addCriterionForJDBCDate("queryTime =", value, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeNotEqualTo(Date value) {
		addCriterionForJDBCDate("queryTime <>", value, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeGreaterThan(Date value) {
		addCriterionForJDBCDate("queryTime >", value, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeGreaterThanOrEqualTo(Date value) {
		addCriterionForJDBCDate("queryTime >=", value, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeLessThan(Date value) {
		addCriterionForJDBCDate("queryTime <", value, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeLessThanOrEqualTo(Date value) {
		addCriterionForJDBCDate("queryTime <=", value, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeIn(List<Date> values) {
		addCriterionForJDBCDate("queryTime in", values, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeNotIn(List<Date> values) {
		addCriterionForJDBCDate("queryTime not in", values, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeBetween(Date value1, Date value2) {
		addCriterionForJDBCDate("queryTime between", value1, value2, "querytime");
		return this;
	}

	public FSUCondItemCriteria andQuerytimeNotBetween(Date value1, Date value2) {
		addCriterionForJDBCDate("queryTime not between", value1, value2, "querytime");
		return this;
	}

	public FSUCondItemCriteria andAreanameIsNull() {
		addCriterion("areaName is null");
		return this;
	}

	public FSUCondItemCriteria andAreanameIsNotNull() {
		addCriterion("areaName is not null");
		return this;
	}

	public FSUCondItemCriteria andAreanameEqualTo(String value) {
		addCriterion("areaName =", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameNotEqualTo(String value) {
		addCriterion("areaName <>", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameGreaterThan(String value) {
		addCriterion("areaName >", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameGreaterThanOrEqualTo(String value) {
		addCriterion("areaName >=", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameLessThan(String value) {
		addCriterion("areaName <", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameLessThanOrEqualTo(String value) {
		addCriterion("areaName <=", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameLike(String value) {
		addCriterion("areaName like", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameNotLike(String value) {
		addCriterion("areaName not like", value, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameIn(List<String> values) {
		addCriterion("areaName in", values, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameNotIn(List<String> values) {
		addCriterion("areaName not in", values, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameBetween(String value1, String value2) {
		addCriterion("areaName between", value1, value2, "areaname");
		return this;
	}

	public FSUCondItemCriteria andAreanameNotBetween(String value1, String value2) {
		addCriterion("areaName not between", value1, value2, "areaname");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidIsNull() {
		addCriterion("itProvinceId is null");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidIsNotNull() {
		addCriterion("itProvinceId is not null");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidEqualTo(String value) {
		addCriterion("itProvinceId =", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidNotEqualTo(String value) {
		addCriterion("itProvinceId <>", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidGreaterThan(String value) {
		addCriterion("itProvinceId >", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidGreaterThanOrEqualTo(String value) {
		addCriterion("itProvinceId >=", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidLessThan(String value) {
		addCriterion("itProvinceId <", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidLessThanOrEqualTo(String value) {
		addCriterion("itProvinceId <=", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidLike(String value) {
		addCriterion("itProvinceId like", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidNotLike(String value) {
		addCriterion("itProvinceId not like", value, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidIn(List<String> values) {
		addCriterion("itProvinceId in", values, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidNotIn(List<String> values) {
		addCriterion("itProvinceId not in", values, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidBetween(String value1, String value2) {
		addCriterion("itProvinceId between", value1, value2, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItprovinceidNotBetween(String value1, String value2) {
		addCriterion("itProvinceId not between", value1, value2, "itprovinceid");
		return this;
	}

	public FSUCondItemCriteria andItcityidIsNull() {
		addCriterion("itCityId is null");
		return this;
	}

	public FSUCondItemCriteria andItcityidIsNotNull() {
		addCriterion("itCityId is not null");
		return this;
	}

	public FSUCondItemCriteria andItcityidEqualTo(String value) {
		addCriterion("itCityId =", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidNotEqualTo(String value) {
		addCriterion("itCityId <>", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidGreaterThan(String value) {
		addCriterion("itCityId >", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidGreaterThanOrEqualTo(String value) {
		addCriterion("itCityId >=", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidLessThan(String value) {
		addCriterion("itCityId <", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidLessThanOrEqualTo(String value) {
		addCriterion("itCityId <=", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidLike(String value) {
		addCriterion("itCityId like", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidNotLike(String value) {
		addCriterion("itCityId not like", value, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidIn(List<String> values) {
		addCriterion("itCityId in", values, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidNotIn(List<String> values) {
		addCriterion("itCityId not in", values, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidBetween(String value1, String value2) {
		addCriterion("itCityId between", value1, value2, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItcityidNotBetween(String value1, String value2) {
		addCriterion("itCityId not between", value1, value2, "itcityid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidIsNull() {
		addCriterion("itDistrictId is null");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidIsNotNull() {
		addCriterion("itDistrictId is not null");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidEqualTo(String value) {
		addCriterion("itDistrictId =", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidNotEqualTo(String value) {
		addCriterion("itDistrictId <>", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidGreaterThan(String value) {
		addCriterion("itDistrictId >", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidGreaterThanOrEqualTo(String value) {
		addCriterion("itDistrictId >=", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidLessThan(String value) {
		addCriterion("itDistrictId <", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidLessThanOrEqualTo(String value) {
		addCriterion("itDistrictId <=", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidLike(String value) {
		addCriterion("itDistrictId like", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidNotLike(String value) {
		addCriterion("itDistrictId not like", value, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidIn(List<String> values) {
		addCriterion("itDistrictId in", values, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidNotIn(List<String> values) {
		addCriterion("itDistrictId not in", values, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidBetween(String value1, String value2) {
		addCriterion("itDistrictId between", value1, value2, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andItdistrictidNotBetween(String value1, String value2) {
		addCriterion("itDistrictId not between", value1, value2, "itdistrictid");
		return this;
	}

	public FSUCondItemCriteria andTdcountIsNull() {
		addCriterion("tdCount is null");
		return this;
	}

	public FSUCondItemCriteria andTdcountIsNotNull() {
		addCriterion("tdCount is not null");
		return this;
	}

	public FSUCondItemCriteria andTdcountEqualTo(int value) {
		addCriterion("tdCount =", new Integer(value), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountNotEqualTo(int value) {
		addCriterion("tdCount <>", new Integer(value), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountGreaterThan(int value) {
		addCriterion("tdCount >", new Integer(value), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountGreaterThanOrEqualTo(int value) {
		addCriterion("tdCount >=", new Integer(value), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountLessThan(int value) {
		addCriterion("tdCount <", new Integer(value), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountLessThanOrEqualTo(int value) {
		addCriterion("tdCount <=", new Integer(value), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountIn(List<Integer> values) {
		addCriterion("tdCount in", values, "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountNotIn(List<Integer> values) {
		addCriterion("tdCount not in", values, "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountBetween(int value1, int value2) {
		addCriterion("tdCount between", new Integer(value1), new Integer(value2), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andTdcountNotBetween(int value1, int value2) {
		addCriterion("tdCount not between", new Integer(value1), new Integer(value2), "tdcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountIsNull() {
		addCriterion("vlowCount is null");
		return this;
	}

	public FSUCondItemCriteria andVlowcountIsNotNull() {
		addCriterion("vlowCount is not null");
		return this;
	}

	public FSUCondItemCriteria andVlowcountEqualTo(int value) {
		addCriterion("vlowCount =", new Integer(value), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountNotEqualTo(int value) {
		addCriterion("vlowCount <>", new Integer(value), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountGreaterThan(int value) {
		addCriterion("vlowCount >", new Integer(value), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountGreaterThanOrEqualTo(int value) {
		addCriterion("vlowCount >=", new Integer(value), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountLessThan(int value) {
		addCriterion("vlowCount <", new Integer(value), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountLessThanOrEqualTo(int value) {
		addCriterion("vlowCount <=", new Integer(value), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountIn(List<Integer> values) {
		addCriterion("vlowCount in", values, "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountNotIn(List<Integer> values) {
		addCriterion("vlowCount not in", values, "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountBetween(int value1, int value2) {
		addCriterion("vlowCount between", new Integer(value1), new Integer(value2), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andVlowcountNotBetween(int value1, int value2) {
		addCriterion("vlowCount not between", new Integer(value1), new Integer(value2), "vlowcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountIsNull() {
		addCriterion("dzCount is null");
		return this;
	}

	public FSUCondItemCriteria andDzcountIsNotNull() {
		addCriterion("dzCount is not null");
		return this;
	}

	public FSUCondItemCriteria andDzcountEqualTo(int value) {
		addCriterion("dzCount =", new Integer(value), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountNotEqualTo(int value) {
		addCriterion("dzCount <>", new Integer(value), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountGreaterThan(int value) {
		addCriterion("dzCount >", new Integer(value), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountGreaterThanOrEqualTo(int value) {
		addCriterion("dzCount >=", new Integer(value), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountLessThan(int value) {
		addCriterion("dzCount <", new Integer(value), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountLessThanOrEqualTo(int value) {
		addCriterion("dzCount <=", new Integer(value), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountIn(List<Integer> values) {
		addCriterion("dzCount in", values, "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountNotIn(List<Integer> values) {
		addCriterion("dzCount not in", values, "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountBetween(int value1, int value2) {
		addCriterion("dzCount between", new Integer(value1), new Integer(value2), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andDzcountNotBetween(int value1, int value2) {
		addCriterion("dzCount not between", new Integer(value1), new Integer(value2), "dzcount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountIsNull() {
		addCriterion("offlineCount is null");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountIsNotNull() {
		addCriterion("offlineCount is not null");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountEqualTo(int value) {
		addCriterion("offlineCount =", new Integer(value), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountNotEqualTo(int value) {
		addCriterion("offlineCount <>", new Integer(value), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountGreaterThan(int value) {
		addCriterion("offlineCount >", new Integer(value), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountGreaterThanOrEqualTo(int value) {
		addCriterion("offlineCount >=", new Integer(value), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountLessThan(int value) {
		addCriterion("offlineCount <", new Integer(value), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountLessThanOrEqualTo(int value) {
		addCriterion("offlineCount <=", new Integer(value), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountIn(List<Integer> values) {
		addCriterion("offlineCount in", values, "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountNotIn(List<Integer> values) {
		addCriterion("offlineCount not in", values, "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountBetween(int value1, int value2) {
		addCriterion("offlineCount between", new Integer(value1), new Integer(value2), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andOfflinecountNotBetween(int value1, int value2) {
		addCriterion("offlineCount not between", new Integer(value1), new Integer(value2), "offlinecount");
		return this;
	}

	public FSUCondItemCriteria andSortIsNull() {
		addCriterion("sort is null");
		return this;
	}

	public FSUCondItemCriteria andSortIsNotNull() {
		addCriterion("sort is not null");
		return this;
	}

	public FSUCondItemCriteria andSortEqualTo(int value) {
		addCriterion("sort =", new Integer(value), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortNotEqualTo(int value) {
		addCriterion("sort <>", new Integer(value), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortGreaterThan(int value) {
		addCriterion("sort >", new Integer(value), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortGreaterThanOrEqualTo(int value) {
		addCriterion("sort >=", new Integer(value), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortLessThan(int value) {
		addCriterion("sort <", new Integer(value), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortLessThanOrEqualTo(int value) {
		addCriterion("sort <=", new Integer(value), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortIn(List<Integer> values) {
		addCriterion("sort in", values, "sort");
		return this;
	}

	public FSUCondItemCriteria andSortNotIn(List<Integer> values) {
		addCriterion("sort not in", values, "sort");
		return this;
	}

	public FSUCondItemCriteria andSortBetween(int value1, int value2) {
		addCriterion("sort between", new Integer(value1), new Integer(value2), "sort");
		return this;
	}

	public FSUCondItemCriteria andSortNotBetween(int value1, int value2) {
		addCriterion("sort not between", new Integer(value1), new Integer(value2), "sort");
		return this;
	}
}