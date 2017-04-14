package com.fuhj.itower.model;

import java.util.Date;

public class ItStation extends BaseModel {
    private int itStationId;

    public static final String IT_STATION_ID = "it_station_id";

    private String itProvinceId;

    public static final String IT_PROVINCE_ID = "it_province_id";

    private String itCityId;

    public static final String IT_CITY_ID = "it_city_id";

    private String itDistrictId;

    public static final String IT_DISTRICT_ID = "it_district_id";

    private String stationName;

    public static final String STATION_NAME = "station_name";

    private String stationCode;

    public static final String STATION_CODE = "station_code";

    private String stationSysCode;

    public static final String STATION_SYS_CODE = "station_sys_code";

    private String lng;

    public static final String LNG = "lng";

    private String lat;

    public static final String LAT = "lat";

    private String address;

    public static final String ADDRESS = "address";

    private int originId;

    public static final String ORIGIN_ID = "origin_id";

    private int operator;

    public static final String OPERATOR = "operator";

    private int sceneId;

    public static final String SCENE_ID = "scene_id";

    private String aliasCm;

    public static final String ALIAS_CM = "alias_cm";

    private String aliasCu;

    public static final String ALIAS_CU = "alias_cu";

    private String aliasCt;

    public static final String ALIAS_CT = "alias_ct";

    private int stationTypeId;

    public static final String STATION_TYPE_ID = "station_type_id";

    private String areaManager;

    public static final String AREA_MANAGER = "area_manager";

    private String areaManagerPhone;

    public static final String AREA_MANAGER_PHONE = "area_manager_phone";

    private String fsuManufactor;

    public static final String FSU_MANUFACTOR = "fsu_manufactor";

    private String maintenanceCorp;

    public static final String MAINTENANCE_CORP = "maintenance_corp";

    private Date acceptanceDate;

    public static final String ACCEPTANCE_DATE = "acceptance_date";

    private String outsideCustomer;

    public static final String OUTSIDE_CUSTOMER = "outside_customer";

    private String remark;

    public static final String REMARK = "remark";

    private int status;

    public static final String STATUS = "status";

    private Date createTime;

    public static final String CREATE_TIME = "create_time";

    private Date updateTime;

    public static final String UPDATE_TIME = "update_time";

    public int getItStationId() {
        return itStationId;
    }

    public void setItStationId(int itStationId) {
        this.itStationId = itStationId;
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

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public String getStationSysCode() {
        return stationSysCode;
    }

    public void setStationSysCode(String stationSysCode) {
        this.stationSysCode = stationSysCode == null ? null : stationSysCode.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getAliasCm() {
        return aliasCm;
    }

    public void setAliasCm(String aliasCm) {
        this.aliasCm = aliasCm == null ? null : aliasCm.trim();
    }

    public String getAliasCu() {
        return aliasCu;
    }

    public void setAliasCu(String aliasCu) {
        this.aliasCu = aliasCu == null ? null : aliasCu.trim();
    }

    public String getAliasCt() {
        return aliasCt;
    }

    public void setAliasCt(String aliasCt) {
        this.aliasCt = aliasCt == null ? null : aliasCt.trim();
    }

    public int getStationTypeId() {
        return stationTypeId;
    }

    public void setStationTypeId(int stationTypeId) {
        this.stationTypeId = stationTypeId;
    }

    public String getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(String areaManager) {
        this.areaManager = areaManager == null ? null : areaManager.trim();
    }

    public String getAreaManagerPhone() {
        return areaManagerPhone;
    }

    public void setAreaManagerPhone(String areaManagerPhone) {
        this.areaManagerPhone = areaManagerPhone == null ? null : areaManagerPhone.trim();
    }

    public String getFsuManufactor() {
        return fsuManufactor;
    }

    public void setFsuManufactor(String fsuManufactor) {
        this.fsuManufactor = fsuManufactor == null ? null : fsuManufactor.trim();
    }

    public String getMaintenanceCorp() {
        return maintenanceCorp;
    }

    public void setMaintenanceCorp(String maintenanceCorp) {
        this.maintenanceCorp = maintenanceCorp == null ? null : maintenanceCorp.trim();
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getOutsideCustomer() {
        return outsideCustomer;
    }

    public void setOutsideCustomer(String outsideCustomer) {
        this.outsideCustomer = outsideCustomer == null ? null : outsideCustomer.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}