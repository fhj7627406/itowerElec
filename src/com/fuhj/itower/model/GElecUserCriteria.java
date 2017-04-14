package com.fuhj.itower.model;

import java.util.Date;
import java.util.List;

import com.fuhj.itower.dao.Criteria;

public class GElecUserCriteria extends Criteria {

	public GElecUserCriteria andGelecUserIdIsNull() {
		addCriterion("gelec_user_id is null");
		return this;
	}

	public GElecUserCriteria andGelecUserIdIsNotNull() {
		addCriterion("gelec_user_id is not null");
		return this;
	}

	public GElecUserCriteria andGelecUserIdEqualTo(int value) {
		addCriterion("gelec_user_id =", new Integer(value), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdNotEqualTo(int value) {
		addCriterion("gelec_user_id <>", new Integer(value), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdGreaterThan(int value) {
		addCriterion("gelec_user_id >", new Integer(value), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdGreaterThanOrEqualTo(int value) {
		addCriterion("gelec_user_id >=", new Integer(value), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdLessThan(int value) {
		addCriterion("gelec_user_id <", new Integer(value), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdLessThanOrEqualTo(int value) {
		addCriterion("gelec_user_id <=", new Integer(value), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdIn(List<Integer> values) {
		addCriterion("gelec_user_id in", values, "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdNotIn(List<Integer> values) {
		addCriterion("gelec_user_id not in", values, "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdBetween(int value1, int value2) {
		addCriterion("gelec_user_id between", new Integer(value1), new Integer(value2), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andGelecUserIdNotBetween(int value1, int value2) {
		addCriterion("gelec_user_id not between", new Integer(value1), new Integer(value2), "gelecUserId");
		return this;
	}

	public GElecUserCriteria andLoginNameIsNull() {
		addCriterion("login_name is null");
		return this;
	}

	public GElecUserCriteria andLoginNameIsNotNull() {
		addCriterion("login_name is not null");
		return this;
	}

	public GElecUserCriteria andLoginNameEqualTo(String value) {
		addCriterion("login_name =", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameNotEqualTo(String value) {
		addCriterion("login_name <>", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameGreaterThan(String value) {
		addCriterion("login_name >", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameGreaterThanOrEqualTo(String value) {
		addCriterion("login_name >=", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameLessThan(String value) {
		addCriterion("login_name <", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameLessThanOrEqualTo(String value) {
		addCriterion("login_name <=", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameLike(String value) {
		addCriterion("login_name like", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameNotLike(String value) {
		addCriterion("login_name not like", value, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameIn(List<String> values) {
		addCriterion("login_name in", values, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameNotIn(List<String> values) {
		addCriterion("login_name not in", values, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameBetween(String value1, String value2) {
		addCriterion("login_name between", value1, value2, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginNameNotBetween(String value1, String value2) {
		addCriterion("login_name not between", value1, value2, "loginName");
		return this;
	}

	public GElecUserCriteria andLoginPwdIsNull() {
		addCriterion("login_pwd is null");
		return this;
	}

	public GElecUserCriteria andLoginPwdIsNotNull() {
		addCriterion("login_pwd is not null");
		return this;
	}

	public GElecUserCriteria andLoginPwdEqualTo(String value) {
		addCriterion("login_pwd =", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdNotEqualTo(String value) {
		addCriterion("login_pwd <>", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdGreaterThan(String value) {
		addCriterion("login_pwd >", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdGreaterThanOrEqualTo(String value) {
		addCriterion("login_pwd >=", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdLessThan(String value) {
		addCriterion("login_pwd <", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdLessThanOrEqualTo(String value) {
		addCriterion("login_pwd <=", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdLike(String value) {
		addCriterion("login_pwd like", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdNotLike(String value) {
		addCriterion("login_pwd not like", value, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdIn(List<String> values) {
		addCriterion("login_pwd in", values, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdNotIn(List<String> values) {
		addCriterion("login_pwd not in", values, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdBetween(String value1, String value2) {
		addCriterion("login_pwd between", value1, value2, "loginPwd");
		return this;
	}

	public GElecUserCriteria andLoginPwdNotBetween(String value1, String value2) {
		addCriterion("login_pwd not between", value1, value2, "loginPwd");
		return this;
	}

	public GElecUserCriteria andUserNameIsNull() {
		addCriterion("user_name is null");
		return this;
	}

	public GElecUserCriteria andUserNameIsNotNull() {
		addCriterion("user_name is not null");
		return this;
	}

	public GElecUserCriteria andUserNameEqualTo(String value) {
		addCriterion("user_name =", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameNotEqualTo(String value) {
		addCriterion("user_name <>", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameGreaterThan(String value) {
		addCriterion("user_name >", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameGreaterThanOrEqualTo(String value) {
		addCriterion("user_name >=", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameLessThan(String value) {
		addCriterion("user_name <", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameLessThanOrEqualTo(String value) {
		addCriterion("user_name <=", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameLike(String value) {
		addCriterion("user_name like", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameNotLike(String value) {
		addCriterion("user_name not like", value, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameIn(List<String> values) {
		addCriterion("user_name in", values, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameNotIn(List<String> values) {
		addCriterion("user_name not in", values, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameBetween(String value1, String value2) {
		addCriterion("user_name between", value1, value2, "userName");
		return this;
	}

	public GElecUserCriteria andUserNameNotBetween(String value1, String value2) {
		addCriterion("user_name not between", value1, value2, "userName");
		return this;
	}

	public GElecUserCriteria andUserPhoneIsNull() {
		addCriterion("user_phone is null");
		return this;
	}

	public GElecUserCriteria andUserPhoneIsNotNull() {
		addCriterion("user_phone is not null");
		return this;
	}

	public GElecUserCriteria andUserPhoneEqualTo(String value) {
		addCriterion("user_phone =", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneNotEqualTo(String value) {
		addCriterion("user_phone <>", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneGreaterThan(String value) {
		addCriterion("user_phone >", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneGreaterThanOrEqualTo(String value) {
		addCriterion("user_phone >=", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneLessThan(String value) {
		addCriterion("user_phone <", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneLessThanOrEqualTo(String value) {
		addCriterion("user_phone <=", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneLike(String value) {
		addCriterion("user_phone like", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneNotLike(String value) {
		addCriterion("user_phone not like", value, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneIn(List<String> values) {
		addCriterion("user_phone in", values, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneNotIn(List<String> values) {
		addCriterion("user_phone not in", values, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneBetween(String value1, String value2) {
		addCriterion("user_phone between", value1, value2, "userPhone");
		return this;
	}

	public GElecUserCriteria andUserPhoneNotBetween(String value1, String value2) {
		addCriterion("user_phone not between", value1, value2, "userPhone");
		return this;
	}

	public GElecUserCriteria andItProvinceIdIsNull() {
		addCriterion("it_province_id is null");
		return this;
	}

	public GElecUserCriteria andItProvinceIdIsNotNull() {
		addCriterion("it_province_id is not null");
		return this;
	}

	public GElecUserCriteria andItProvinceIdEqualTo(String value) {
		addCriterion("it_province_id =", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdNotEqualTo(String value) {
		addCriterion("it_province_id <>", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdGreaterThan(String value) {
		addCriterion("it_province_id >", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_province_id >=", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdLessThan(String value) {
		addCriterion("it_province_id <", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdLessThanOrEqualTo(String value) {
		addCriterion("it_province_id <=", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdLike(String value) {
		addCriterion("it_province_id like", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdNotLike(String value) {
		addCriterion("it_province_id not like", value, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdIn(List<String> values) {
		addCriterion("it_province_id in", values, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdNotIn(List<String> values) {
		addCriterion("it_province_id not in", values, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdBetween(String value1, String value2) {
		addCriterion("it_province_id between", value1, value2, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItProvinceIdNotBetween(String value1, String value2) {
		addCriterion("it_province_id not between", value1, value2, "itProvinceId");
		return this;
	}

	public GElecUserCriteria andItCityIdIsNull() {
		addCriterion("it_city_id is null");
		return this;
	}

	public GElecUserCriteria andItCityIdIsNotNull() {
		addCriterion("it_city_id is not null");
		return this;
	}

	public GElecUserCriteria andItCityIdEqualTo(String value) {
		addCriterion("it_city_id =", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdNotEqualTo(String value) {
		addCriterion("it_city_id <>", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdGreaterThan(String value) {
		addCriterion("it_city_id >", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_city_id >=", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdLessThan(String value) {
		addCriterion("it_city_id <", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdLessThanOrEqualTo(String value) {
		addCriterion("it_city_id <=", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdLike(String value) {
		addCriterion("it_city_id like", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdNotLike(String value) {
		addCriterion("it_city_id not like", value, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdIn(List<String> values) {
		addCriterion("it_city_id in", values, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdNotIn(List<String> values) {
		addCriterion("it_city_id not in", values, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdBetween(String value1, String value2) {
		addCriterion("it_city_id between", value1, value2, "itCityId");
		return this;
	}

	public GElecUserCriteria andItCityIdNotBetween(String value1, String value2) {
		addCriterion("it_city_id not between", value1, value2, "itCityId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdIsNull() {
		addCriterion("it_district_id is null");
		return this;
	}

	public GElecUserCriteria andItDistrictIdIsNotNull() {
		addCriterion("it_district_id is not null");
		return this;
	}

	public GElecUserCriteria andItDistrictIdEqualTo(String value) {
		addCriterion("it_district_id =", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdNotEqualTo(String value) {
		addCriterion("it_district_id <>", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdGreaterThan(String value) {
		addCriterion("it_district_id >", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdGreaterThanOrEqualTo(String value) {
		addCriterion("it_district_id >=", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdLessThan(String value) {
		addCriterion("it_district_id <", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdLessThanOrEqualTo(String value) {
		addCriterion("it_district_id <=", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdLike(String value) {
		addCriterion("it_district_id like", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdNotLike(String value) {
		addCriterion("it_district_id not like", value, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdIn(List<String> values) {
		addCriterion("it_district_id in", values, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdNotIn(List<String> values) {
		addCriterion("it_district_id not in", values, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdBetween(String value1, String value2) {
		addCriterion("it_district_id between", value1, value2, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andItDistrictIdNotBetween(String value1, String value2) {
		addCriterion("it_district_id not between", value1, value2, "itDistrictId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdIsNull() {
		addCriterion("wx_open_id is null");
		return this;
	}

	public GElecUserCriteria andWxOpenIdIsNotNull() {
		addCriterion("wx_open_id is not null");
		return this;
	}

	public GElecUserCriteria andWxOpenIdEqualTo(String value) {
		addCriterion("wx_open_id =", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdNotEqualTo(String value) {
		addCriterion("wx_open_id <>", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdGreaterThan(String value) {
		addCriterion("wx_open_id >", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdGreaterThanOrEqualTo(String value) {
		addCriterion("wx_open_id >=", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdLessThan(String value) {
		addCriterion("wx_open_id <", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdLessThanOrEqualTo(String value) {
		addCriterion("wx_open_id <=", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdLike(String value) {
		addCriterion("wx_open_id like", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdNotLike(String value) {
		addCriterion("wx_open_id not like", value, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdIn(List<String> values) {
		addCriterion("wx_open_id in", values, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdNotIn(List<String> values) {
		addCriterion("wx_open_id not in", values, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdBetween(String value1, String value2) {
		addCriterion("wx_open_id between", value1, value2, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andWxOpenIdNotBetween(String value1, String value2) {
		addCriterion("wx_open_id not between", value1, value2, "wxOpenId");
		return this;
	}

	public GElecUserCriteria andUserTypeIsNull() {
		addCriterion("user_type is null");
		return this;
	}

	public GElecUserCriteria andUserTypeIsNotNull() {
		addCriterion("user_type is not null");
		return this;
	}

	public GElecUserCriteria andUserTypeEqualTo(int value) {
		addCriterion("user_type =", new Integer(value), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeNotEqualTo(int value) {
		addCriterion("user_type <>", new Integer(value), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeGreaterThan(int value) {
		addCriterion("user_type >", new Integer(value), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeGreaterThanOrEqualTo(int value) {
		addCriterion("user_type >=", new Integer(value), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeLessThan(int value) {
		addCriterion("user_type <", new Integer(value), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeLessThanOrEqualTo(int value) {
		addCriterion("user_type <=", new Integer(value), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeIn(List<Integer> values) {
		addCriterion("user_type in", values, "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeNotIn(List<Integer> values) {
		addCriterion("user_type not in", values, "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeBetween(int value1, int value2) {
		addCriterion("user_type between", new Integer(value1), new Integer(value2), "userType");
		return this;
	}

	public GElecUserCriteria andUserTypeNotBetween(int value1, int value2) {
		addCriterion("user_type not between", new Integer(value1), new Integer(value2), "userType");
		return this;
	}

	public GElecUserCriteria andUserLevelIsNull() {
		addCriterion("user_level is null");
		return this;
	}

	public GElecUserCriteria andUserLevelIsNotNull() {
		addCriterion("user_level is not null");
		return this;
	}

	public GElecUserCriteria andUserLevelEqualTo(int value) {
		addCriterion("user_level =", new Integer(value), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelNotEqualTo(int value) {
		addCriterion("user_level <>", new Integer(value), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelGreaterThan(int value) {
		addCriterion("user_level >", new Integer(value), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelGreaterThanOrEqualTo(int value) {
		addCriterion("user_level >=", new Integer(value), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelLessThan(int value) {
		addCriterion("user_level <", new Integer(value), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelLessThanOrEqualTo(int value) {
		addCriterion("user_level <=", new Integer(value), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelIn(List<Integer> values) {
		addCriterion("user_level in", values, "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelNotIn(List<Integer> values) {
		addCriterion("user_level not in", values, "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelBetween(int value1, int value2) {
		addCriterion("user_level between", new Integer(value1), new Integer(value2), "userLevel");
		return this;
	}

	public GElecUserCriteria andUserLevelNotBetween(int value1, int value2) {
		addCriterion("user_level not between", new Integer(value1), new Integer(value2), "userLevel");
		return this;
	}

	public GElecUserCriteria andRegTimeIsNull() {
		addCriterion("reg_time is null");
		return this;
	}

	public GElecUserCriteria andRegTimeIsNotNull() {
		addCriterion("reg_time is not null");
		return this;
	}

	public GElecUserCriteria andRegTimeEqualTo(Date value) {
		addCriterion("reg_time =", value, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeNotEqualTo(Date value) {
		addCriterion("reg_time <>", value, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeGreaterThan(Date value) {
		addCriterion("reg_time >", value, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeGreaterThanOrEqualTo(Date value) {
		addCriterion("reg_time >=", value, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeLessThan(Date value) {
		addCriterion("reg_time <", value, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeLessThanOrEqualTo(Date value) {
		addCriterion("reg_time <=", value, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeIn(List<Date> values) {
		addCriterion("reg_time in", values, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeNotIn(List<Date> values) {
		addCriterion("reg_time not in", values, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeBetween(Date value1, Date value2) {
		addCriterion("reg_time between", value1, value2, "regTime");
		return this;
	}

	public GElecUserCriteria andRegTimeNotBetween(Date value1, Date value2) {
		addCriterion("reg_time not between", value1, value2, "regTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeIsNull() {
		addCriterion("last_login_time is null");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeIsNotNull() {
		addCriterion("last_login_time is not null");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeEqualTo(Date value) {
		addCriterion("last_login_time =", value, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeNotEqualTo(Date value) {
		addCriterion("last_login_time <>", value, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeGreaterThan(Date value) {
		addCriterion("last_login_time >", value, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
		addCriterion("last_login_time >=", value, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeLessThan(Date value) {
		addCriterion("last_login_time <", value, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeLessThanOrEqualTo(Date value) {
		addCriterion("last_login_time <=", value, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeIn(List<Date> values) {
		addCriterion("last_login_time in", values, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeNotIn(List<Date> values) {
		addCriterion("last_login_time not in", values, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeBetween(Date value1, Date value2) {
		addCriterion("last_login_time between", value1, value2, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andLastLoginTimeNotBetween(Date value1, Date value2) {
		addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
		return this;
	}

	public GElecUserCriteria andStatusIsNull() {
		addCriterion("status is null");
		return this;
	}

	public GElecUserCriteria andStatusIsNotNull() {
		addCriterion("status is not null");
		return this;
	}

	public GElecUserCriteria andStatusEqualTo(int value) {
		addCriterion("status =", new Integer(value), "status");
		return this;
	}

	public GElecUserCriteria andStatusNotEqualTo(int value) {
		addCriterion("status <>", new Integer(value), "status");
		return this;
	}

	public GElecUserCriteria andStatusGreaterThan(int value) {
		addCriterion("status >", new Integer(value), "status");
		return this;
	}

	public GElecUserCriteria andStatusGreaterThanOrEqualTo(int value) {
		addCriterion("status >=", new Integer(value), "status");
		return this;
	}

	public GElecUserCriteria andStatusLessThan(int value) {
		addCriterion("status <", new Integer(value), "status");
		return this;
	}

	public GElecUserCriteria andStatusLessThanOrEqualTo(int value) {
		addCriterion("status <=", new Integer(value), "status");
		return this;
	}

	public GElecUserCriteria andStatusIn(List<Integer> values) {
		addCriterion("status in", values, "status");
		return this;
	}

	public GElecUserCriteria andStatusNotIn(List<Integer> values) {
		addCriterion("status not in", values, "status");
		return this;
	}

	public GElecUserCriteria andStatusBetween(int value1, int value2) {
		addCriterion("status between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public GElecUserCriteria andStatusNotBetween(int value1, int value2) {
		addCriterion("status not between", new Integer(value1), new Integer(value2), "status");
		return this;
	}

	public GElecUserCriteria andRemarkIsNull() {
		addCriterion("remark is null");
		return this;
	}

	public GElecUserCriteria andRemarkIsNotNull() {
		addCriterion("remark is not null");
		return this;
	}

	public GElecUserCriteria andRemarkEqualTo(String value) {
		addCriterion("remark =", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkNotEqualTo(String value) {
		addCriterion("remark <>", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkGreaterThan(String value) {
		addCriterion("remark >", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkGreaterThanOrEqualTo(String value) {
		addCriterion("remark >=", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkLessThan(String value) {
		addCriterion("remark <", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkLessThanOrEqualTo(String value) {
		addCriterion("remark <=", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkLike(String value) {
		addCriterion("remark like", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkNotLike(String value) {
		addCriterion("remark not like", value, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkIn(List<String> values) {
		addCriterion("remark in", values, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkNotIn(List<String> values) {
		addCriterion("remark not in", values, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkBetween(String value1, String value2) {
		addCriterion("remark between", value1, value2, "remark");
		return this;
	}

	public GElecUserCriteria andRemarkNotBetween(String value1, String value2) {
		addCriterion("remark not between", value1, value2, "remark");
		return this;
	}
}