package com.fuhj.itower.model;


import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class BotChatLogCriteria extends Criteria {

    public BotChatLogCriteria andIdIsNull() {
        addCriterion("id is null");
        return this;
    }

    public BotChatLogCriteria andIdIsNotNull() {
        addCriterion("id is not null");
        return this;
    }

    public BotChatLogCriteria andIdEqualTo(int value) {
        addCriterion("id =", new Integer(value), "id");
        return this;
    }

    public BotChatLogCriteria andIdNotEqualTo(int value) {
        addCriterion("id <>", new Integer(value), "id");
        return this;
    }

    public BotChatLogCriteria andIdGreaterThan(int value) {
        addCriterion("id >", new Integer(value), "id");
        return this;
    }

    public BotChatLogCriteria andIdGreaterThanOrEqualTo(int value) {
        addCriterion("id >=", new Integer(value), "id");
        return this;
    }

    public BotChatLogCriteria andIdLessThan(int value) {
        addCriterion("id <", new Integer(value), "id");
        return this;
    }

    public BotChatLogCriteria andIdLessThanOrEqualTo(int value) {
        addCriterion("id <=", new Integer(value), "id");
        return this;
    }

    public BotChatLogCriteria andIdIn(List<Integer> values) {
        addCriterion("id in", values, "id");
        return this;
    }

    public BotChatLogCriteria andIdNotIn(List<Integer> values) {
        addCriterion("id not in", values, "id");
        return this;
    }

    public BotChatLogCriteria andIdBetween(int value1, int value2) {
        addCriterion("id between", new Integer(value1), new Integer(value2), "id");
        return this;
    }

    public BotChatLogCriteria andIdNotBetween(int value1, int value2) {
        addCriterion("id not between", new Integer(value1), new Integer(value2), "id");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendIsNull() {
        addCriterion("receiveorsend is null");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendIsNotNull() {
        addCriterion("receiveorsend is not null");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendEqualTo(int value) {
        addCriterion("receiveorsend =", new Integer(value), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendNotEqualTo(int value) {
        addCriterion("receiveorsend <>", new Integer(value), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendGreaterThan(int value) {
        addCriterion("receiveorsend >", new Integer(value), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendGreaterThanOrEqualTo(int value) {
        addCriterion("receiveorsend >=", new Integer(value), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendLessThan(int value) {
        addCriterion("receiveorsend <", new Integer(value), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendLessThanOrEqualTo(int value) {
        addCriterion("receiveorsend <=", new Integer(value), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendIn(List<Integer> values) {
        addCriterion("receiveorsend in", values, "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendNotIn(List<Integer> values) {
        addCriterion("receiveorsend not in", values, "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendBetween(int value1, int value2) {
        addCriterion("receiveorsend between", new Integer(value1), new Integer(value2), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andReceiveorsendNotBetween(int value1, int value2) {
        addCriterion("receiveorsend not between", new Integer(value1), new Integer(value2), "receiveorsend");
        return this;
    }

    public BotChatLogCriteria andFromuserIsNull() {
        addCriterion("fromUser is null");
        return this;
    }

    public BotChatLogCriteria andFromuserIsNotNull() {
        addCriterion("fromUser is not null");
        return this;
    }

    public BotChatLogCriteria andFromuserEqualTo(String value) {
        addCriterion("fromUser =", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserNotEqualTo(String value) {
        addCriterion("fromUser <>", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserGreaterThan(String value) {
        addCriterion("fromUser >", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserGreaterThanOrEqualTo(String value) {
        addCriterion("fromUser >=", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserLessThan(String value) {
        addCriterion("fromUser <", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserLessThanOrEqualTo(String value) {
        addCriterion("fromUser <=", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserLike(String value) {
        addCriterion("fromUser like", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserNotLike(String value) {
        addCriterion("fromUser not like", value, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserIn(List<String> values) {
        addCriterion("fromUser in", values, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserNotIn(List<String> values) {
        addCriterion("fromUser not in", values, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserBetween(String value1, String value2) {
        addCriterion("fromUser between", value1, value2, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromuserNotBetween(String value1, String value2) {
        addCriterion("fromUser not between", value1, value2, "fromuser");
        return this;
    }

    public BotChatLogCriteria andFromusernameIsNull() {
        addCriterion("fromUserName is null");
        return this;
    }

    public BotChatLogCriteria andFromusernameIsNotNull() {
        addCriterion("fromUserName is not null");
        return this;
    }

    public BotChatLogCriteria andFromusernameEqualTo(String value) {
        addCriterion("fromUserName =", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameNotEqualTo(String value) {
        addCriterion("fromUserName <>", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameGreaterThan(String value) {
        addCriterion("fromUserName >", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameGreaterThanOrEqualTo(String value) {
        addCriterion("fromUserName >=", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameLessThan(String value) {
        addCriterion("fromUserName <", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameLessThanOrEqualTo(String value) {
        addCriterion("fromUserName <=", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameLike(String value) {
        addCriterion("fromUserName like", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameNotLike(String value) {
        addCriterion("fromUserName not like", value, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameIn(List<String> values) {
        addCriterion("fromUserName in", values, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameNotIn(List<String> values) {
        addCriterion("fromUserName not in", values, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameBetween(String value1, String value2) {
        addCriterion("fromUserName between", value1, value2, "fromusername");
        return this;
    }

    public BotChatLogCriteria andFromusernameNotBetween(String value1, String value2) {
        addCriterion("fromUserName not between", value1, value2, "fromusername");
        return this;
    }

    public BotChatLogCriteria andTouserIsNull() {
        addCriterion("toUser is null");
        return this;
    }

    public BotChatLogCriteria andTouserIsNotNull() {
        addCriterion("toUser is not null");
        return this;
    }

    public BotChatLogCriteria andTouserEqualTo(String value) {
        addCriterion("toUser =", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserNotEqualTo(String value) {
        addCriterion("toUser <>", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserGreaterThan(String value) {
        addCriterion("toUser >", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserGreaterThanOrEqualTo(String value) {
        addCriterion("toUser >=", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserLessThan(String value) {
        addCriterion("toUser <", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserLessThanOrEqualTo(String value) {
        addCriterion("toUser <=", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserLike(String value) {
        addCriterion("toUser like", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserNotLike(String value) {
        addCriterion("toUser not like", value, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserIn(List<String> values) {
        addCriterion("toUser in", values, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserNotIn(List<String> values) {
        addCriterion("toUser not in", values, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserBetween(String value1, String value2) {
        addCriterion("toUser between", value1, value2, "touser");
        return this;
    }

    public BotChatLogCriteria andTouserNotBetween(String value1, String value2) {
        addCriterion("toUser not between", value1, value2, "touser");
        return this;
    }

    public BotChatLogCriteria andTousernameIsNull() {
        addCriterion("toUserName is null");
        return this;
    }

    public BotChatLogCriteria andTousernameIsNotNull() {
        addCriterion("toUserName is not null");
        return this;
    }

    public BotChatLogCriteria andTousernameEqualTo(String value) {
        addCriterion("toUserName =", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameNotEqualTo(String value) {
        addCriterion("toUserName <>", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameGreaterThan(String value) {
        addCriterion("toUserName >", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameGreaterThanOrEqualTo(String value) {
        addCriterion("toUserName >=", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameLessThan(String value) {
        addCriterion("toUserName <", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameLessThanOrEqualTo(String value) {
        addCriterion("toUserName <=", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameLike(String value) {
        addCriterion("toUserName like", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameNotLike(String value) {
        addCriterion("toUserName not like", value, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameIn(List<String> values) {
        addCriterion("toUserName in", values, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameNotIn(List<String> values) {
        addCriterion("toUserName not in", values, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameBetween(String value1, String value2) {
        addCriterion("toUserName between", value1, value2, "tousername");
        return this;
    }

    public BotChatLogCriteria andTousernameNotBetween(String value1, String value2) {
        addCriterion("toUserName not between", value1, value2, "tousername");
        return this;
    }

    public BotChatLogCriteria andMsgtypeIsNull() {
        addCriterion("msgType is null");
        return this;
    }

    public BotChatLogCriteria andMsgtypeIsNotNull() {
        addCriterion("msgType is not null");
        return this;
    }

    public BotChatLogCriteria andMsgtypeEqualTo(int value) {
        addCriterion("msgType =", new Integer(value), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeNotEqualTo(int value) {
        addCriterion("msgType <>", new Integer(value), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeGreaterThan(int value) {
        addCriterion("msgType >", new Integer(value), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeGreaterThanOrEqualTo(int value) {
        addCriterion("msgType >=", new Integer(value), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeLessThan(int value) {
        addCriterion("msgType <", new Integer(value), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeLessThanOrEqualTo(int value) {
        addCriterion("msgType <=", new Integer(value), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeIn(List<Integer> values) {
        addCriterion("msgType in", values, "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeNotIn(List<Integer> values) {
        addCriterion("msgType not in", values, "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeBetween(int value1, int value2) {
        addCriterion("msgType between", new Integer(value1), new Integer(value2), "msgtype");
        return this;
    }

    public BotChatLogCriteria andMsgtypeNotBetween(int value1, int value2) {
        addCriterion("msgType not between", new Integer(value1), new Integer(value2), "msgtype");
        return this;
    }

    public BotChatLogCriteria andFrommyselfIsNull() {
        addCriterion("fromMyself is null");
        return this;
    }

    public BotChatLogCriteria andFrommyselfIsNotNull() {
        addCriterion("fromMyself is not null");
        return this;
    }

    public BotChatLogCriteria andFrommyselfEqualTo(int value) {
        addCriterion("fromMyself =", new Integer(value), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfNotEqualTo(int value) {
        addCriterion("fromMyself <>", new Integer(value), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfGreaterThan(int value) {
        addCriterion("fromMyself >", new Integer(value), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfGreaterThanOrEqualTo(int value) {
        addCriterion("fromMyself >=", new Integer(value), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfLessThan(int value) {
        addCriterion("fromMyself <", new Integer(value), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfLessThanOrEqualTo(int value) {
        addCriterion("fromMyself <=", new Integer(value), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfIn(List<Integer> values) {
        addCriterion("fromMyself in", values, "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfNotIn(List<Integer> values) {
        addCriterion("fromMyself not in", values, "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfBetween(int value1, int value2) {
        addCriterion("fromMyself between", new Integer(value1), new Integer(value2), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFrommyselfNotBetween(int value1, int value2) {
        addCriterion("fromMyself not between", new Integer(value1), new Integer(value2), "frommyself");
        return this;
    }

    public BotChatLogCriteria andFromgroupIsNull() {
        addCriterion("fromGroup is null");
        return this;
    }

    public BotChatLogCriteria andFromgroupIsNotNull() {
        addCriterion("fromGroup is not null");
        return this;
    }

    public BotChatLogCriteria andFromgroupEqualTo(int value) {
        addCriterion("fromGroup =", new Integer(value), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupNotEqualTo(int value) {
        addCriterion("fromGroup <>", new Integer(value), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupGreaterThan(int value) {
        addCriterion("fromGroup >", new Integer(value), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupGreaterThanOrEqualTo(int value) {
        addCriterion("fromGroup >=", new Integer(value), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupLessThan(int value) {
        addCriterion("fromGroup <", new Integer(value), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupLessThanOrEqualTo(int value) {
        addCriterion("fromGroup <=", new Integer(value), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupIn(List<Integer> values) {
        addCriterion("fromGroup in", values, "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupNotIn(List<Integer> values) {
        addCriterion("fromGroup not in", values, "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupBetween(int value1, int value2) {
        addCriterion("fromGroup between", new Integer(value1), new Integer(value2), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andFromgroupNotBetween(int value1, int value2) {
        addCriterion("fromGroup not between", new Integer(value1), new Integer(value2), "fromgroup");
        return this;
    }

    public BotChatLogCriteria andLogtimeIsNull() {
        addCriterion("logTime is null");
        return this;
    }

    public BotChatLogCriteria andLogtimeIsNotNull() {
        addCriterion("logTime is not null");
        return this;
    }

    public BotChatLogCriteria andLogtimeEqualTo(Date value) {
        addCriterion("logTime =", value, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeNotEqualTo(Date value) {
        addCriterion("logTime <>", value, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeGreaterThan(Date value) {
        addCriterion("logTime >", value, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeGreaterThanOrEqualTo(Date value) {
        addCriterion("logTime >=", value, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeLessThan(Date value) {
        addCriterion("logTime <", value, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeLessThanOrEqualTo(Date value) {
        addCriterion("logTime <=", value, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeIn(List<Date> values) {
        addCriterion("logTime in", values, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeNotIn(List<Date> values) {
        addCriterion("logTime not in", values, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeBetween(Date value1, Date value2) {
        addCriterion("logTime between", value1, value2, "logtime");
        return this;
    }

    public BotChatLogCriteria andLogtimeNotBetween(Date value1, Date value2) {
        addCriterion("logTime not between", value1, value2, "logtime");
        return this;
    }

    public BotChatLogCriteria andServicetypeIsNull() {
        addCriterion("serviceType is null");
        return this;
    }

    public BotChatLogCriteria andServicetypeIsNotNull() {
        addCriterion("serviceType is not null");
        return this;
    }

    public BotChatLogCriteria andServicetypeEqualTo(int value) {
        addCriterion("serviceType =", new Integer(value), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeNotEqualTo(int value) {
        addCriterion("serviceType <>", new Integer(value), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeGreaterThan(int value) {
        addCriterion("serviceType >", new Integer(value), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeGreaterThanOrEqualTo(int value) {
        addCriterion("serviceType >=", new Integer(value), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeLessThan(int value) {
        addCriterion("serviceType <", new Integer(value), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeLessThanOrEqualTo(int value) {
        addCriterion("serviceType <=", new Integer(value), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeIn(List<Integer> values) {
        addCriterion("serviceType in", values, "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeNotIn(List<Integer> values) {
        addCriterion("serviceType not in", values, "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeBetween(int value1, int value2) {
        addCriterion("serviceType between", new Integer(value1), new Integer(value2), "servicetype");
        return this;
    }

    public BotChatLogCriteria andServicetypeNotBetween(int value1, int value2) {
        addCriterion("serviceType not between", new Integer(value1), new Integer(value2), "servicetype");
        return this;
    }

    public BotChatLogCriteria andRemarkIsNull() {
        addCriterion("remark is null");
        return this;
    }

    public BotChatLogCriteria andRemarkIsNotNull() {
        addCriterion("remark is not null");
        return this;
    }

    public BotChatLogCriteria andRemarkEqualTo(String value) {
        addCriterion("remark =", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkNotEqualTo(String value) {
        addCriterion("remark <>", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkGreaterThan(String value) {
        addCriterion("remark >", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("remark >=", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkLessThan(String value) {
        addCriterion("remark <", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("remark <=", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkLike(String value) {
        addCriterion("remark like", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkNotLike(String value) {
        addCriterion("remark not like", value, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkIn(List<String> values) {
        addCriterion("remark in", values, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkNotIn(List<String> values) {
        addCriterion("remark not in", values, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("remark between", value1, value2, "remark");
        return this;
    }

    public BotChatLogCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("remark not between", value1, value2, "remark");
        return this;
    }
}