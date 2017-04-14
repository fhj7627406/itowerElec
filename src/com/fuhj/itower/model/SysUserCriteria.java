package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class SysUserCriteria extends Criteria {

    public SysUserCriteria andIdIsNull() {
        addCriterion("id is null");
        return this;
    }

    public SysUserCriteria andIdIsNotNull() {
        addCriterion("id is not null");
        return this;
    }

    public SysUserCriteria andIdEqualTo(int value) {
        addCriterion("id =", new Integer(value), "id");
        return this;
    }

    public SysUserCriteria andIdNotEqualTo(int value) {
        addCriterion("id <>", new Integer(value), "id");
        return this;
    }

    public SysUserCriteria andIdGreaterThan(int value) {
        addCriterion("id >", new Integer(value), "id");
        return this;
    }

    public SysUserCriteria andIdGreaterThanOrEqualTo(int value) {
        addCriterion("id >=", new Integer(value), "id");
        return this;
    }

    public SysUserCriteria andIdLessThan(int value) {
        addCriterion("id <", new Integer(value), "id");
        return this;
    }

    public SysUserCriteria andIdLessThanOrEqualTo(int value) {
        addCriterion("id <=", new Integer(value), "id");
        return this;
    }

    public SysUserCriteria andIdIn(List<Integer> values) {
        addCriterion("id in", values, "id");
        return this;
    }

    public SysUserCriteria andIdNotIn(List<Integer> values) {
        addCriterion("id not in", values, "id");
        return this;
    }

    public SysUserCriteria andIdBetween(int value1, int value2) {
        addCriterion("id between", new Integer(value1), new Integer(value2), "id");
        return this;
    }

    public SysUserCriteria andIdNotBetween(int value1, int value2) {
        addCriterion("id not between", new Integer(value1), new Integer(value2), "id");
        return this;
    }

    public SysUserCriteria andLoginnameIsNull() {
        addCriterion("loginname is null");
        return this;
    }

    public SysUserCriteria andLoginnameIsNotNull() {
        addCriterion("loginname is not null");
        return this;
    }

    public SysUserCriteria andLoginnameEqualTo(String value) {
        addCriterion("loginname =", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameNotEqualTo(String value) {
        addCriterion("loginname <>", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameGreaterThan(String value) {
        addCriterion("loginname >", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameGreaterThanOrEqualTo(String value) {
        addCriterion("loginname >=", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameLessThan(String value) {
        addCriterion("loginname <", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameLessThanOrEqualTo(String value) {
        addCriterion("loginname <=", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameLike(String value) {
        addCriterion("loginname like", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameNotLike(String value) {
        addCriterion("loginname not like", value, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameIn(List<String> values) {
        addCriterion("loginname in", values, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameNotIn(List<String> values) {
        addCriterion("loginname not in", values, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameBetween(String value1, String value2) {
        addCriterion("loginname between", value1, value2, "loginname");
        return this;
    }

    public SysUserCriteria andLoginnameNotBetween(String value1, String value2) {
        addCriterion("loginname not between", value1, value2, "loginname");
        return this;
    }

    public SysUserCriteria andLoginpwdIsNull() {
        addCriterion("loginpwd is null");
        return this;
    }

    public SysUserCriteria andLoginpwdIsNotNull() {
        addCriterion("loginpwd is not null");
        return this;
    }

    public SysUserCriteria andLoginpwdEqualTo(String value) {
        addCriterion("loginpwd =", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdNotEqualTo(String value) {
        addCriterion("loginpwd <>", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdGreaterThan(String value) {
        addCriterion("loginpwd >", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdGreaterThanOrEqualTo(String value) {
        addCriterion("loginpwd >=", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdLessThan(String value) {
        addCriterion("loginpwd <", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdLessThanOrEqualTo(String value) {
        addCriterion("loginpwd <=", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdLike(String value) {
        addCriterion("loginpwd like", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdNotLike(String value) {
        addCriterion("loginpwd not like", value, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdIn(List<String> values) {
        addCriterion("loginpwd in", values, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdNotIn(List<String> values) {
        addCriterion("loginpwd not in", values, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdBetween(String value1, String value2) {
        addCriterion("loginpwd between", value1, value2, "loginpwd");
        return this;
    }

    public SysUserCriteria andLoginpwdNotBetween(String value1, String value2) {
        addCriterion("loginpwd not between", value1, value2, "loginpwd");
        return this;
    }

    public SysUserCriteria andUsernameIsNull() {
        addCriterion("username is null");
        return this;
    }

    public SysUserCriteria andUsernameIsNotNull() {
        addCriterion("username is not null");
        return this;
    }

    public SysUserCriteria andUsernameEqualTo(String value) {
        addCriterion("username =", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameNotEqualTo(String value) {
        addCriterion("username <>", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameGreaterThan(String value) {
        addCriterion("username >", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameGreaterThanOrEqualTo(String value) {
        addCriterion("username >=", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameLessThan(String value) {
        addCriterion("username <", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameLessThanOrEqualTo(String value) {
        addCriterion("username <=", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameLike(String value) {
        addCriterion("username like", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameNotLike(String value) {
        addCriterion("username not like", value, "username");
        return this;
    }

    public SysUserCriteria andUsernameIn(List<String> values) {
        addCriterion("username in", values, "username");
        return this;
    }

    public SysUserCriteria andUsernameNotIn(List<String> values) {
        addCriterion("username not in", values, "username");
        return this;
    }

    public SysUserCriteria andUsernameBetween(String value1, String value2) {
        addCriterion("username between", value1, value2, "username");
        return this;
    }

    public SysUserCriteria andUsernameNotBetween(String value1, String value2) {
        addCriterion("username not between", value1, value2, "username");
        return this;
    }

    public SysUserCriteria andCreatetimeIsNull() {
        addCriterion("createtime is null");
        return this;
    }

    public SysUserCriteria andCreatetimeIsNotNull() {
        addCriterion("createtime is not null");
        return this;
    }

    public SysUserCriteria andCreatetimeEqualTo(Date value) {
        addCriterion("createtime =", value, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeNotEqualTo(Date value) {
        addCriterion("createtime <>", value, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeGreaterThan(Date value) {
        addCriterion("createtime >", value, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeGreaterThanOrEqualTo(Date value) {
        addCriterion("createtime >=", value, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeLessThan(Date value) {
        addCriterion("createtime <", value, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeLessThanOrEqualTo(Date value) {
        addCriterion("createtime <=", value, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeIn(List<Date> values) {
        addCriterion("createtime in", values, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeNotIn(List<Date> values) {
        addCriterion("createtime not in", values, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeBetween(Date value1, Date value2) {
        addCriterion("createtime between", value1, value2, "createtime");
        return this;
    }

    public SysUserCriteria andCreatetimeNotBetween(Date value1, Date value2) {
        addCriterion("createtime not between", value1, value2, "createtime");
        return this;
    }

    public SysUserCriteria andLastlogintimeIsNull() {
        addCriterion("lastlogintime is null");
        return this;
    }

    public SysUserCriteria andLastlogintimeIsNotNull() {
        addCriterion("lastlogintime is not null");
        return this;
    }

    public SysUserCriteria andLastlogintimeEqualTo(Date value) {
        addCriterion("lastlogintime =", value, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeNotEqualTo(Date value) {
        addCriterion("lastlogintime <>", value, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeGreaterThan(Date value) {
        addCriterion("lastlogintime >", value, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
        addCriterion("lastlogintime >=", value, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeLessThan(Date value) {
        addCriterion("lastlogintime <", value, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeLessThanOrEqualTo(Date value) {
        addCriterion("lastlogintime <=", value, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeIn(List<Date> values) {
        addCriterion("lastlogintime in", values, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeNotIn(List<Date> values) {
        addCriterion("lastlogintime not in", values, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeBetween(Date value1, Date value2) {
        addCriterion("lastlogintime between", value1, value2, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastlogintimeNotBetween(Date value1, Date value2) {
        addCriterion("lastlogintime not between", value1, value2, "lastlogintime");
        return this;
    }

    public SysUserCriteria andLastloginipIsNull() {
        addCriterion("lastloginip is null");
        return this;
    }

    public SysUserCriteria andLastloginipIsNotNull() {
        addCriterion("lastloginip is not null");
        return this;
    }

    public SysUserCriteria andLastloginipEqualTo(String value) {
        addCriterion("lastloginip =", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipNotEqualTo(String value) {
        addCriterion("lastloginip <>", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipGreaterThan(String value) {
        addCriterion("lastloginip >", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipGreaterThanOrEqualTo(String value) {
        addCriterion("lastloginip >=", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipLessThan(String value) {
        addCriterion("lastloginip <", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipLessThanOrEqualTo(String value) {
        addCriterion("lastloginip <=", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipLike(String value) {
        addCriterion("lastloginip like", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipNotLike(String value) {
        addCriterion("lastloginip not like", value, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipIn(List<String> values) {
        addCriterion("lastloginip in", values, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipNotIn(List<String> values) {
        addCriterion("lastloginip not in", values, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipBetween(String value1, String value2) {
        addCriterion("lastloginip between", value1, value2, "lastloginip");
        return this;
    }

    public SysUserCriteria andLastloginipNotBetween(String value1, String value2) {
        addCriterion("lastloginip not between", value1, value2, "lastloginip");
        return this;
    }

    public SysUserCriteria andStatusIsNull() {
        addCriterion("status is null");
        return this;
    }

    public SysUserCriteria andStatusIsNotNull() {
        addCriterion("status is not null");
        return this;
    }

    public SysUserCriteria andStatusEqualTo(int value) {
        addCriterion("status =", new Integer(value), "status");
        return this;
    }

    public SysUserCriteria andStatusNotEqualTo(int value) {
        addCriterion("status <>", new Integer(value), "status");
        return this;
    }

    public SysUserCriteria andStatusGreaterThan(int value) {
        addCriterion("status >", new Integer(value), "status");
        return this;
    }

    public SysUserCriteria andStatusGreaterThanOrEqualTo(int value) {
        addCriterion("status >=", new Integer(value), "status");
        return this;
    }

    public SysUserCriteria andStatusLessThan(int value) {
        addCriterion("status <", new Integer(value), "status");
        return this;
    }

    public SysUserCriteria andStatusLessThanOrEqualTo(int value) {
        addCriterion("status <=", new Integer(value), "status");
        return this;
    }

    public SysUserCriteria andStatusIn(List<Integer> values) {
        addCriterion("status in", values, "status");
        return this;
    }

    public SysUserCriteria andStatusNotIn(List<Integer> values) {
        addCriterion("status not in", values, "status");
        return this;
    }

    public SysUserCriteria andStatusBetween(int value1, int value2) {
        addCriterion("status between", new Integer(value1), new Integer(value2), "status");
        return this;
    }

    public SysUserCriteria andStatusNotBetween(int value1, int value2) {
        addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
        return this;
    }

    public SysUserCriteria andLevelIsNull() {
        addCriterion("level is null");
        return this;
    }

    public SysUserCriteria andLevelIsNotNull() {
        addCriterion("level is not null");
        return this;
    }

    public SysUserCriteria andLevelEqualTo(int value) {
        addCriterion("level =", new Integer(value), "level");
        return this;
    }

    public SysUserCriteria andLevelNotEqualTo(int value) {
        addCriterion("level <>", new Integer(value), "level");
        return this;
    }

    public SysUserCriteria andLevelGreaterThan(int value) {
        addCriterion("level >", new Integer(value), "level");
        return this;
    }

    public SysUserCriteria andLevelGreaterThanOrEqualTo(int value) {
        addCriterion("level >=", new Integer(value), "level");
        return this;
    }

    public SysUserCriteria andLevelLessThan(int value) {
        addCriterion("level <", new Integer(value), "level");
        return this;
    }

    public SysUserCriteria andLevelLessThanOrEqualTo(int value) {
        addCriterion("level <=", new Integer(value), "level");
        return this;
    }

    public SysUserCriteria andLevelIn(List<Integer> values) {
        addCriterion("level in", values, "level");
        return this;
    }

    public SysUserCriteria andLevelNotIn(List<Integer> values) {
        addCriterion("level not in", values, "level");
        return this;
    }

    public SysUserCriteria andLevelBetween(int value1, int value2) {
        addCriterion("level between", new Integer(value1), new Integer(value2), "level");
        return this;
    }

    public SysUserCriteria andLevelNotBetween(int value1, int value2) {
        addCriterion("level not between", new Integer(value1), new Integer(value2), "level");
        return this;
    }

    public SysUserCriteria andPermIsNull() {
        addCriterion("perm is null");
        return this;
    }

    public SysUserCriteria andPermIsNotNull() {
        addCriterion("perm is not null");
        return this;
    }

    public SysUserCriteria andPermEqualTo(String value) {
        addCriterion("perm =", value, "perm");
        return this;
    }

    public SysUserCriteria andPermNotEqualTo(String value) {
        addCriterion("perm <>", value, "perm");
        return this;
    }

    public SysUserCriteria andPermGreaterThan(String value) {
        addCriterion("perm >", value, "perm");
        return this;
    }

    public SysUserCriteria andPermGreaterThanOrEqualTo(String value) {
        addCriterion("perm >=", value, "perm");
        return this;
    }

    public SysUserCriteria andPermLessThan(String value) {
        addCriterion("perm <", value, "perm");
        return this;
    }

    public SysUserCriteria andPermLessThanOrEqualTo(String value) {
        addCriterion("perm <=", value, "perm");
        return this;
    }

    public SysUserCriteria andPermLike(String value) {
        addCriterion("perm like", value, "perm");
        return this;
    }

    public SysUserCriteria andPermNotLike(String value) {
        addCriterion("perm not like", value, "perm");
        return this;
    }

    public SysUserCriteria andPermIn(List<String> values) {
        addCriterion("perm in", values, "perm");
        return this;
    }

    public SysUserCriteria andPermNotIn(List<String> values) {
        addCriterion("perm not in", values, "perm");
        return this;
    }

    public SysUserCriteria andPermBetween(String value1, String value2) {
        addCriterion("perm between", value1, value2, "perm");
        return this;
    }

    public SysUserCriteria andPermNotBetween(String value1, String value2) {
        addCriterion("perm not between", value1, value2, "perm");
        return this;
    }

    public SysUserCriteria andRemarkIsNull() {
        addCriterion("remark is null");
        return this;
    }

    public SysUserCriteria andRemarkIsNotNull() {
        addCriterion("remark is not null");
        return this;
    }

    public SysUserCriteria andRemarkEqualTo(String value) {
        addCriterion("remark =", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkNotEqualTo(String value) {
        addCriterion("remark <>", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkGreaterThan(String value) {
        addCriterion("remark >", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkGreaterThanOrEqualTo(String value) {
        addCriterion("remark >=", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkLessThan(String value) {
        addCriterion("remark <", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkLessThanOrEqualTo(String value) {
        addCriterion("remark <=", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkLike(String value) {
        addCriterion("remark like", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkNotLike(String value) {
        addCriterion("remark not like", value, "remark");
        return this;
    }

    public SysUserCriteria andRemarkIn(List<String> values) {
        addCriterion("remark in", values, "remark");
        return this;
    }

    public SysUserCriteria andRemarkNotIn(List<String> values) {
        addCriterion("remark not in", values, "remark");
        return this;
    }

    public SysUserCriteria andRemarkBetween(String value1, String value2) {
        addCriterion("remark between", value1, value2, "remark");
        return this;
    }

    public SysUserCriteria andRemarkNotBetween(String value1, String value2) {
        addCriterion("remark not between", value1, value2, "remark");
        return this;
    }
}