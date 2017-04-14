package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class AlarmQueryLogCriteria extends Criteria {

	public AlarmQueryLogCriteria andLogIdIsNull() {
		addCriterion("log_id is null");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdIsNotNull() {
		addCriterion("log_id is not null");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdEqualTo(int value) {
		addCriterion("log_id =", new Integer(value), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdNotEqualTo(int value) {
		addCriterion("log_id <>", new Integer(value), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdGreaterThan(int value) {
		addCriterion("log_id >", new Integer(value), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdGreaterThanOrEqualTo(int value) {
		addCriterion("log_id >=", new Integer(value), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdLessThan(int value) {
		addCriterion("log_id <", new Integer(value), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdLessThanOrEqualTo(int value) {
		addCriterion("log_id <=", new Integer(value), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdIn(List<Integer> values) {
		addCriterion("log_id in", values, "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdNotIn(List<Integer> values) {
		addCriterion("log_id not in", values, "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdBetween(int value1, int value2) {
		addCriterion("log_id between", new Integer(value1), new Integer(value2), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andLogIdNotBetween(int value1, int value2) {
		addCriterion("log_id not between", new Integer(value1), new Integer(value2), "logId");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeIsNull() {
		addCriterion("queryTime is null");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeIsNotNull() {
		addCriterion("queryTime is not null");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeEqualTo(Date value) {
		addCriterion("queryTime =", value, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeNotEqualTo(Date value) {
		addCriterion("queryTime <>", value, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeGreaterThan(Date value) {
		addCriterion("queryTime >", value, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeGreaterThanOrEqualTo(Date value) {
		addCriterion("queryTime >=", value, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeLessThan(Date value) {
		addCriterion("queryTime <", value, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeLessThanOrEqualTo(Date value) {
		addCriterion("queryTime <=", value, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeIn(List<Date> values) {
		addCriterion("queryTime in", values, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeNotIn(List<Date> values) {
		addCriterion("queryTime not in", values, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeBetween(Date value1, Date value2) {
		addCriterion("queryTime between", value1, value2, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andQuerytimeNotBetween(Date value1, Date value2) {
		addCriterion("queryTime not between", value1, value2, "querytime");
		return this;
	}

	public AlarmQueryLogCriteria andUseridIsNull() {
		addCriterion("userId is null");
		return this;
	}

	public AlarmQueryLogCriteria andUseridIsNotNull() {
		addCriterion("userId is not null");
		return this;
	}

	public AlarmQueryLogCriteria andUseridEqualTo(int value) {
		addCriterion("userId =", new Integer(value), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridNotEqualTo(int value) {
		addCriterion("userId <>", new Integer(value), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridGreaterThan(int value) {
		addCriterion("userId >", new Integer(value), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridGreaterThanOrEqualTo(int value) {
		addCriterion("userId >=", new Integer(value), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridLessThan(int value) {
		addCriterion("userId <", new Integer(value), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridLessThanOrEqualTo(int value) {
		addCriterion("userId <=", new Integer(value), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridIn(List<Integer> values) {
		addCriterion("userId in", values, "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridNotIn(List<Integer> values) {
		addCriterion("userId not in", values, "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridBetween(int value1, int value2) {
		addCriterion("userId between", new Integer(value1), new Integer(value2), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andUseridNotBetween(int value1, int value2) {
		addCriterion("userId not between", new Integer(value1), new Integer(value2), "userid");
		return this;
	}

	public AlarmQueryLogCriteria andRangeIsNull() {
		addCriterion("range is null");
		return this;
	}

	public AlarmQueryLogCriteria andRangeIsNotNull() {
		addCriterion("range is not null");
		return this;
	}

	public AlarmQueryLogCriteria andRangeEqualTo(String value) {
		addCriterion("range =", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeNotEqualTo(String value) {
		addCriterion("range <>", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeGreaterThan(String value) {
		addCriterion("range >", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeGreaterThanOrEqualTo(String value) {
		addCriterion("range >=", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeLessThan(String value) {
		addCriterion("range <", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeLessThanOrEqualTo(String value) {
		addCriterion("range <=", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeLike(String value) {
		addCriterion("range like", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeNotLike(String value) {
		addCriterion("range not like", value, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeIn(List<String> values) {
		addCriterion("range in", values, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeNotIn(List<String> values) {
		addCriterion("range not in", values, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeBetween(String value1, String value2) {
		addCriterion("range between", value1, value2, "range");
		return this;
	}

	public AlarmQueryLogCriteria andRangeNotBetween(String value1, String value2) {
		addCriterion("range not between", value1, value2, "range");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeIsNull() {
		addCriterion("returnCode is null");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeIsNotNull() {
		addCriterion("returnCode is not null");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeEqualTo(int value) {
		addCriterion("returnCode =", new Integer(value), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeNotEqualTo(int value) {
		addCriterion("returnCode <>", new Integer(value), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeGreaterThan(int value) {
		addCriterion("returnCode >", new Integer(value), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeGreaterThanOrEqualTo(int value) {
		addCriterion("returnCode >=", new Integer(value), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeLessThan(int value) {
		addCriterion("returnCode <", new Integer(value), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeLessThanOrEqualTo(int value) {
		addCriterion("returnCode <=", new Integer(value), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeIn(List<Integer> values) {
		addCriterion("returnCode in", values, "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeNotIn(List<Integer> values) {
		addCriterion("returnCode not in", values, "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeBetween(int value1, int value2) {
		addCriterion("returnCode between", new Integer(value1), new Integer(value2), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncodeNotBetween(int value1, int value2) {
		addCriterion("returnCode not between", new Integer(value1), new Integer(value2), "returncode");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountIsNull() {
		addCriterion("returnCount is null");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountIsNotNull() {
		addCriterion("returnCount is not null");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountEqualTo(int value) {
		addCriterion("returnCount =", new Integer(value), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountNotEqualTo(int value) {
		addCriterion("returnCount <>", new Integer(value), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountGreaterThan(int value) {
		addCriterion("returnCount >", new Integer(value), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountGreaterThanOrEqualTo(int value) {
		addCriterion("returnCount >=", new Integer(value), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountLessThan(int value) {
		addCriterion("returnCount <", new Integer(value), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountLessThanOrEqualTo(int value) {
		addCriterion("returnCount <=", new Integer(value), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountIn(List<Integer> values) {
		addCriterion("returnCount in", values, "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountNotIn(List<Integer> values) {
		addCriterion("returnCount not in", values, "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountBetween(int value1, int value2) {
		addCriterion("returnCount between", new Integer(value1), new Integer(value2), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andReturncountNotBetween(int value1, int value2) {
		addCriterion("returnCount not between", new Integer(value1), new Integer(value2), "returncount");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingIsNull() {
		addCriterion("timeTaking is null");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingIsNotNull() {
		addCriterion("timeTaking is not null");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingEqualTo(int value) {
		addCriterion("timeTaking =", new Integer(value), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingNotEqualTo(int value) {
		addCriterion("timeTaking <>", new Integer(value), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingGreaterThan(int value) {
		addCriterion("timeTaking >", new Integer(value), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingGreaterThanOrEqualTo(int value) {
		addCriterion("timeTaking >=", new Integer(value), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingLessThan(int value) {
		addCriterion("timeTaking <", new Integer(value), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingLessThanOrEqualTo(int value) {
		addCriterion("timeTaking <=", new Integer(value), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingIn(List<Integer> values) {
		addCriterion("timeTaking in", values, "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingNotIn(List<Integer> values) {
		addCriterion("timeTaking not in", values, "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingBetween(int value1, int value2) {
		addCriterion("timeTaking between", new Integer(value1), new Integer(value2), "timetaking");
		return this;
	}

	public AlarmQueryLogCriteria andTimetakingNotBetween(int value1, int value2) {
		addCriterion("timeTaking not between", new Integer(value1), new Integer(value2), "timetaking");
		return this;
	}
}