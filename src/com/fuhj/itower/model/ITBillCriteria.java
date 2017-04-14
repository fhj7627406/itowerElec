package com.fuhj.itower.model;


import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class ITBillCriteria extends Criteria {

    public ITBillCriteria andItBillIdIsNull() {
        addCriterion("it_bill_id is null");
        return this;
    }

    public ITBillCriteria andItBillIdIsNotNull() {
        addCriterion("it_bill_id is not null");
        return this;
    }

    public ITBillCriteria andItBillIdEqualTo(int value) {
        addCriterion("it_bill_id =", new Integer(value), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdNotEqualTo(int value) {
        addCriterion("it_bill_id <>", new Integer(value), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdGreaterThan(int value) {
        addCriterion("it_bill_id >", new Integer(value), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdGreaterThanOrEqualTo(int value) {
        addCriterion("it_bill_id >=", new Integer(value), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdLessThan(int value) {
        addCriterion("it_bill_id <", new Integer(value), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdLessThanOrEqualTo(int value) {
        addCriterion("it_bill_id <=", new Integer(value), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdIn(List<Integer> values) {
        addCriterion("it_bill_id in", values, "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdNotIn(List<Integer> values) {
        addCriterion("it_bill_id not in", values, "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdBetween(int value1, int value2) {
        addCriterion("it_bill_id between", new Integer(value1), new Integer(value2), "itBillId");
        return this;
    }

    public ITBillCriteria andItBillIdNotBetween(int value1, int value2) {
        addCriterion("it_bill_id not between", new Integer(value1), new Integer(value2), "itBillId");
        return this;
    }

    public ITBillCriteria andBillCodeIsNull() {
        addCriterion("bill_code is null");
        return this;
    }

    public ITBillCriteria andBillCodeIsNotNull() {
        addCriterion("bill_code is not null");
        return this;
    }

    public ITBillCriteria andBillCodeEqualTo(String value) {
        addCriterion("bill_code =", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeNotEqualTo(String value) {
        addCriterion("bill_code <>", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeGreaterThan(String value) {
        addCriterion("bill_code >", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeGreaterThanOrEqualTo(String value) {
        addCriterion("bill_code >=", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeLessThan(String value) {
        addCriterion("bill_code <", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeLessThanOrEqualTo(String value) {
        addCriterion("bill_code <=", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeLike(String value) {
        addCriterion("bill_code like", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeNotLike(String value) {
        addCriterion("bill_code not like", value, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeIn(List<String> values) {
        addCriterion("bill_code in", values, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeNotIn(List<String> values) {
        addCriterion("bill_code not in", values, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeBetween(String value1, String value2) {
        addCriterion("bill_code between", value1, value2, "billCode");
        return this;
    }

    public ITBillCriteria andBillCodeNotBetween(String value1, String value2) {
        addCriterion("bill_code not between", value1, value2, "billCode");
        return this;
    }

    public ITBillCriteria andBillStatusIsNull() {
        addCriterion("bill_status is null");
        return this;
    }

    public ITBillCriteria andBillStatusIsNotNull() {
        addCriterion("bill_status is not null");
        return this;
    }

    public ITBillCriteria andBillStatusEqualTo(String value) {
        addCriterion("bill_status =", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusNotEqualTo(String value) {
        addCriterion("bill_status <>", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusGreaterThan(String value) {
        addCriterion("bill_status >", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusGreaterThanOrEqualTo(String value) {
        addCriterion("bill_status >=", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusLessThan(String value) {
        addCriterion("bill_status <", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusLessThanOrEqualTo(String value) {
        addCriterion("bill_status <=", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusLike(String value) {
        addCriterion("bill_status like", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusNotLike(String value) {
        addCriterion("bill_status not like", value, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusIn(List<String> values) {
        addCriterion("bill_status in", values, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusNotIn(List<String> values) {
        addCriterion("bill_status not in", values, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusBetween(String value1, String value2) {
        addCriterion("bill_status between", value1, value2, "billStatus");
        return this;
    }

    public ITBillCriteria andBillStatusNotBetween(String value1, String value2) {
        addCriterion("bill_status not between", value1, value2, "billStatus");
        return this;
    }

    public ITBillCriteria andAcceptTimeIsNull() {
        addCriterion("accept_time is null");
        return this;
    }

    public ITBillCriteria andAcceptTimeIsNotNull() {
        addCriterion("accept_time is not null");
        return this;
    }

    public ITBillCriteria andAcceptTimeEqualTo(Date value) {
        addCriterion("accept_time =", value, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeNotEqualTo(Date value) {
        addCriterion("accept_time <>", value, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeGreaterThan(Date value) {
        addCriterion("accept_time >", value, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("accept_time >=", value, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeLessThan(Date value) {
        addCriterion("accept_time <", value, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeLessThanOrEqualTo(Date value) {
        addCriterion("accept_time <=", value, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeIn(List<Date> values) {
        addCriterion("accept_time in", values, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeNotIn(List<Date> values) {
        addCriterion("accept_time not in", values, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeBetween(Date value1, Date value2) {
        addCriterion("accept_time between", value1, value2, "acceptTime");
        return this;
    }

    public ITBillCriteria andAcceptTimeNotBetween(Date value1, Date value2) {
        addCriterion("accept_time not between", value1, value2, "acceptTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeIsNull() {
        addCriterion("dispatch_time is null");
        return this;
    }

    public ITBillCriteria andDispatchTimeIsNotNull() {
        addCriterion("dispatch_time is not null");
        return this;
    }

    public ITBillCriteria andDispatchTimeEqualTo(Date value) {
        addCriterion("dispatch_time =", value, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeNotEqualTo(Date value) {
        addCriterion("dispatch_time <>", value, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeGreaterThan(Date value) {
        addCriterion("dispatch_time >", value, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("dispatch_time >=", value, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeLessThan(Date value) {
        addCriterion("dispatch_time <", value, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeLessThanOrEqualTo(Date value) {
        addCriterion("dispatch_time <=", value, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeIn(List<Date> values) {
        addCriterion("dispatch_time in", values, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeNotIn(List<Date> values) {
        addCriterion("dispatch_time not in", values, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeBetween(Date value1, Date value2) {
        addCriterion("dispatch_time between", value1, value2, "dispatchTime");
        return this;
    }

    public ITBillCriteria andDispatchTimeNotBetween(Date value1, Date value2) {
        addCriterion("dispatch_time not between", value1, value2, "dispatchTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeIsNull() {
        addCriterion("receive_time is null");
        return this;
    }

    public ITBillCriteria andReceiveTimeIsNotNull() {
        addCriterion("receive_time is not null");
        return this;
    }

    public ITBillCriteria andReceiveTimeEqualTo(Date value) {
        addCriterion("receive_time =", value, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeNotEqualTo(Date value) {
        addCriterion("receive_time <>", value, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeGreaterThan(Date value) {
        addCriterion("receive_time >", value, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("receive_time >=", value, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeLessThan(Date value) {
        addCriterion("receive_time <", value, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeLessThanOrEqualTo(Date value) {
        addCriterion("receive_time <=", value, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeIn(List<Date> values) {
        addCriterion("receive_time in", values, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeNotIn(List<Date> values) {
        addCriterion("receive_time not in", values, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeBetween(Date value1, Date value2) {
        addCriterion("receive_time between", value1, value2, "receiveTime");
        return this;
    }

    public ITBillCriteria andReceiveTimeNotBetween(Date value1, Date value2) {
        addCriterion("receive_time not between", value1, value2, "receiveTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeIsNull() {
        addCriterion("alarm_time is null");
        return this;
    }

    public ITBillCriteria andAlarmTimeIsNotNull() {
        addCriterion("alarm_time is not null");
        return this;
    }

    public ITBillCriteria andAlarmTimeEqualTo(Date value) {
        addCriterion("alarm_time =", value, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeNotEqualTo(Date value) {
        addCriterion("alarm_time <>", value, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeGreaterThan(Date value) {
        addCriterion("alarm_time >", value, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("alarm_time >=", value, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeLessThan(Date value) {
        addCriterion("alarm_time <", value, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeLessThanOrEqualTo(Date value) {
        addCriterion("alarm_time <=", value, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeIn(List<Date> values) {
        addCriterion("alarm_time in", values, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeNotIn(List<Date> values) {
        addCriterion("alarm_time not in", values, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeBetween(Date value1, Date value2) {
        addCriterion("alarm_time between", value1, value2, "alarmTime");
        return this;
    }

    public ITBillCriteria andAlarmTimeNotBetween(Date value1, Date value2) {
        addCriterion("alarm_time not between", value1, value2, "alarmTime");
        return this;
    }

    public ITBillCriteria andTimeLimitIsNull() {
        addCriterion("time_limit is null");
        return this;
    }

    public ITBillCriteria andTimeLimitIsNotNull() {
        addCriterion("time_limit is not null");
        return this;
    }

    public ITBillCriteria andTimeLimitEqualTo(String value) {
        addCriterion("time_limit =", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitNotEqualTo(String value) {
        addCriterion("time_limit <>", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitGreaterThan(String value) {
        addCriterion("time_limit >", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitGreaterThanOrEqualTo(String value) {
        addCriterion("time_limit >=", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitLessThan(String value) {
        addCriterion("time_limit <", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitLessThanOrEqualTo(String value) {
        addCriterion("time_limit <=", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitLike(String value) {
        addCriterion("time_limit like", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitNotLike(String value) {
        addCriterion("time_limit not like", value, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitIn(List<String> values) {
        addCriterion("time_limit in", values, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitNotIn(List<String> values) {
        addCriterion("time_limit not in", values, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitBetween(String value1, String value2) {
        addCriterion("time_limit between", value1, value2, "timeLimit");
        return this;
    }

    public ITBillCriteria andTimeLimitNotBetween(String value1, String value2) {
        addCriterion("time_limit not between", value1, value2, "timeLimit");
        return this;
    }

    public ITBillCriteria andReceiptTimeIsNull() {
        addCriterion("receipt_time is null");
        return this;
    }

    public ITBillCriteria andReceiptTimeIsNotNull() {
        addCriterion("receipt_time is not null");
        return this;
    }

    public ITBillCriteria andReceiptTimeEqualTo(Date value) {
        addCriterion("receipt_time =", value, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeNotEqualTo(Date value) {
        addCriterion("receipt_time <>", value, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeGreaterThan(Date value) {
        addCriterion("receipt_time >", value, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("receipt_time >=", value, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeLessThan(Date value) {
        addCriterion("receipt_time <", value, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeLessThanOrEqualTo(Date value) {
        addCriterion("receipt_time <=", value, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeIn(List<Date> values) {
        addCriterion("receipt_time in", values, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeNotIn(List<Date> values) {
        addCriterion("receipt_time not in", values, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeBetween(Date value1, Date value2) {
        addCriterion("receipt_time between", value1, value2, "receiptTime");
        return this;
    }

    public ITBillCriteria andReceiptTimeNotBetween(Date value1, Date value2) {
        addCriterion("receipt_time not between", value1, value2, "receiptTime");
        return this;
    }

    public ITBillCriteria andFiledTimeIsNull() {
        addCriterion("filed_time is null");
        return this;
    }

    public ITBillCriteria andFiledTimeIsNotNull() {
        addCriterion("filed_time is not null");
        return this;
    }

    public ITBillCriteria andFiledTimeEqualTo(Date value) {
        addCriterion("filed_time =", value, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeNotEqualTo(Date value) {
        addCriterion("filed_time <>", value, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeGreaterThan(Date value) {
        addCriterion("filed_time >", value, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("filed_time >=", value, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeLessThan(Date value) {
        addCriterion("filed_time <", value, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeLessThanOrEqualTo(Date value) {
        addCriterion("filed_time <=", value, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeIn(List<Date> values) {
        addCriterion("filed_time in", values, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeNotIn(List<Date> values) {
        addCriterion("filed_time not in", values, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeBetween(Date value1, Date value2) {
        addCriterion("filed_time between", value1, value2, "filedTime");
        return this;
    }

    public ITBillCriteria andFiledTimeNotBetween(Date value1, Date value2) {
        addCriterion("filed_time not between", value1, value2, "filedTime");
        return this;
    }

    public ITBillCriteria andFaultSourceIsNull() {
        addCriterion("fault_source is null");
        return this;
    }

    public ITBillCriteria andFaultSourceIsNotNull() {
        addCriterion("fault_source is not null");
        return this;
    }

    public ITBillCriteria andFaultSourceEqualTo(String value) {
        addCriterion("fault_source =", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceNotEqualTo(String value) {
        addCriterion("fault_source <>", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceGreaterThan(String value) {
        addCriterion("fault_source >", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceGreaterThanOrEqualTo(String value) {
        addCriterion("fault_source >=", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceLessThan(String value) {
        addCriterion("fault_source <", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceLessThanOrEqualTo(String value) {
        addCriterion("fault_source <=", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceLike(String value) {
        addCriterion("fault_source like", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceNotLike(String value) {
        addCriterion("fault_source not like", value, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceIn(List<String> values) {
        addCriterion("fault_source in", values, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceNotIn(List<String> values) {
        addCriterion("fault_source not in", values, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceBetween(String value1, String value2) {
        addCriterion("fault_source between", value1, value2, "faultSource");
        return this;
    }

    public ITBillCriteria andFaultSourceNotBetween(String value1, String value2) {
        addCriterion("fault_source not between", value1, value2, "faultSource");
        return this;
    }

    public ITBillCriteria andAlarmNameIsNull() {
        addCriterion("alarm_name is null");
        return this;
    }

    public ITBillCriteria andAlarmNameIsNotNull() {
        addCriterion("alarm_name is not null");
        return this;
    }

    public ITBillCriteria andAlarmNameEqualTo(String value) {
        addCriterion("alarm_name =", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameNotEqualTo(String value) {
        addCriterion("alarm_name <>", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameGreaterThan(String value) {
        addCriterion("alarm_name >", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_name >=", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameLessThan(String value) {
        addCriterion("alarm_name <", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameLessThanOrEqualTo(String value) {
        addCriterion("alarm_name <=", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameLike(String value) {
        addCriterion("alarm_name like", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameNotLike(String value) {
        addCriterion("alarm_name not like", value, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameIn(List<String> values) {
        addCriterion("alarm_name in", values, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameNotIn(List<String> values) {
        addCriterion("alarm_name not in", values, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameBetween(String value1, String value2) {
        addCriterion("alarm_name between", value1, value2, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmNameNotBetween(String value1, String value2) {
        addCriterion("alarm_name not between", value1, value2, "alarmName");
        return this;
    }

    public ITBillCriteria andAlarmStatusIsNull() {
        addCriterion("alarm_status is null");
        return this;
    }

    public ITBillCriteria andAlarmStatusIsNotNull() {
        addCriterion("alarm_status is not null");
        return this;
    }

    public ITBillCriteria andAlarmStatusEqualTo(String value) {
        addCriterion("alarm_status =", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusNotEqualTo(String value) {
        addCriterion("alarm_status <>", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusGreaterThan(String value) {
        addCriterion("alarm_status >", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_status >=", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusLessThan(String value) {
        addCriterion("alarm_status <", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusLessThanOrEqualTo(String value) {
        addCriterion("alarm_status <=", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusLike(String value) {
        addCriterion("alarm_status like", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusNotLike(String value) {
        addCriterion("alarm_status not like", value, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusIn(List<String> values) {
        addCriterion("alarm_status in", values, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusNotIn(List<String> values) {
        addCriterion("alarm_status not in", values, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusBetween(String value1, String value2) {
        addCriterion("alarm_status between", value1, value2, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmStatusNotBetween(String value1, String value2) {
        addCriterion("alarm_status not between", value1, value2, "alarmStatus");
        return this;
    }

    public ITBillCriteria andAlarmDetailIsNull() {
        addCriterion("alarm_detail is null");
        return this;
    }

    public ITBillCriteria andAlarmDetailIsNotNull() {
        addCriterion("alarm_detail is not null");
        return this;
    }

    public ITBillCriteria andAlarmDetailEqualTo(String value) {
        addCriterion("alarm_detail =", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailNotEqualTo(String value) {
        addCriterion("alarm_detail <>", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailGreaterThan(String value) {
        addCriterion("alarm_detail >", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_detail >=", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailLessThan(String value) {
        addCriterion("alarm_detail <", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailLessThanOrEqualTo(String value) {
        addCriterion("alarm_detail <=", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailLike(String value) {
        addCriterion("alarm_detail like", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailNotLike(String value) {
        addCriterion("alarm_detail not like", value, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailIn(List<String> values) {
        addCriterion("alarm_detail in", values, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailNotIn(List<String> values) {
        addCriterion("alarm_detail not in", values, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailBetween(String value1, String value2) {
        addCriterion("alarm_detail between", value1, value2, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmDetailNotBetween(String value1, String value2) {
        addCriterion("alarm_detail not between", value1, value2, "alarmDetail");
        return this;
    }

    public ITBillCriteria andAlarmLevelIsNull() {
        addCriterion("alarm_level is null");
        return this;
    }

    public ITBillCriteria andAlarmLevelIsNotNull() {
        addCriterion("alarm_level is not null");
        return this;
    }

    public ITBillCriteria andAlarmLevelEqualTo(String value) {
        addCriterion("alarm_level =", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelNotEqualTo(String value) {
        addCriterion("alarm_level <>", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelGreaterThan(String value) {
        addCriterion("alarm_level >", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_level >=", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelLessThan(String value) {
        addCriterion("alarm_level <", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelLessThanOrEqualTo(String value) {
        addCriterion("alarm_level <=", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelLike(String value) {
        addCriterion("alarm_level like", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelNotLike(String value) {
        addCriterion("alarm_level not like", value, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelIn(List<String> values) {
        addCriterion("alarm_level in", values, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelNotIn(List<String> values) {
        addCriterion("alarm_level not in", values, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelBetween(String value1, String value2) {
        addCriterion("alarm_level between", value1, value2, "alarmLevel");
        return this;
    }

    public ITBillCriteria andAlarmLevelNotBetween(String value1, String value2) {
        addCriterion("alarm_level not between", value1, value2, "alarmLevel");
        return this;
    }

    public ITBillCriteria andStationCodeIsNull() {
        addCriterion("station_code is null");
        return this;
    }

    public ITBillCriteria andStationCodeIsNotNull() {
        addCriterion("station_code is not null");
        return this;
    }

    public ITBillCriteria andStationCodeEqualTo(String value) {
        addCriterion("station_code =", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeNotEqualTo(String value) {
        addCriterion("station_code <>", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeGreaterThan(String value) {
        addCriterion("station_code >", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeGreaterThanOrEqualTo(String value) {
        addCriterion("station_code >=", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeLessThan(String value) {
        addCriterion("station_code <", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeLessThanOrEqualTo(String value) {
        addCriterion("station_code <=", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeLike(String value) {
        addCriterion("station_code like", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeNotLike(String value) {
        addCriterion("station_code not like", value, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeIn(List<String> values) {
        addCriterion("station_code in", values, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeNotIn(List<String> values) {
        addCriterion("station_code not in", values, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeBetween(String value1, String value2) {
        addCriterion("station_code between", value1, value2, "stationCode");
        return this;
    }

    public ITBillCriteria andStationCodeNotBetween(String value1, String value2) {
        addCriterion("station_code not between", value1, value2, "stationCode");
        return this;
    }

    public ITBillCriteria andStationNameIsNull() {
        addCriterion("station_name is null");
        return this;
    }

    public ITBillCriteria andStationNameIsNotNull() {
        addCriterion("station_name is not null");
        return this;
    }

    public ITBillCriteria andStationNameEqualTo(String value) {
        addCriterion("station_name =", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameNotEqualTo(String value) {
        addCriterion("station_name <>", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameGreaterThan(String value) {
        addCriterion("station_name >", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameGreaterThanOrEqualTo(String value) {
        addCriterion("station_name >=", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameLessThan(String value) {
        addCriterion("station_name <", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameLessThanOrEqualTo(String value) {
        addCriterion("station_name <=", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameLike(String value) {
        addCriterion("station_name like", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameNotLike(String value) {
        addCriterion("station_name not like", value, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameIn(List<String> values) {
        addCriterion("station_name in", values, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameNotIn(List<String> values) {
        addCriterion("station_name not in", values, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameBetween(String value1, String value2) {
        addCriterion("station_name between", value1, value2, "stationName");
        return this;
    }

    public ITBillCriteria andStationNameNotBetween(String value1, String value2) {
        addCriterion("station_name not between", value1, value2, "stationName");
        return this;
    }

    public ITBillCriteria andProvinceIsNull() {
        addCriterion("province is null");
        return this;
    }

    public ITBillCriteria andProvinceIsNotNull() {
        addCriterion("province is not null");
        return this;
    }

    public ITBillCriteria andProvinceEqualTo(String value) {
        addCriterion("province =", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceNotEqualTo(String value) {
        addCriterion("province <>", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceGreaterThan(String value) {
        addCriterion("province >", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceGreaterThanOrEqualTo(String value) {
        addCriterion("province >=", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceLessThan(String value) {
        addCriterion("province <", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceLessThanOrEqualTo(String value) {
        addCriterion("province <=", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceLike(String value) {
        addCriterion("province like", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceNotLike(String value) {
        addCriterion("province not like", value, "province");
        return this;
    }

    public ITBillCriteria andProvinceIn(List<String> values) {
        addCriterion("province in", values, "province");
        return this;
    }

    public ITBillCriteria andProvinceNotIn(List<String> values) {
        addCriterion("province not in", values, "province");
        return this;
    }

    public ITBillCriteria andProvinceBetween(String value1, String value2) {
        addCriterion("province between", value1, value2, "province");
        return this;
    }

    public ITBillCriteria andProvinceNotBetween(String value1, String value2) {
        addCriterion("province not between", value1, value2, "province");
        return this;
    }

    public ITBillCriteria andCityIsNull() {
        addCriterion("city is null");
        return this;
    }

    public ITBillCriteria andCityIsNotNull() {
        addCriterion("city is not null");
        return this;
    }

    public ITBillCriteria andCityEqualTo(String value) {
        addCriterion("city =", value, "city");
        return this;
    }

    public ITBillCriteria andCityNotEqualTo(String value) {
        addCriterion("city <>", value, "city");
        return this;
    }

    public ITBillCriteria andCityGreaterThan(String value) {
        addCriterion("city >", value, "city");
        return this;
    }

    public ITBillCriteria andCityGreaterThanOrEqualTo(String value) {
        addCriterion("city >=", value, "city");
        return this;
    }

    public ITBillCriteria andCityLessThan(String value) {
        addCriterion("city <", value, "city");
        return this;
    }

    public ITBillCriteria andCityLessThanOrEqualTo(String value) {
        addCriterion("city <=", value, "city");
        return this;
    }

    public ITBillCriteria andCityLike(String value) {
        addCriterion("city like", value, "city");
        return this;
    }

    public ITBillCriteria andCityNotLike(String value) {
        addCriterion("city not like", value, "city");
        return this;
    }

    public ITBillCriteria andCityIn(List<String> values) {
        addCriterion("city in", values, "city");
        return this;
    }

    public ITBillCriteria andCityNotIn(List<String> values) {
        addCriterion("city not in", values, "city");
        return this;
    }

    public ITBillCriteria andCityBetween(String value1, String value2) {
        addCriterion("city between", value1, value2, "city");
        return this;
    }

    public ITBillCriteria andCityNotBetween(String value1, String value2) {
        addCriterion("city not between", value1, value2, "city");
        return this;
    }

    public ITBillCriteria andDistrictIsNull() {
        addCriterion("district is null");
        return this;
    }

    public ITBillCriteria andDistrictIsNotNull() {
        addCriterion("district is not null");
        return this;
    }

    public ITBillCriteria andDistrictEqualTo(String value) {
        addCriterion("district =", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictNotEqualTo(String value) {
        addCriterion("district <>", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictGreaterThan(String value) {
        addCriterion("district >", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictGreaterThanOrEqualTo(String value) {
        addCriterion("district >=", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictLessThan(String value) {
        addCriterion("district <", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictLessThanOrEqualTo(String value) {
        addCriterion("district <=", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictLike(String value) {
        addCriterion("district like", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictNotLike(String value) {
        addCriterion("district not like", value, "district");
        return this;
    }

    public ITBillCriteria andDistrictIn(List<String> values) {
        addCriterion("district in", values, "district");
        return this;
    }

    public ITBillCriteria andDistrictNotIn(List<String> values) {
        addCriterion("district not in", values, "district");
        return this;
    }

    public ITBillCriteria andDistrictBetween(String value1, String value2) {
        addCriterion("district between", value1, value2, "district");
        return this;
    }

    public ITBillCriteria andDistrictNotBetween(String value1, String value2) {
        addCriterion("district not between", value1, value2, "district");
        return this;
    }

    public ITBillCriteria andItProvinceIdIsNull() {
        addCriterion("it_province_id is null");
        return this;
    }

    public ITBillCriteria andItProvinceIdIsNotNull() {
        addCriterion("it_province_id is not null");
        return this;
    }

    public ITBillCriteria andItProvinceIdEqualTo(String value) {
        addCriterion("it_province_id =", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdNotEqualTo(String value) {
        addCriterion("it_province_id <>", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdGreaterThan(String value) {
        addCriterion("it_province_id >", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_province_id >=", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdLessThan(String value) {
        addCriterion("it_province_id <", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdLessThanOrEqualTo(String value) {
        addCriterion("it_province_id <=", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdLike(String value) {
        addCriterion("it_province_id like", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdNotLike(String value) {
        addCriterion("it_province_id not like", value, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdIn(List<String> values) {
        addCriterion("it_province_id in", values, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdNotIn(List<String> values) {
        addCriterion("it_province_id not in", values, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdBetween(String value1, String value2) {
        addCriterion("it_province_id between", value1, value2, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItProvinceIdNotBetween(String value1, String value2) {
        addCriterion("it_province_id not between", value1, value2, "itProvinceId");
        return this;
    }

    public ITBillCriteria andItCityIdIsNull() {
        addCriterion("it_city_id is null");
        return this;
    }

    public ITBillCriteria andItCityIdIsNotNull() {
        addCriterion("it_city_id is not null");
        return this;
    }

    public ITBillCriteria andItCityIdEqualTo(String value) {
        addCriterion("it_city_id =", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdNotEqualTo(String value) {
        addCriterion("it_city_id <>", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdGreaterThan(String value) {
        addCriterion("it_city_id >", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_city_id >=", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdLessThan(String value) {
        addCriterion("it_city_id <", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdLessThanOrEqualTo(String value) {
        addCriterion("it_city_id <=", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdLike(String value) {
        addCriterion("it_city_id like", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdNotLike(String value) {
        addCriterion("it_city_id not like", value, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdIn(List<String> values) {
        addCriterion("it_city_id in", values, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdNotIn(List<String> values) {
        addCriterion("it_city_id not in", values, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdBetween(String value1, String value2) {
        addCriterion("it_city_id between", value1, value2, "itCityId");
        return this;
    }

    public ITBillCriteria andItCityIdNotBetween(String value1, String value2) {
        addCriterion("it_city_id not between", value1, value2, "itCityId");
        return this;
    }

    public ITBillCriteria andItDistrictIdIsNull() {
        addCriterion("it_district_id is null");
        return this;
    }

    public ITBillCriteria andItDistrictIdIsNotNull() {
        addCriterion("it_district_id is not null");
        return this;
    }

    public ITBillCriteria andItDistrictIdEqualTo(String value) {
        addCriterion("it_district_id =", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdNotEqualTo(String value) {
        addCriterion("it_district_id <>", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdGreaterThan(String value) {
        addCriterion("it_district_id >", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
        addCriterion("it_district_id >=", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdLessThan(String value) {
        addCriterion("it_district_id <", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdLessThanOrEqualTo(String value) {
        addCriterion("it_district_id <=", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdLike(String value) {
        addCriterion("it_district_id like", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdNotLike(String value) {
        addCriterion("it_district_id not like", value, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdIn(List<String> values) {
        addCriterion("it_district_id in", values, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdNotIn(List<String> values) {
        addCriterion("it_district_id not in", values, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdBetween(String value1, String value2) {
        addCriterion("it_district_id between", value1, value2, "itDistrictId");
        return this;
    }

    public ITBillCriteria andItDistrictIdNotBetween(String value1, String value2) {
        addCriterion("it_district_id not between", value1, value2, "itDistrictId");
        return this;
    }

    public ITBillCriteria andGoStationIsNull() {
        addCriterion("go_station is null");
        return this;
    }

    public ITBillCriteria andGoStationIsNotNull() {
        addCriterion("go_station is not null");
        return this;
    }

    public ITBillCriteria andGoStationEqualTo(String value) {
        addCriterion("go_station =", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationNotEqualTo(String value) {
        addCriterion("go_station <>", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationGreaterThan(String value) {
        addCriterion("go_station >", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationGreaterThanOrEqualTo(String value) {
        addCriterion("go_station >=", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationLessThan(String value) {
        addCriterion("go_station <", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationLessThanOrEqualTo(String value) {
        addCriterion("go_station <=", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationLike(String value) {
        addCriterion("go_station like", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationNotLike(String value) {
        addCriterion("go_station not like", value, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationIn(List<String> values) {
        addCriterion("go_station in", values, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationNotIn(List<String> values) {
        addCriterion("go_station not in", values, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationBetween(String value1, String value2) {
        addCriterion("go_station between", value1, value2, "goStation");
        return this;
    }

    public ITBillCriteria andGoStationNotBetween(String value1, String value2) {
        addCriterion("go_station not between", value1, value2, "goStation");
        return this;
    }

    public ITBillCriteria andFaultReasonIsNull() {
        addCriterion("fault_reason is null");
        return this;
    }

    public ITBillCriteria andFaultReasonIsNotNull() {
        addCriterion("fault_reason is not null");
        return this;
    }

    public ITBillCriteria andFaultReasonEqualTo(String value) {
        addCriterion("fault_reason =", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonNotEqualTo(String value) {
        addCriterion("fault_reason <>", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonGreaterThan(String value) {
        addCriterion("fault_reason >", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonGreaterThanOrEqualTo(String value) {
        addCriterion("fault_reason >=", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonLessThan(String value) {
        addCriterion("fault_reason <", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonLessThanOrEqualTo(String value) {
        addCriterion("fault_reason <=", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonLike(String value) {
        addCriterion("fault_reason like", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonNotLike(String value) {
        addCriterion("fault_reason not like", value, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonIn(List<String> values) {
        addCriterion("fault_reason in", values, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonNotIn(List<String> values) {
        addCriterion("fault_reason not in", values, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonBetween(String value1, String value2) {
        addCriterion("fault_reason between", value1, value2, "faultReason");
        return this;
    }

    public ITBillCriteria andFaultReasonNotBetween(String value1, String value2) {
        addCriterion("fault_reason not between", value1, value2, "faultReason");
        return this;
    }

    public ITBillCriteria andImmunityIsNull() {
        addCriterion("immunity is null");
        return this;
    }

    public ITBillCriteria andImmunityIsNotNull() {
        addCriterion("immunity is not null");
        return this;
    }

    public ITBillCriteria andImmunityEqualTo(String value) {
        addCriterion("immunity =", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityNotEqualTo(String value) {
        addCriterion("immunity <>", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityGreaterThan(String value) {
        addCriterion("immunity >", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityGreaterThanOrEqualTo(String value) {
        addCriterion("immunity >=", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityLessThan(String value) {
        addCriterion("immunity <", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityLessThanOrEqualTo(String value) {
        addCriterion("immunity <=", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityLike(String value) {
        addCriterion("immunity like", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityNotLike(String value) {
        addCriterion("immunity not like", value, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityIn(List<String> values) {
        addCriterion("immunity in", values, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityNotIn(List<String> values) {
        addCriterion("immunity not in", values, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityBetween(String value1, String value2) {
        addCriterion("immunity between", value1, value2, "immunity");
        return this;
    }

    public ITBillCriteria andImmunityNotBetween(String value1, String value2) {
        addCriterion("immunity not between", value1, value2, "immunity");
        return this;
    }

    public ITBillCriteria andDisclaimerIsNull() {
        addCriterion("disclaimer is null");
        return this;
    }

    public ITBillCriteria andDisclaimerIsNotNull() {
        addCriterion("disclaimer is not null");
        return this;
    }

    public ITBillCriteria andDisclaimerEqualTo(String value) {
        addCriterion("disclaimer =", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerNotEqualTo(String value) {
        addCriterion("disclaimer <>", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerGreaterThan(String value) {
        addCriterion("disclaimer >", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerGreaterThanOrEqualTo(String value) {
        addCriterion("disclaimer >=", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerLessThan(String value) {
        addCriterion("disclaimer <", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerLessThanOrEqualTo(String value) {
        addCriterion("disclaimer <=", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerLike(String value) {
        addCriterion("disclaimer like", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerNotLike(String value) {
        addCriterion("disclaimer not like", value, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerIn(List<String> values) {
        addCriterion("disclaimer in", values, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerNotIn(List<String> values) {
        addCriterion("disclaimer not in", values, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerBetween(String value1, String value2) {
        addCriterion("disclaimer between", value1, value2, "disclaimer");
        return this;
    }

    public ITBillCriteria andDisclaimerNotBetween(String value1, String value2) {
        addCriterion("disclaimer not between", value1, value2, "disclaimer");
        return this;
    }

    public ITBillCriteria andImmunityReasonIsNull() {
        addCriterion("immunity_reason is null");
        return this;
    }

    public ITBillCriteria andImmunityReasonIsNotNull() {
        addCriterion("immunity_reason is not null");
        return this;
    }

    public ITBillCriteria andImmunityReasonEqualTo(String value) {
        addCriterion("immunity_reason =", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonNotEqualTo(String value) {
        addCriterion("immunity_reason <>", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonGreaterThan(String value) {
        addCriterion("immunity_reason >", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonGreaterThanOrEqualTo(String value) {
        addCriterion("immunity_reason >=", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonLessThan(String value) {
        addCriterion("immunity_reason <", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonLessThanOrEqualTo(String value) {
        addCriterion("immunity_reason <=", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonLike(String value) {
        addCriterion("immunity_reason like", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonNotLike(String value) {
        addCriterion("immunity_reason not like", value, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonIn(List<String> values) {
        addCriterion("immunity_reason in", values, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonNotIn(List<String> values) {
        addCriterion("immunity_reason not in", values, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonBetween(String value1, String value2) {
        addCriterion("immunity_reason between", value1, value2, "immunityReason");
        return this;
    }

    public ITBillCriteria andImmunityReasonNotBetween(String value1, String value2) {
        addCriterion("immunity_reason not between", value1, value2, "immunityReason");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeIsNull() {
        addCriterion("alarm_clear_time is null");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeIsNotNull() {
        addCriterion("alarm_clear_time is not null");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeEqualTo(Date value) {
        addCriterion("alarm_clear_time =", value, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeNotEqualTo(Date value) {
        addCriterion("alarm_clear_time <>", value, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeGreaterThan(Date value) {
        addCriterion("alarm_clear_time >", value, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("alarm_clear_time >=", value, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeLessThan(Date value) {
        addCriterion("alarm_clear_time <", value, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeLessThanOrEqualTo(Date value) {
        addCriterion("alarm_clear_time <=", value, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeIn(List<Date> values) {
        addCriterion("alarm_clear_time in", values, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeNotIn(List<Date> values) {
        addCriterion("alarm_clear_time not in", values, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeBetween(Date value1, Date value2) {
        addCriterion("alarm_clear_time between", value1, value2, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmClearTimeNotBetween(Date value1, Date value2) {
        addCriterion("alarm_clear_time not between", value1, value2, "alarmClearTime");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentIsNull() {
        addCriterion("alarm_reply_content is null");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentIsNotNull() {
        addCriterion("alarm_reply_content is not null");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentEqualTo(String value) {
        addCriterion("alarm_reply_content =", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentNotEqualTo(String value) {
        addCriterion("alarm_reply_content <>", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentGreaterThan(String value) {
        addCriterion("alarm_reply_content >", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_reply_content >=", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentLessThan(String value) {
        addCriterion("alarm_reply_content <", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentLessThanOrEqualTo(String value) {
        addCriterion("alarm_reply_content <=", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentLike(String value) {
        addCriterion("alarm_reply_content like", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentNotLike(String value) {
        addCriterion("alarm_reply_content not like", value, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentIn(List<String> values) {
        addCriterion("alarm_reply_content in", values, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentNotIn(List<String> values) {
        addCriterion("alarm_reply_content not in", values, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentBetween(String value1, String value2) {
        addCriterion("alarm_reply_content between", value1, value2, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andAlarmReplyContentNotBetween(String value1, String value2) {
        addCriterion("alarm_reply_content not between", value1, value2, "alarmReplyContent");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeIsNull() {
        addCriterion("fault_device_type is null");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeIsNotNull() {
        addCriterion("fault_device_type is not null");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeEqualTo(String value) {
        addCriterion("fault_device_type =", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeNotEqualTo(String value) {
        addCriterion("fault_device_type <>", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeGreaterThan(String value) {
        addCriterion("fault_device_type >", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeGreaterThanOrEqualTo(String value) {
        addCriterion("fault_device_type >=", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeLessThan(String value) {
        addCriterion("fault_device_type <", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeLessThanOrEqualTo(String value) {
        addCriterion("fault_device_type <=", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeLike(String value) {
        addCriterion("fault_device_type like", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeNotLike(String value) {
        addCriterion("fault_device_type not like", value, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeIn(List<String> values) {
        addCriterion("fault_device_type in", values, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeNotIn(List<String> values) {
        addCriterion("fault_device_type not in", values, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeBetween(String value1, String value2) {
        addCriterion("fault_device_type between", value1, value2, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andFaultDeviceTypeNotBetween(String value1, String value2) {
        addCriterion("fault_device_type not between", value1, value2, "faultDeviceType");
        return this;
    }

    public ITBillCriteria andHasPressedIsNull() {
        addCriterion("has_pressed is null");
        return this;
    }

    public ITBillCriteria andHasPressedIsNotNull() {
        addCriterion("has_pressed is not null");
        return this;
    }

    public ITBillCriteria andHasPressedEqualTo(String value) {
        addCriterion("has_pressed =", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedNotEqualTo(String value) {
        addCriterion("has_pressed <>", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedGreaterThan(String value) {
        addCriterion("has_pressed >", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedGreaterThanOrEqualTo(String value) {
        addCriterion("has_pressed >=", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedLessThan(String value) {
        addCriterion("has_pressed <", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedLessThanOrEqualTo(String value) {
        addCriterion("has_pressed <=", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedLike(String value) {
        addCriterion("has_pressed like", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedNotLike(String value) {
        addCriterion("has_pressed not like", value, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedIn(List<String> values) {
        addCriterion("has_pressed in", values, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedNotIn(List<String> values) {
        addCriterion("has_pressed not in", values, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedBetween(String value1, String value2) {
        addCriterion("has_pressed between", value1, value2, "hasPressed");
        return this;
    }

    public ITBillCriteria andHasPressedNotBetween(String value1, String value2) {
        addCriterion("has_pressed not between", value1, value2, "hasPressed");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutIsNull() {
        addCriterion("is_receipt_timeout is null");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutIsNotNull() {
        addCriterion("is_receipt_timeout is not null");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutEqualTo(String value) {
        addCriterion("is_receipt_timeout =", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutNotEqualTo(String value) {
        addCriterion("is_receipt_timeout <>", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutGreaterThan(String value) {
        addCriterion("is_receipt_timeout >", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutGreaterThanOrEqualTo(String value) {
        addCriterion("is_receipt_timeout >=", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutLessThan(String value) {
        addCriterion("is_receipt_timeout <", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutLessThanOrEqualTo(String value) {
        addCriterion("is_receipt_timeout <=", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutLike(String value) {
        addCriterion("is_receipt_timeout like", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutNotLike(String value) {
        addCriterion("is_receipt_timeout not like", value, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutIn(List<String> values) {
        addCriterion("is_receipt_timeout in", values, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutNotIn(List<String> values) {
        addCriterion("is_receipt_timeout not in", values, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutBetween(String value1, String value2) {
        addCriterion("is_receipt_timeout between", value1, value2, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiptTimeoutNotBetween(String value1, String value2) {
        addCriterion("is_receipt_timeout not between", value1, value2, "isReceiptTimeout");
        return this;
    }

    public ITBillCriteria andReceiptPersonIsNull() {
        addCriterion("receipt_person is null");
        return this;
    }

    public ITBillCriteria andReceiptPersonIsNotNull() {
        addCriterion("receipt_person is not null");
        return this;
    }

    public ITBillCriteria andReceiptPersonEqualTo(String value) {
        addCriterion("receipt_person =", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonNotEqualTo(String value) {
        addCriterion("receipt_person <>", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonGreaterThan(String value) {
        addCriterion("receipt_person >", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonGreaterThanOrEqualTo(String value) {
        addCriterion("receipt_person >=", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonLessThan(String value) {
        addCriterion("receipt_person <", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonLessThanOrEqualTo(String value) {
        addCriterion("receipt_person <=", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonLike(String value) {
        addCriterion("receipt_person like", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonNotLike(String value) {
        addCriterion("receipt_person not like", value, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonIn(List<String> values) {
        addCriterion("receipt_person in", values, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonNotIn(List<String> values) {
        addCriterion("receipt_person not in", values, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonBetween(String value1, String value2) {
        addCriterion("receipt_person between", value1, value2, "receiptPerson");
        return this;
    }

    public ITBillCriteria andReceiptPersonNotBetween(String value1, String value2) {
        addCriterion("receipt_person not between", value1, value2, "receiptPerson");
        return this;
    }

    public ITBillCriteria andAgentsCorpIsNull() {
        addCriterion("agents_corp is null");
        return this;
    }

    public ITBillCriteria andAgentsCorpIsNotNull() {
        addCriterion("agents_corp is not null");
        return this;
    }

    public ITBillCriteria andAgentsCorpEqualTo(String value) {
        addCriterion("agents_corp =", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpNotEqualTo(String value) {
        addCriterion("agents_corp <>", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpGreaterThan(String value) {
        addCriterion("agents_corp >", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpGreaterThanOrEqualTo(String value) {
        addCriterion("agents_corp >=", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpLessThan(String value) {
        addCriterion("agents_corp <", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpLessThanOrEqualTo(String value) {
        addCriterion("agents_corp <=", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpLike(String value) {
        addCriterion("agents_corp like", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpNotLike(String value) {
        addCriterion("agents_corp not like", value, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpIn(List<String> values) {
        addCriterion("agents_corp in", values, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpNotIn(List<String> values) {
        addCriterion("agents_corp not in", values, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpBetween(String value1, String value2) {
        addCriterion("agents_corp between", value1, value2, "agentsCorp");
        return this;
    }

    public ITBillCriteria andAgentsCorpNotBetween(String value1, String value2) {
        addCriterion("agents_corp not between", value1, value2, "agentsCorp");
        return this;
    }

    public ITBillCriteria andBillProcessIsNull() {
        addCriterion("bill_process is null");
        return this;
    }

    public ITBillCriteria andBillProcessIsNotNull() {
        addCriterion("bill_process is not null");
        return this;
    }

    public ITBillCriteria andBillProcessEqualTo(String value) {
        addCriterion("bill_process =", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessNotEqualTo(String value) {
        addCriterion("bill_process <>", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessGreaterThan(String value) {
        addCriterion("bill_process >", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessGreaterThanOrEqualTo(String value) {
        addCriterion("bill_process >=", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessLessThan(String value) {
        addCriterion("bill_process <", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessLessThanOrEqualTo(String value) {
        addCriterion("bill_process <=", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessLike(String value) {
        addCriterion("bill_process like", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessNotLike(String value) {
        addCriterion("bill_process not like", value, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessIn(List<String> values) {
        addCriterion("bill_process in", values, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessNotIn(List<String> values) {
        addCriterion("bill_process not in", values, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessBetween(String value1, String value2) {
        addCriterion("bill_process between", value1, value2, "billProcess");
        return this;
    }

    public ITBillCriteria andBillProcessNotBetween(String value1, String value2) {
        addCriterion("bill_process not between", value1, value2, "billProcess");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeIsNull() {
        addCriterion("machine_room_type is null");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeIsNotNull() {
        addCriterion("machine_room_type is not null");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeEqualTo(String value) {
        addCriterion("machine_room_type =", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeNotEqualTo(String value) {
        addCriterion("machine_room_type <>", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeGreaterThan(String value) {
        addCriterion("machine_room_type >", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeGreaterThanOrEqualTo(String value) {
        addCriterion("machine_room_type >=", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeLessThan(String value) {
        addCriterion("machine_room_type <", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeLessThanOrEqualTo(String value) {
        addCriterion("machine_room_type <=", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeLike(String value) {
        addCriterion("machine_room_type like", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeNotLike(String value) {
        addCriterion("machine_room_type not like", value, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeIn(List<String> values) {
        addCriterion("machine_room_type in", values, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeNotIn(List<String> values) {
        addCriterion("machine_room_type not in", values, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeBetween(String value1, String value2) {
        addCriterion("machine_room_type between", value1, value2, "machineRoomType");
        return this;
    }

    public ITBillCriteria andMachineRoomTypeNotBetween(String value1, String value2) {
        addCriterion("machine_room_type not between", value1, value2, "machineRoomType");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeIsNull() {
        addCriterion("power_supply_mode is null");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeIsNotNull() {
        addCriterion("power_supply_mode is not null");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeEqualTo(String value) {
        addCriterion("power_supply_mode =", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeNotEqualTo(String value) {
        addCriterion("power_supply_mode <>", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeGreaterThan(String value) {
        addCriterion("power_supply_mode >", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeGreaterThanOrEqualTo(String value) {
        addCriterion("power_supply_mode >=", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeLessThan(String value) {
        addCriterion("power_supply_mode <", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeLessThanOrEqualTo(String value) {
        addCriterion("power_supply_mode <=", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeLike(String value) {
        addCriterion("power_supply_mode like", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeNotLike(String value) {
        addCriterion("power_supply_mode not like", value, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeIn(List<String> values) {
        addCriterion("power_supply_mode in", values, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeNotIn(List<String> values) {
        addCriterion("power_supply_mode not in", values, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeBetween(String value1, String value2) {
        addCriterion("power_supply_mode between", value1, value2, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andPowerSupplyModeNotBetween(String value1, String value2) {
        addCriterion("power_supply_mode not between", value1, value2, "powerSupplyMode");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeIsNull() {
        addCriterion("fsu_network_card_type is null");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeIsNotNull() {
        addCriterion("fsu_network_card_type is not null");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeEqualTo(String value) {
        addCriterion("fsu_network_card_type =", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeNotEqualTo(String value) {
        addCriterion("fsu_network_card_type <>", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeGreaterThan(String value) {
        addCriterion("fsu_network_card_type >", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeGreaterThanOrEqualTo(String value) {
        addCriterion("fsu_network_card_type >=", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeLessThan(String value) {
        addCriterion("fsu_network_card_type <", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeLessThanOrEqualTo(String value) {
        addCriterion("fsu_network_card_type <=", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeLike(String value) {
        addCriterion("fsu_network_card_type like", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeNotLike(String value) {
        addCriterion("fsu_network_card_type not like", value, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeIn(List<String> values) {
        addCriterion("fsu_network_card_type in", values, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeNotIn(List<String> values) {
        addCriterion("fsu_network_card_type not in", values, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeBetween(String value1, String value2) {
        addCriterion("fsu_network_card_type between", value1, value2, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuNetworkCardTypeNotBetween(String value1, String value2) {
        addCriterion("fsu_network_card_type not between", value1, value2, "fsuNetworkCardType");
        return this;
    }

    public ITBillCriteria andFsuManufactorIsNull() {
        addCriterion("fsu_manufactor is null");
        return this;
    }

    public ITBillCriteria andFsuManufactorIsNotNull() {
        addCriterion("fsu_manufactor is not null");
        return this;
    }

    public ITBillCriteria andFsuManufactorEqualTo(String value) {
        addCriterion("fsu_manufactor =", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorNotEqualTo(String value) {
        addCriterion("fsu_manufactor <>", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorGreaterThan(String value) {
        addCriterion("fsu_manufactor >", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorGreaterThanOrEqualTo(String value) {
        addCriterion("fsu_manufactor >=", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorLessThan(String value) {
        addCriterion("fsu_manufactor <", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorLessThanOrEqualTo(String value) {
        addCriterion("fsu_manufactor <=", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorLike(String value) {
        addCriterion("fsu_manufactor like", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorNotLike(String value) {
        addCriterion("fsu_manufactor not like", value, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorIn(List<String> values) {
        addCriterion("fsu_manufactor in", values, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorNotIn(List<String> values) {
        addCriterion("fsu_manufactor not in", values, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorBetween(String value1, String value2) {
        addCriterion("fsu_manufactor between", value1, value2, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andFsuManufactorNotBetween(String value1, String value2) {
        addCriterion("fsu_manufactor not between", value1, value2, "fsuManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorIsNull() {
        addCriterion("ac_manufactor is null");
        return this;
    }

    public ITBillCriteria andAcManufactorIsNotNull() {
        addCriterion("ac_manufactor is not null");
        return this;
    }

    public ITBillCriteria andAcManufactorEqualTo(String value) {
        addCriterion("ac_manufactor =", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorNotEqualTo(String value) {
        addCriterion("ac_manufactor <>", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorGreaterThan(String value) {
        addCriterion("ac_manufactor >", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorGreaterThanOrEqualTo(String value) {
        addCriterion("ac_manufactor >=", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorLessThan(String value) {
        addCriterion("ac_manufactor <", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorLessThanOrEqualTo(String value) {
        addCriterion("ac_manufactor <=", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorLike(String value) {
        addCriterion("ac_manufactor like", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorNotLike(String value) {
        addCriterion("ac_manufactor not like", value, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorIn(List<String> values) {
        addCriterion("ac_manufactor in", values, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorNotIn(List<String> values) {
        addCriterion("ac_manufactor not in", values, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorBetween(String value1, String value2) {
        addCriterion("ac_manufactor between", value1, value2, "acManufactor");
        return this;
    }

    public ITBillCriteria andAcManufactorNotBetween(String value1, String value2) {
        addCriterion("ac_manufactor not between", value1, value2, "acManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorIsNull() {
        addCriterion("battery_manufactor is null");
        return this;
    }

    public ITBillCriteria andBatteryManufactorIsNotNull() {
        addCriterion("battery_manufactor is not null");
        return this;
    }

    public ITBillCriteria andBatteryManufactorEqualTo(String value) {
        addCriterion("battery_manufactor =", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorNotEqualTo(String value) {
        addCriterion("battery_manufactor <>", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorGreaterThan(String value) {
        addCriterion("battery_manufactor >", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorGreaterThanOrEqualTo(String value) {
        addCriterion("battery_manufactor >=", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorLessThan(String value) {
        addCriterion("battery_manufactor <", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorLessThanOrEqualTo(String value) {
        addCriterion("battery_manufactor <=", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorLike(String value) {
        addCriterion("battery_manufactor like", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorNotLike(String value) {
        addCriterion("battery_manufactor not like", value, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorIn(List<String> values) {
        addCriterion("battery_manufactor in", values, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorNotIn(List<String> values) {
        addCriterion("battery_manufactor not in", values, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorBetween(String value1, String value2) {
        addCriterion("battery_manufactor between", value1, value2, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andBatteryManufactorNotBetween(String value1, String value2) {
        addCriterion("battery_manufactor not between", value1, value2, "batteryManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorIsNull() {
        addCriterion("switch_manufactor is null");
        return this;
    }

    public ITBillCriteria andSwitchManufactorIsNotNull() {
        addCriterion("switch_manufactor is not null");
        return this;
    }

    public ITBillCriteria andSwitchManufactorEqualTo(String value) {
        addCriterion("switch_manufactor =", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorNotEqualTo(String value) {
        addCriterion("switch_manufactor <>", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorGreaterThan(String value) {
        addCriterion("switch_manufactor >", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorGreaterThanOrEqualTo(String value) {
        addCriterion("switch_manufactor >=", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorLessThan(String value) {
        addCriterion("switch_manufactor <", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorLessThanOrEqualTo(String value) {
        addCriterion("switch_manufactor <=", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorLike(String value) {
        addCriterion("switch_manufactor like", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorNotLike(String value) {
        addCriterion("switch_manufactor not like", value, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorIn(List<String> values) {
        addCriterion("switch_manufactor in", values, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorNotIn(List<String> values) {
        addCriterion("switch_manufactor not in", values, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorBetween(String value1, String value2) {
        addCriterion("switch_manufactor between", value1, value2, "switchManufactor");
        return this;
    }

    public ITBillCriteria andSwitchManufactorNotBetween(String value1, String value2) {
        addCriterion("switch_manufactor not between", value1, value2, "switchManufactor");
        return this;
    }

    public ITBillCriteria andElecConditionsIsNull() {
        addCriterion("elec_conditions is null");
        return this;
    }

    public ITBillCriteria andElecConditionsIsNotNull() {
        addCriterion("elec_conditions is not null");
        return this;
    }

    public ITBillCriteria andElecConditionsEqualTo(String value) {
        addCriterion("elec_conditions =", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsNotEqualTo(String value) {
        addCriterion("elec_conditions <>", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsGreaterThan(String value) {
        addCriterion("elec_conditions >", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsGreaterThanOrEqualTo(String value) {
        addCriterion("elec_conditions >=", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsLessThan(String value) {
        addCriterion("elec_conditions <", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsLessThanOrEqualTo(String value) {
        addCriterion("elec_conditions <=", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsLike(String value) {
        addCriterion("elec_conditions like", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsNotLike(String value) {
        addCriterion("elec_conditions not like", value, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsIn(List<String> values) {
        addCriterion("elec_conditions in", values, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsNotIn(List<String> values) {
        addCriterion("elec_conditions not in", values, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsBetween(String value1, String value2) {
        addCriterion("elec_conditions between", value1, value2, "elecConditions");
        return this;
    }

    public ITBillCriteria andElecConditionsNotBetween(String value1, String value2) {
        addCriterion("elec_conditions not between", value1, value2, "elecConditions");
        return this;
    }

    public ITBillCriteria andBatteryCountIsNull() {
        addCriterion("battery_count is null");
        return this;
    }

    public ITBillCriteria andBatteryCountIsNotNull() {
        addCriterion("battery_count is not null");
        return this;
    }

    public ITBillCriteria andBatteryCountEqualTo(String value) {
        addCriterion("battery_count =", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountNotEqualTo(String value) {
        addCriterion("battery_count <>", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountGreaterThan(String value) {
        addCriterion("battery_count >", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountGreaterThanOrEqualTo(String value) {
        addCriterion("battery_count >=", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountLessThan(String value) {
        addCriterion("battery_count <", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountLessThanOrEqualTo(String value) {
        addCriterion("battery_count <=", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountLike(String value) {
        addCriterion("battery_count like", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountNotLike(String value) {
        addCriterion("battery_count not like", value, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountIn(List<String> values) {
        addCriterion("battery_count in", values, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountNotIn(List<String> values) {
        addCriterion("battery_count not in", values, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountBetween(String value1, String value2) {
        addCriterion("battery_count between", value1, value2, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCountNotBetween(String value1, String value2) {
        addCriterion("battery_count not between", value1, value2, "batteryCount");
        return this;
    }

    public ITBillCriteria andBatteryCapacityIsNull() {
        addCriterion("battery_capacity is null");
        return this;
    }

    public ITBillCriteria andBatteryCapacityIsNotNull() {
        addCriterion("battery_capacity is not null");
        return this;
    }

    public ITBillCriteria andBatteryCapacityEqualTo(String value) {
        addCriterion("battery_capacity =", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityNotEqualTo(String value) {
        addCriterion("battery_capacity <>", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityGreaterThan(String value) {
        addCriterion("battery_capacity >", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityGreaterThanOrEqualTo(String value) {
        addCriterion("battery_capacity >=", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityLessThan(String value) {
        addCriterion("battery_capacity <", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityLessThanOrEqualTo(String value) {
        addCriterion("battery_capacity <=", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityLike(String value) {
        addCriterion("battery_capacity like", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityNotLike(String value) {
        addCriterion("battery_capacity not like", value, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityIn(List<String> values) {
        addCriterion("battery_capacity in", values, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityNotIn(List<String> values) {
        addCriterion("battery_capacity not in", values, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityBetween(String value1, String value2) {
        addCriterion("battery_capacity between", value1, value2, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andBatteryCapacityNotBetween(String value1, String value2) {
        addCriterion("battery_capacity not between", value1, value2, "batteryCapacity");
        return this;
    }

    public ITBillCriteria andTotalCurrentIsNull() {
        addCriterion("total_current is null");
        return this;
    }

    public ITBillCriteria andTotalCurrentIsNotNull() {
        addCriterion("total_current is not null");
        return this;
    }

    public ITBillCriteria andTotalCurrentEqualTo(String value) {
        addCriterion("total_current =", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentNotEqualTo(String value) {
        addCriterion("total_current <>", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentGreaterThan(String value) {
        addCriterion("total_current >", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentGreaterThanOrEqualTo(String value) {
        addCriterion("total_current >=", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentLessThan(String value) {
        addCriterion("total_current <", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentLessThanOrEqualTo(String value) {
        addCriterion("total_current <=", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentLike(String value) {
        addCriterion("total_current like", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentNotLike(String value) {
        addCriterion("total_current not like", value, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentIn(List<String> values) {
        addCriterion("total_current in", values, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentNotIn(List<String> values) {
        addCriterion("total_current not in", values, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentBetween(String value1, String value2) {
        addCriterion("total_current between", value1, value2, "totalCurrent");
        return this;
    }

    public ITBillCriteria andTotalCurrentNotBetween(String value1, String value2) {
        addCriterion("total_current not between", value1, value2, "totalCurrent");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeIsNull() {
        addCriterion("battery_guarantee is null");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeIsNotNull() {
        addCriterion("battery_guarantee is not null");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeEqualTo(String value) {
        addCriterion("battery_guarantee =", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeNotEqualTo(String value) {
        addCriterion("battery_guarantee <>", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeGreaterThan(String value) {
        addCriterion("battery_guarantee >", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeGreaterThanOrEqualTo(String value) {
        addCriterion("battery_guarantee >=", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeLessThan(String value) {
        addCriterion("battery_guarantee <", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeLessThanOrEqualTo(String value) {
        addCriterion("battery_guarantee <=", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeLike(String value) {
        addCriterion("battery_guarantee like", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeNotLike(String value) {
        addCriterion("battery_guarantee not like", value, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeIn(List<String> values) {
        addCriterion("battery_guarantee in", values, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeNotIn(List<String> values) {
        addCriterion("battery_guarantee not in", values, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeBetween(String value1, String value2) {
        addCriterion("battery_guarantee between", value1, value2, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andBatteryGuaranteeNotBetween(String value1, String value2) {
        addCriterion("battery_guarantee not between", value1, value2, "batteryGuarantee");
        return this;
    }

    public ITBillCriteria andAlarmDurationIsNull() {
        addCriterion("alarm_duration is null");
        return this;
    }

    public ITBillCriteria andAlarmDurationIsNotNull() {
        addCriterion("alarm_duration is not null");
        return this;
    }

    public ITBillCriteria andAlarmDurationEqualTo(String value) {
        addCriterion("alarm_duration =", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationNotEqualTo(String value) {
        addCriterion("alarm_duration <>", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationGreaterThan(String value) {
        addCriterion("alarm_duration >", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationGreaterThanOrEqualTo(String value) {
        addCriterion("alarm_duration >=", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationLessThan(String value) {
        addCriterion("alarm_duration <", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationLessThanOrEqualTo(String value) {
        addCriterion("alarm_duration <=", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationLike(String value) {
        addCriterion("alarm_duration like", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationNotLike(String value) {
        addCriterion("alarm_duration not like", value, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationIn(List<String> values) {
        addCriterion("alarm_duration in", values, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationNotIn(List<String> values) {
        addCriterion("alarm_duration not in", values, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationBetween(String value1, String value2) {
        addCriterion("alarm_duration between", value1, value2, "alarmDuration");
        return this;
    }

    public ITBillCriteria andAlarmDurationNotBetween(String value1, String value2) {
        addCriterion("alarm_duration not between", value1, value2, "alarmDuration");
        return this;
    }

    public ITBillCriteria andBillDurationIsNull() {
        addCriterion("bill_duration is null");
        return this;
    }

    public ITBillCriteria andBillDurationIsNotNull() {
        addCriterion("bill_duration is not null");
        return this;
    }

    public ITBillCriteria andBillDurationEqualTo(String value) {
        addCriterion("bill_duration =", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationNotEqualTo(String value) {
        addCriterion("bill_duration <>", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationGreaterThan(String value) {
        addCriterion("bill_duration >", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationGreaterThanOrEqualTo(String value) {
        addCriterion("bill_duration >=", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationLessThan(String value) {
        addCriterion("bill_duration <", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationLessThanOrEqualTo(String value) {
        addCriterion("bill_duration <=", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationLike(String value) {
        addCriterion("bill_duration like", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationNotLike(String value) {
        addCriterion("bill_duration not like", value, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationIn(List<String> values) {
        addCriterion("bill_duration in", values, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationNotIn(List<String> values) {
        addCriterion("bill_duration not in", values, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationBetween(String value1, String value2) {
        addCriterion("bill_duration between", value1, value2, "billDuration");
        return this;
    }

    public ITBillCriteria andBillDurationNotBetween(String value1, String value2) {
        addCriterion("bill_duration not between", value1, value2, "billDuration");
        return this;
    }

    public ITBillCriteria andBillHandlerIsNull() {
        addCriterion("bill_handler is null");
        return this;
    }

    public ITBillCriteria andBillHandlerIsNotNull() {
        addCriterion("bill_handler is not null");
        return this;
    }

    public ITBillCriteria andBillHandlerEqualTo(String value) {
        addCriterion("bill_handler =", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerNotEqualTo(String value) {
        addCriterion("bill_handler <>", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerGreaterThan(String value) {
        addCriterion("bill_handler >", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerGreaterThanOrEqualTo(String value) {
        addCriterion("bill_handler >=", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerLessThan(String value) {
        addCriterion("bill_handler <", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerLessThanOrEqualTo(String value) {
        addCriterion("bill_handler <=", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerLike(String value) {
        addCriterion("bill_handler like", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerNotLike(String value) {
        addCriterion("bill_handler not like", value, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerIn(List<String> values) {
        addCriterion("bill_handler in", values, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerNotIn(List<String> values) {
        addCriterion("bill_handler not in", values, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerBetween(String value1, String value2) {
        addCriterion("bill_handler between", value1, value2, "billHandler");
        return this;
    }

    public ITBillCriteria andBillHandlerNotBetween(String value1, String value2) {
        addCriterion("bill_handler not between", value1, value2, "billHandler");
        return this;
    }

    public ITBillCriteria andReceiptTerminalIsNull() {
        addCriterion("receipt_terminal is null");
        return this;
    }

    public ITBillCriteria andReceiptTerminalIsNotNull() {
        addCriterion("receipt_terminal is not null");
        return this;
    }

    public ITBillCriteria andReceiptTerminalEqualTo(String value) {
        addCriterion("receipt_terminal =", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalNotEqualTo(String value) {
        addCriterion("receipt_terminal <>", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalGreaterThan(String value) {
        addCriterion("receipt_terminal >", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalGreaterThanOrEqualTo(String value) {
        addCriterion("receipt_terminal >=", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalLessThan(String value) {
        addCriterion("receipt_terminal <", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalLessThanOrEqualTo(String value) {
        addCriterion("receipt_terminal <=", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalLike(String value) {
        addCriterion("receipt_terminal like", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalNotLike(String value) {
        addCriterion("receipt_terminal not like", value, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalIn(List<String> values) {
        addCriterion("receipt_terminal in", values, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalNotIn(List<String> values) {
        addCriterion("receipt_terminal not in", values, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalBetween(String value1, String value2) {
        addCriterion("receipt_terminal between", value1, value2, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiptTerminalNotBetween(String value1, String value2) {
        addCriterion("receipt_terminal not between", value1, value2, "receiptTerminal");
        return this;
    }

    public ITBillCriteria andReceiveDurationIsNull() {
        addCriterion("receive_duration is null");
        return this;
    }

    public ITBillCriteria andReceiveDurationIsNotNull() {
        addCriterion("receive_duration is not null");
        return this;
    }

    public ITBillCriteria andReceiveDurationEqualTo(String value) {
        addCriterion("receive_duration =", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationNotEqualTo(String value) {
        addCriterion("receive_duration <>", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationGreaterThan(String value) {
        addCriterion("receive_duration >", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationGreaterThanOrEqualTo(String value) {
        addCriterion("receive_duration >=", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationLessThan(String value) {
        addCriterion("receive_duration <", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationLessThanOrEqualTo(String value) {
        addCriterion("receive_duration <=", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationLike(String value) {
        addCriterion("receive_duration like", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationNotLike(String value) {
        addCriterion("receive_duration not like", value, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationIn(List<String> values) {
        addCriterion("receive_duration in", values, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationNotIn(List<String> values) {
        addCriterion("receive_duration not in", values, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationBetween(String value1, String value2) {
        addCriterion("receive_duration between", value1, value2, "receiveDuration");
        return this;
    }

    public ITBillCriteria andReceiveDurationNotBetween(String value1, String value2) {
        addCriterion("receive_duration not between", value1, value2, "receiveDuration");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeIsNull() {
        addCriterion("first_reply_time is null");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeIsNotNull() {
        addCriterion("first_reply_time is not null");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeEqualTo(Date value) {
        addCriterion("first_reply_time =", value, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeNotEqualTo(Date value) {
        addCriterion("first_reply_time <>", value, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeGreaterThan(Date value) {
        addCriterion("first_reply_time >", value, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("first_reply_time >=", value, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeLessThan(Date value) {
        addCriterion("first_reply_time <", value, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeLessThanOrEqualTo(Date value) {
        addCriterion("first_reply_time <=", value, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeIn(List<Date> values) {
        addCriterion("first_reply_time in", values, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeNotIn(List<Date> values) {
        addCriterion("first_reply_time not in", values, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeBetween(Date value1, Date value2) {
        addCriterion("first_reply_time between", value1, value2, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andFirstReplyTimeNotBetween(Date value1, Date value2) {
        addCriterion("first_reply_time not between", value1, value2, "firstReplyTime");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutIsNull() {
        addCriterion("is_receive_timeout is null");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutIsNotNull() {
        addCriterion("is_receive_timeout is not null");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutEqualTo(String value) {
        addCriterion("is_receive_timeout =", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutNotEqualTo(String value) {
        addCriterion("is_receive_timeout <>", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutGreaterThan(String value) {
        addCriterion("is_receive_timeout >", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutGreaterThanOrEqualTo(String value) {
        addCriterion("is_receive_timeout >=", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutLessThan(String value) {
        addCriterion("is_receive_timeout <", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutLessThanOrEqualTo(String value) {
        addCriterion("is_receive_timeout <=", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutLike(String value) {
        addCriterion("is_receive_timeout like", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutNotLike(String value) {
        addCriterion("is_receive_timeout not like", value, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutIn(List<String> values) {
        addCriterion("is_receive_timeout in", values, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutNotIn(List<String> values) {
        addCriterion("is_receive_timeout not in", values, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutBetween(String value1, String value2) {
        addCriterion("is_receive_timeout between", value1, value2, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andIsReceiveTimeoutNotBetween(String value1, String value2) {
        addCriterion("is_receive_timeout not between", value1, value2, "isReceiveTimeout");
        return this;
    }

    public ITBillCriteria andOperatorIsNull() {
        addCriterion("operator is null");
        return this;
    }

    public ITBillCriteria andOperatorIsNotNull() {
        addCriterion("operator is not null");
        return this;
    }

    public ITBillCriteria andOperatorEqualTo(String value) {
        addCriterion("operator =", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorNotEqualTo(String value) {
        addCriterion("operator <>", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorGreaterThan(String value) {
        addCriterion("operator >", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorGreaterThanOrEqualTo(String value) {
        addCriterion("operator >=", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorLessThan(String value) {
        addCriterion("operator <", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorLessThanOrEqualTo(String value) {
        addCriterion("operator <=", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorLike(String value) {
        addCriterion("operator like", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorNotLike(String value) {
        addCriterion("operator not like", value, "operator");
        return this;
    }

    public ITBillCriteria andOperatorIn(List<String> values) {
        addCriterion("operator in", values, "operator");
        return this;
    }

    public ITBillCriteria andOperatorNotIn(List<String> values) {
        addCriterion("operator not in", values, "operator");
        return this;
    }

    public ITBillCriteria andOperatorBetween(String value1, String value2) {
        addCriterion("operator between", value1, value2, "operator");
        return this;
    }

    public ITBillCriteria andOperatorNotBetween(String value1, String value2) {
        addCriterion("operator not between", value1, value2, "operator");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentIsNull() {
        addCriterion("fault_confirm_content is null");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentIsNotNull() {
        addCriterion("fault_confirm_content is not null");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentEqualTo(String value) {
        addCriterion("fault_confirm_content =", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentNotEqualTo(String value) {
        addCriterion("fault_confirm_content <>", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentGreaterThan(String value) {
        addCriterion("fault_confirm_content >", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentGreaterThanOrEqualTo(String value) {
        addCriterion("fault_confirm_content >=", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentLessThan(String value) {
        addCriterion("fault_confirm_content <", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentLessThanOrEqualTo(String value) {
        addCriterion("fault_confirm_content <=", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentLike(String value) {
        addCriterion("fault_confirm_content like", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentNotLike(String value) {
        addCriterion("fault_confirm_content not like", value, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentIn(List<String> values) {
        addCriterion("fault_confirm_content in", values, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentNotIn(List<String> values) {
        addCriterion("fault_confirm_content not in", values, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentBetween(String value1, String value2) {
        addCriterion("fault_confirm_content between", value1, value2, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andFaultConfirmContentNotBetween(String value1, String value2) {
        addCriterion("fault_confirm_content not between", value1, value2, "faultConfirmContent");
        return this;
    }

    public ITBillCriteria andAreaManagerIsNull() {
        addCriterion("area_manager is null");
        return this;
    }

    public ITBillCriteria andAreaManagerIsNotNull() {
        addCriterion("area_manager is not null");
        return this;
    }

    public ITBillCriteria andAreaManagerEqualTo(String value) {
        addCriterion("area_manager =", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerNotEqualTo(String value) {
        addCriterion("area_manager <>", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerGreaterThan(String value) {
        addCriterion("area_manager >", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerGreaterThanOrEqualTo(String value) {
        addCriterion("area_manager >=", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerLessThan(String value) {
        addCriterion("area_manager <", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerLessThanOrEqualTo(String value) {
        addCriterion("area_manager <=", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerLike(String value) {
        addCriterion("area_manager like", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerNotLike(String value) {
        addCriterion("area_manager not like", value, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerIn(List<String> values) {
        addCriterion("area_manager in", values, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerNotIn(List<String> values) {
        addCriterion("area_manager not in", values, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerBetween(String value1, String value2) {
        addCriterion("area_manager between", value1, value2, "areaManager");
        return this;
    }

    public ITBillCriteria andAreaManagerNotBetween(String value1, String value2) {
        addCriterion("area_manager not between", value1, value2, "areaManager");
        return this;
    }

    public ITBillCriteria andDataOriginIsNull() {
        addCriterion("data_origin is null");
        return this;
    }

    public ITBillCriteria andDataOriginIsNotNull() {
        addCriterion("data_origin is not null");
        return this;
    }

    public ITBillCriteria andDataOriginEqualTo(String value) {
        addCriterion("data_origin =", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginNotEqualTo(String value) {
        addCriterion("data_origin <>", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginGreaterThan(String value) {
        addCriterion("data_origin >", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginGreaterThanOrEqualTo(String value) {
        addCriterion("data_origin >=", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginLessThan(String value) {
        addCriterion("data_origin <", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginLessThanOrEqualTo(String value) {
        addCriterion("data_origin <=", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginLike(String value) {
        addCriterion("data_origin like", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginNotLike(String value) {
        addCriterion("data_origin not like", value, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginIn(List<String> values) {
        addCriterion("data_origin in", values, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginNotIn(List<String> values) {
        addCriterion("data_origin not in", values, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginBetween(String value1, String value2) {
        addCriterion("data_origin between", value1, value2, "dataOrigin");
        return this;
    }

    public ITBillCriteria andDataOriginNotBetween(String value1, String value2) {
        addCriterion("data_origin not between", value1, value2, "dataOrigin");
        return this;
    }

    public ITBillCriteria andReceiveTerminalIsNull() {
        addCriterion("receive_terminal is null");
        return this;
    }

    public ITBillCriteria andReceiveTerminalIsNotNull() {
        addCriterion("receive_terminal is not null");
        return this;
    }

    public ITBillCriteria andReceiveTerminalEqualTo(String value) {
        addCriterion("receive_terminal =", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalNotEqualTo(String value) {
        addCriterion("receive_terminal <>", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalGreaterThan(String value) {
        addCriterion("receive_terminal >", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalGreaterThanOrEqualTo(String value) {
        addCriterion("receive_terminal >=", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalLessThan(String value) {
        addCriterion("receive_terminal <", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalLessThanOrEqualTo(String value) {
        addCriterion("receive_terminal <=", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalLike(String value) {
        addCriterion("receive_terminal like", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalNotLike(String value) {
        addCriterion("receive_terminal not like", value, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalIn(List<String> values) {
        addCriterion("receive_terminal in", values, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalNotIn(List<String> values) {
        addCriterion("receive_terminal not in", values, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalBetween(String value1, String value2) {
        addCriterion("receive_terminal between", value1, value2, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andReceiveTerminalNotBetween(String value1, String value2) {
        addCriterion("receive_terminal not between", value1, value2, "receiveTerminal");
        return this;
    }

    public ITBillCriteria andSignTimeIsNull() {
        addCriterion("sign_time is null");
        return this;
    }

    public ITBillCriteria andSignTimeIsNotNull() {
        addCriterion("sign_time is not null");
        return this;
    }

    public ITBillCriteria andSignTimeEqualTo(Date value) {
        addCriterion("sign_time =", value, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeNotEqualTo(Date value) {
        addCriterion("sign_time <>", value, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeGreaterThan(Date value) {
        addCriterion("sign_time >", value, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("sign_time >=", value, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeLessThan(Date value) {
        addCriterion("sign_time <", value, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeLessThanOrEqualTo(Date value) {
        addCriterion("sign_time <=", value, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeIn(List<Date> values) {
        addCriterion("sign_time in", values, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeNotIn(List<Date> values) {
        addCriterion("sign_time not in", values, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeBetween(Date value1, Date value2) {
        addCriterion("sign_time between", value1, value2, "signTime");
        return this;
    }

    public ITBillCriteria andSignTimeNotBetween(Date value1, Date value2) {
        addCriterion("sign_time not between", value1, value2, "signTime");
        return this;
    }

    public ITBillCriteria andSignLngIsNull() {
        addCriterion("sign_lng is null");
        return this;
    }

    public ITBillCriteria andSignLngIsNotNull() {
        addCriterion("sign_lng is not null");
        return this;
    }

    public ITBillCriteria andSignLngEqualTo(String value) {
        addCriterion("sign_lng =", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngNotEqualTo(String value) {
        addCriterion("sign_lng <>", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngGreaterThan(String value) {
        addCriterion("sign_lng >", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngGreaterThanOrEqualTo(String value) {
        addCriterion("sign_lng >=", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngLessThan(String value) {
        addCriterion("sign_lng <", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngLessThanOrEqualTo(String value) {
        addCriterion("sign_lng <=", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngLike(String value) {
        addCriterion("sign_lng like", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngNotLike(String value) {
        addCriterion("sign_lng not like", value, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngIn(List<String> values) {
        addCriterion("sign_lng in", values, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngNotIn(List<String> values) {
        addCriterion("sign_lng not in", values, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngBetween(String value1, String value2) {
        addCriterion("sign_lng between", value1, value2, "signLng");
        return this;
    }

    public ITBillCriteria andSignLngNotBetween(String value1, String value2) {
        addCriterion("sign_lng not between", value1, value2, "signLng");
        return this;
    }

    public ITBillCriteria andSignLatIsNull() {
        addCriterion("sign_lat is null");
        return this;
    }

    public ITBillCriteria andSignLatIsNotNull() {
        addCriterion("sign_lat is not null");
        return this;
    }

    public ITBillCriteria andSignLatEqualTo(String value) {
        addCriterion("sign_lat =", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatNotEqualTo(String value) {
        addCriterion("sign_lat <>", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatGreaterThan(String value) {
        addCriterion("sign_lat >", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatGreaterThanOrEqualTo(String value) {
        addCriterion("sign_lat >=", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatLessThan(String value) {
        addCriterion("sign_lat <", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatLessThanOrEqualTo(String value) {
        addCriterion("sign_lat <=", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatLike(String value) {
        addCriterion("sign_lat like", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatNotLike(String value) {
        addCriterion("sign_lat not like", value, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatIn(List<String> values) {
        addCriterion("sign_lat in", values, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatNotIn(List<String> values) {
        addCriterion("sign_lat not in", values, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatBetween(String value1, String value2) {
        addCriterion("sign_lat between", value1, value2, "signLat");
        return this;
    }

    public ITBillCriteria andSignLatNotBetween(String value1, String value2) {
        addCriterion("sign_lat not between", value1, value2, "signLat");
        return this;
    }

    public ITBillCriteria andStationLngIsNull() {
        addCriterion("station_lng is null");
        return this;
    }

    public ITBillCriteria andStationLngIsNotNull() {
        addCriterion("station_lng is not null");
        return this;
    }

    public ITBillCriteria andStationLngEqualTo(String value) {
        addCriterion("station_lng =", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngNotEqualTo(String value) {
        addCriterion("station_lng <>", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngGreaterThan(String value) {
        addCriterion("station_lng >", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngGreaterThanOrEqualTo(String value) {
        addCriterion("station_lng >=", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngLessThan(String value) {
        addCriterion("station_lng <", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngLessThanOrEqualTo(String value) {
        addCriterion("station_lng <=", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngLike(String value) {
        addCriterion("station_lng like", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngNotLike(String value) {
        addCriterion("station_lng not like", value, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngIn(List<String> values) {
        addCriterion("station_lng in", values, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngNotIn(List<String> values) {
        addCriterion("station_lng not in", values, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngBetween(String value1, String value2) {
        addCriterion("station_lng between", value1, value2, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLngNotBetween(String value1, String value2) {
        addCriterion("station_lng not between", value1, value2, "stationLng");
        return this;
    }

    public ITBillCriteria andStationLatIsNull() {
        addCriterion("station_lat is null");
        return this;
    }

    public ITBillCriteria andStationLatIsNotNull() {
        addCriterion("station_lat is not null");
        return this;
    }

    public ITBillCriteria andStationLatEqualTo(String value) {
        addCriterion("station_lat =", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatNotEqualTo(String value) {
        addCriterion("station_lat <>", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatGreaterThan(String value) {
        addCriterion("station_lat >", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatGreaterThanOrEqualTo(String value) {
        addCriterion("station_lat >=", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatLessThan(String value) {
        addCriterion("station_lat <", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatLessThanOrEqualTo(String value) {
        addCriterion("station_lat <=", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatLike(String value) {
        addCriterion("station_lat like", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatNotLike(String value) {
        addCriterion("station_lat not like", value, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatIn(List<String> values) {
        addCriterion("station_lat in", values, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatNotIn(List<String> values) {
        addCriterion("station_lat not in", values, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatBetween(String value1, String value2) {
        addCriterion("station_lat between", value1, value2, "stationLat");
        return this;
    }

    public ITBillCriteria andStationLatNotBetween(String value1, String value2) {
        addCriterion("station_lat not between", value1, value2, "stationLat");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillIsNull() {
        addCriterion("is_elec_gener_bill is null");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillIsNotNull() {
        addCriterion("is_elec_gener_bill is not null");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillEqualTo(String value) {
        addCriterion("is_elec_gener_bill =", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillNotEqualTo(String value) {
        addCriterion("is_elec_gener_bill <>", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillGreaterThan(String value) {
        addCriterion("is_elec_gener_bill >", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillGreaterThanOrEqualTo(String value) {
        addCriterion("is_elec_gener_bill >=", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillLessThan(String value) {
        addCriterion("is_elec_gener_bill <", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillLessThanOrEqualTo(String value) {
        addCriterion("is_elec_gener_bill <=", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillLike(String value) {
        addCriterion("is_elec_gener_bill like", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillNotLike(String value) {
        addCriterion("is_elec_gener_bill not like", value, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillIn(List<String> values) {
        addCriterion("is_elec_gener_bill in", values, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillNotIn(List<String> values) {
        addCriterion("is_elec_gener_bill not in", values, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillBetween(String value1, String value2) {
        addCriterion("is_elec_gener_bill between", value1, value2, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andIsElecGenerBillNotBetween(String value1, String value2) {
        addCriterion("is_elec_gener_bill not between", value1, value2, "isElecGenerBill");
        return this;
    }

    public ITBillCriteria andFaultTypeIsNull() {
        addCriterion("fault_type is null");
        return this;
    }

    public ITBillCriteria andFaultTypeIsNotNull() {
        addCriterion("fault_type is not null");
        return this;
    }

    public ITBillCriteria andFaultTypeEqualTo(String value) {
        addCriterion("fault_type =", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeNotEqualTo(String value) {
        addCriterion("fault_type <>", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeGreaterThan(String value) {
        addCriterion("fault_type >", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeGreaterThanOrEqualTo(String value) {
        addCriterion("fault_type >=", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeLessThan(String value) {
        addCriterion("fault_type <", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeLessThanOrEqualTo(String value) {
        addCriterion("fault_type <=", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeLike(String value) {
        addCriterion("fault_type like", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeNotLike(String value) {
        addCriterion("fault_type not like", value, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeIn(List<String> values) {
        addCriterion("fault_type in", values, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeNotIn(List<String> values) {
        addCriterion("fault_type not in", values, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeBetween(String value1, String value2) {
        addCriterion("fault_type between", value1, value2, "faultType");
        return this;
    }

    public ITBillCriteria andFaultTypeNotBetween(String value1, String value2) {
        addCriterion("fault_type not between", value1, value2, "faultType");
        return this;
    }

    public ITBillCriteria andRemarkIsNull() {
        addCriterion("remark is null");
        return this;
    }

    public ITBillCriteria andRemarkIsNotNull() {
        addCriterion("remark is not null");
        return this;
    }

    public ITBillCriteria andRemarkEqualTo(String value) {
        addCriterion("remark =", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkNotEqualTo(String value) {
        addCriterion("remark <>", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkGreaterThan(String value) {
        addCriterion("remark >", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("remark >=", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkLessThan(String value) {
        addCriterion("remark <", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("remark <=", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkLike(String value) {
        addCriterion("remark like", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkNotLike(String value) {
        addCriterion("remark not like", value, "remark");
        return this;
    }

    public ITBillCriteria andRemarkIn(List<String> values) {
        addCriterion("remark in", values, "remark");
        return this;
    }

    public ITBillCriteria andRemarkNotIn(List<String> values) {
        addCriterion("remark not in", values, "remark");
        return this;
    }

    public ITBillCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("remark between", value1, value2, "remark");
        return this;
    }

    public ITBillCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("remark not between", value1, value2, "remark");
        return this;
    }

    public ITBillCriteria andUpdateTimeIsNull() {
        addCriterion("update_time is null");
        return this;
    }

    public ITBillCriteria andUpdateTimeIsNotNull() {
        addCriterion("update_time is not null");
        return this;
    }

    public ITBillCriteria andUpdateTimeEqualTo(Date value) {
        addCriterion("update_time =", value, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeNotEqualTo(Date value) {
        addCriterion("update_time <>", value, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeGreaterThan(Date value) {
        addCriterion("update_time >", value, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("update_time >=", value, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeLessThan(Date value) {
        addCriterion("update_time <", value, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeLessThanOrEqualTo(Date value) {
        addCriterion("update_time <=", value, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeIn(List<Date> values) {
        addCriterion("update_time in", values, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeNotIn(List<Date> values) {
        addCriterion("update_time not in", values, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeBetween(Date value1, Date value2) {
        addCriterion("update_time between", value1, value2, "updateTime");
        return this;
    }

    public ITBillCriteria andUpdateTimeNotBetween(Date value1, Date value2) {
        addCriterion("update_time not between", value1, value2, "updateTime");
        return this;
    }

    public ITBillCriteria andCreateTimeIsNull() {
        addCriterion("create_time is null");
        return this;
    }

    public ITBillCriteria andCreateTimeIsNotNull() {
        addCriterion("create_time is not null");
        return this;
    }

    public ITBillCriteria andCreateTimeEqualTo(Date value) {
        addCriterion("create_time =", value, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeNotEqualTo(Date value) {
        addCriterion("create_time <>", value, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeGreaterThan(Date value) {
        addCriterion("create_time >", value, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("create_time >=", value, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeLessThan(Date value) {
        addCriterion("create_time <", value, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("create_time <=", value, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeIn(List<Date> values) {
        addCriterion("create_time in", values, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeNotIn(List<Date> values) {
        addCriterion("create_time not in", values, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("create_time between", value1, value2, "createTime");
        return this;
    }

    public ITBillCriteria andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("create_time not between", value1, value2, "createTime");
        return this;
    }

    public ITBillCriteria andStatusIsNull() {
        addCriterion("status is null");
        return this;
    }

    public ITBillCriteria andStatusIsNotNull() {
        addCriterion("status is not null");
        return this;
    }

    public ITBillCriteria andStatusEqualTo(int value) {
        addCriterion("status =", new Integer(value), "status");
        return this;
    }

    public ITBillCriteria andStatusNotEqualTo(int value) {
        addCriterion("status <>", new Integer(value), "status");
        return this;
    }

    public ITBillCriteria andStatusGreaterThan(int value) {
        addCriterion("status >", new Integer(value), "status");
        return this;
    }

    public ITBillCriteria andStatusGreaterThanOrEqualTo(int value) {
        addCriterion("status >=", new Integer(value), "status");
        return this;
    }

    public ITBillCriteria andStatusLessThan(int value) {
        addCriterion("status <", new Integer(value), "status");
        return this;
    }

    public ITBillCriteria andStatusLessThanOrEqualTo(int value) {
        addCriterion("status <=", new Integer(value), "status");
        return this;
    }

    public ITBillCriteria andStatusIn(List<Integer> values) {
        addCriterion("status in", values, "status");
        return this;
    }

    public ITBillCriteria andStatusNotIn(List<Integer> values) {
        addCriterion("status not in", values, "status");
        return this;
    }

    public ITBillCriteria andStatusBetween(int value1, int value2) {
        addCriterion("status between", new Integer(value1), new Integer(value2), "status");
        return this;
    }

    public ITBillCriteria andStatusNotBetween(int value1, int value2) {
        addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
        return this;
    }
}