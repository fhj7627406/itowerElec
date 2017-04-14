package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class UpdateLogCriteria extends Criteria {

	public UpdateLogCriteria andIdIsNull() {
		addCriterion("id is null");
		return this;
	}

	public UpdateLogCriteria andIdIsNotNull() {
		addCriterion("id is not null");
		return this;
	}

	public UpdateLogCriteria andIdEqualTo(int value) {
		addCriterion("id =", new Integer(value), "id");
		return this;
	}

	public UpdateLogCriteria andIdNotEqualTo(int value) {
		addCriterion("id <>", new Integer(value), "id");
		return this;
	}

	public UpdateLogCriteria andIdGreaterThan(int value) {
		addCriterion("id >", new Integer(value), "id");
		return this;
	}

	public UpdateLogCriteria andIdGreaterThanOrEqualTo(int value) {
		addCriterion("id >=", new Integer(value), "id");
		return this;
	}

	public UpdateLogCriteria andIdLessThan(int value) {
		addCriterion("id <", new Integer(value), "id");
		return this;
	}

	public UpdateLogCriteria andIdLessThanOrEqualTo(int value) {
		addCriterion("id <=", new Integer(value), "id");
		return this;
	}

	public UpdateLogCriteria andIdIn(List<Integer> values) {
		addCriterion("id in", values, "id");
		return this;
	}

	public UpdateLogCriteria andIdNotIn(List<Integer> values) {
		addCriterion("id not in", values, "id");
		return this;
	}

	public UpdateLogCriteria andIdBetween(int value1, int value2) {
		addCriterion("id between", new Integer(value1), new Integer(value2), "id");
		return this;
	}

	public UpdateLogCriteria andIdNotBetween(int value1, int value2) {
		addCriterion("id not between", new Integer(value1), new Integer(value2), "id");
		return this;
	}

	public UpdateLogCriteria andTitleIsNull() {
		addCriterion("title is null");
		return this;
	}

	public UpdateLogCriteria andTitleIsNotNull() {
		addCriterion("title is not null");
		return this;
	}

	public UpdateLogCriteria andTitleEqualTo(String value) {
		addCriterion("title =", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleNotEqualTo(String value) {
		addCriterion("title <>", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleGreaterThan(String value) {
		addCriterion("title >", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleGreaterThanOrEqualTo(String value) {
		addCriterion("title >=", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleLessThan(String value) {
		addCriterion("title <", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleLessThanOrEqualTo(String value) {
		addCriterion("title <=", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleLike(String value) {
		addCriterion("title like", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleNotLike(String value) {
		addCriterion("title not like", value, "title");
		return this;
	}

	public UpdateLogCriteria andTitleIn(List<String> values) {
		addCriterion("title in", values, "title");
		return this;
	}

	public UpdateLogCriteria andTitleNotIn(List<String> values) {
		addCriterion("title not in", values, "title");
		return this;
	}

	public UpdateLogCriteria andTitleBetween(String value1, String value2) {
		addCriterion("title between", value1, value2, "title");
		return this;
	}

	public UpdateLogCriteria andTitleNotBetween(String value1, String value2) {
		addCriterion("title not between", value1, value2, "title");
		return this;
	}

	public UpdateLogCriteria andContentIsNull() {
		addCriterion("content is null");
		return this;
	}

	public UpdateLogCriteria andContentIsNotNull() {
		addCriterion("content is not null");
		return this;
	}

	public UpdateLogCriteria andContentEqualTo(String value) {
		addCriterion("content =", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentNotEqualTo(String value) {
		addCriterion("content <>", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentGreaterThan(String value) {
		addCriterion("content >", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentGreaterThanOrEqualTo(String value) {
		addCriterion("content >=", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentLessThan(String value) {
		addCriterion("content <", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentLessThanOrEqualTo(String value) {
		addCriterion("content <=", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentLike(String value) {
		addCriterion("content like", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentNotLike(String value) {
		addCriterion("content not like", value, "content");
		return this;
	}

	public UpdateLogCriteria andContentIn(List<String> values) {
		addCriterion("content in", values, "content");
		return this;
	}

	public UpdateLogCriteria andContentNotIn(List<String> values) {
		addCriterion("content not in", values, "content");
		return this;
	}

	public UpdateLogCriteria andContentBetween(String value1, String value2) {
		addCriterion("content between", value1, value2, "content");
		return this;
	}

	public UpdateLogCriteria andContentNotBetween(String value1, String value2) {
		addCriterion("content not between", value1, value2, "content");
		return this;
	}

	public UpdateLogCriteria andCreatetimeIsNull() {
		addCriterion("createtime is null");
		return this;
	}

	public UpdateLogCriteria andCreatetimeIsNotNull() {
		addCriterion("createtime is not null");
		return this;
	}

	public UpdateLogCriteria andCreatetimeEqualTo(Date value) {
		addCriterion("createtime =", value, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeNotEqualTo(Date value) {
		addCriterion("createtime <>", value, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeGreaterThan(Date value) {
		addCriterion("createtime >", value, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeGreaterThanOrEqualTo(Date value) {
		addCriterion("createtime >=", value, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeLessThan(Date value) {
		addCriterion("createtime <", value, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeLessThanOrEqualTo(Date value) {
		addCriterion("createtime <=", value, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeIn(List<Date> values) {
		addCriterion("createtime in", values, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeNotIn(List<Date> values) {
		addCriterion("createtime not in", values, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeBetween(Date value1, Date value2) {
		addCriterion("createtime between", value1, value2, "createtime");
		return this;
	}

	public UpdateLogCriteria andCreatetimeNotBetween(Date value1, Date value2) {
		addCriterion("createtime not between", value1, value2, "createtime");
		return this;
	}

	public UpdateLogCriteria andSysuserIdIsNull() {
		addCriterion("sysuser_id is null");
		return this;
	}

	public UpdateLogCriteria andSysuserIdIsNotNull() {
		addCriterion("sysuser_id is not null");
		return this;
	}

	public UpdateLogCriteria andSysuserIdEqualTo(int value) {
		addCriterion("sysuser_id =", new Integer(value), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdNotEqualTo(int value) {
		addCriterion("sysuser_id <>", new Integer(value), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdGreaterThan(int value) {
		addCriterion("sysuser_id >", new Integer(value), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdGreaterThanOrEqualTo(int value) {
		addCriterion("sysuser_id >=", new Integer(value), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdLessThan(int value) {
		addCriterion("sysuser_id <", new Integer(value), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdLessThanOrEqualTo(int value) {
		addCriterion("sysuser_id <=", new Integer(value), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdIn(List<Integer> values) {
		addCriterion("sysuser_id in", values, "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdNotIn(List<Integer> values) {
		addCriterion("sysuser_id not in", values, "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdBetween(int value1, int value2) {
		addCriterion("sysuser_id between", new Integer(value1), new Integer(value2), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andSysuserIdNotBetween(int value1, int value2) {
		addCriterion("sysuser_id not between", new Integer(value1), new Integer(value2), "sysuserId");
		return this;
	}

	public UpdateLogCriteria andStatusIsNull() {
		addCriterion("status is null");
		return this;
	}

	public UpdateLogCriteria andStatusIsNotNull() {
		addCriterion("status is not null");
		return this;
	}

	public UpdateLogCriteria andStatusEqualTo(int value) {
		addCriterion("status =", new Integer(value), "status");
		return this;
	}

	public UpdateLogCriteria andStatusNotEqualTo(int value) {
		addCriterion("status <>", new Integer(value), "status");
		return this;
	}

	public UpdateLogCriteria andStatusGreaterThan(int value) {
		addCriterion("status >", new Integer(value), "status");
		return this;
	}

	public UpdateLogCriteria andStatusGreaterThanOrEqualTo(int value) {
		addCriterion("status >=", new Integer(value), "status");
		return this;
	}

	public UpdateLogCriteria andStatusLessThan(int value) {
		addCriterion("status <", new Integer(value), "status");
		return this;
	}

	public UpdateLogCriteria andStatusLessThanOrEqualTo(int value) {
		addCriterion("status <=", new Integer(value), "status");
		return this;
	}

	public UpdateLogCriteria andStatusIn(List<Integer> values) {
		addCriterion("status in", values, "status");
		return this;
	}

	public UpdateLogCriteria andStatusNotIn(List<Integer> values) {
		addCriterion("status not in", values, "status");
		return this;
	}

	public UpdateLogCriteria andStatusBetween(int value1, int value2) {
		addCriterion("status between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public UpdateLogCriteria andStatusNotBetween(int value1, int value2) {
		addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public UpdateLogCriteria andRemarkIsNull() {
		addCriterion("remark is null");
		return this;
	}

	public UpdateLogCriteria andRemarkIsNotNull() {
		addCriterion("remark is not null");
		return this;
	}

	public UpdateLogCriteria andRemarkEqualTo(String value) {
		addCriterion("remark =", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkNotEqualTo(String value) {
		addCriterion("remark <>", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkGreaterThan(String value) {
		addCriterion("remark >", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkGreaterThanOrEqualTo(String value) {
		addCriterion("remark >=", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkLessThan(String value) {
		addCriterion("remark <", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkLessThanOrEqualTo(String value) {
		addCriterion("remark <=", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkLike(String value) {
		addCriterion("remark like", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkNotLike(String value) {
		addCriterion("remark not like", value, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkIn(List<String> values) {
		addCriterion("remark in", values, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkNotIn(List<String> values) {
		addCriterion("remark not in", values, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkBetween(String value1, String value2) {
		addCriterion("remark between", value1, value2, "remark");
		return this;
	}

	public UpdateLogCriteria andRemarkNotBetween(String value1, String value2) {
		addCriterion("remark not between", value1, value2, "remark");
		return this;
	}
}