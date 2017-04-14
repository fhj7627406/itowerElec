package com.fuhj.itower.model;

import java.util.Date;

public class GElecUser extends BaseModel {
    private int gelecUserId;

    public static final String GELEC_USER_ID = "gelec_user_id";

    private String loginName;

    public static final String LOGIN_NAME = "login_name";

    private String loginPwd;

    public static final String LOGIN_PWD = "login_pwd";

    private String userName;

    public static final String USER_NAME = "user_name";

    private String userPhone;

    public static final String USER_PHONE = "user_phone";

    private String itProvinceId;

    public static final String IT_PROVINCE_ID = "it_province_id";

    private String itCityId;

    public static final String IT_CITY_ID = "it_city_id";

    private String itDistrictId;

    public static final String IT_DISTRICT_ID = "it_district_id";

    private String wxOpenId;

    public static final String WX_OPEN_ID = "wx_open_id";

    private int userType;

    public static final String USER_TYPE = "user_type";

    private int userLevel;

    public static final String USER_LEVEL = "user_level";

    private Date regTime;

    public static final String REG_TIME = "reg_time";

    private Date lastLoginTime;

    public static final String LAST_LOGIN_TIME = "last_login_time";

    private int status;

    public static final String STATUS = "status";

    private String remark;

    public static final String REMARK = "remark";

    public int getGelecUserId() {
        return gelecUserId;
    }

    public void setGelecUserId(int gelecUserId) {
        this.gelecUserId = gelecUserId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getItProvinceId() {
        return itProvinceId;
    }

    public void setItProvinceId(String itProvinceId) {
        this.itProvinceId = itProvinceId == null ? null : itProvinceId.trim();
    }

    public String getItCityId() {
        return itCityId;
    }

    public void setItCityId(String itCityId) {
        this.itCityId = itCityId == null ? null : itCityId.trim();
    }

    public String getItDistrictId() {
        return itDistrictId;
    }

    public void setItDistrictId(String itDistrictId) {
        this.itDistrictId = itDistrictId == null ? null : itDistrictId.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}