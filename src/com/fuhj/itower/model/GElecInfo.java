package com.fuhj.itower.model;

import java.util.Date;

public class GElecInfo extends BaseModel {
    private int gelecInfoId;

    public static final String GELEC_INFO_ID = "gelec_info_id";

    private String gCode;

    public static final String G_CODE = "g_code";

    private String province;

    public static final String PROVINCE = "province";

    private String city;

    public static final String CITY = "city";

    private String district;

    public static final String DISTRICT = "district";

    private String itProvinceId;

    public static final String IT_PROVINCE_ID = "it_province_id";

    private String itCityId;

    public static final String IT_CITY_ID = "it_city_id";

    private String itDistrictId;

    public static final String IT_DISTRICT_ID = "it_district_id";

    private int itBillId;

    public static final String IT_BILL_ID = "it_bill_id";

    private String billCode;

    public static final String BILL_CODE = "bill_code";

    private String faultSource;

    public static final String FAULT_SOURCE = "fault_source";

    private String alarmDetail;

    public static final String ALARM_DETAIL = "alarm_detail";

    private String stationName;

    public static final String STATION_NAME = "station_name";

    private String stationCode;

    public static final String STATION_CODE = "station_code";

    private String stationSysCode;

    public static final String STATION_SYS_CODE = "station_SYS_Code";

    private String operator;

    public static final String OPERATOR = "operator";

    private String operCode;

    public static final String OPER_CODE = "oper_code";

    private Date startTime;

    public static final String START_TIME = "start_time";

    private Date endTime;

    public static final String END_TIME = "end_time";

    private String duration;

    public static final String DURATION = "duration";

    private String odometer;

    public static final String ODOMETER = "odometer";

    private String petrolPrice;

    public static final String PETROL_PRICE = "petrol_price";

    private int machineCount;

    public static final String MACHINE_COUNT = "machine_count";

    private String areaType;

    public static final String AREA_TYPE = "area_type";

    private String dataOrigin;

    public static final String DATA_ORIGIN = "data_origin";

    private String reason;

    public static final String REASON = "reason";

    private String machinePower;

    public static final String MACHINE_POWER = "machine_power";

    private String machineType;

    public static final String MACHINE_TYPE = "machine_type";

    private String machineNo;

    public static final String MACHINE_NO = "machine_NO";

    private String person;

    public static final String PERSON = "person";

    private String contact;

    public static final String CONTACT = "contact";

    private String startVoltage;

    public static final String START_VOLTAGE = "start_voltage";

    private double startLng;

    public static final String START_LNG = "start_lng";

    private double startLat;

    public static final String START_LAT = "start_lat";

    private String startAddr;

    public static final String START_ADDR = "start_addr";

    private String endVoltage;

    public static final String END_VOLTAGE = "end_voltage";

    private double endLng;

    public static final String END_LNG = "end_lng";

    private double endLat;

    public static final String END_LAT = "end_lat";

    private String endAddr;

    public static final String END_ADDR = "end_addr";

    private String pic1;

    public static final String PIC1 = "pic1";

    private String pic2;

    public static final String PIC2 = "pic2";

    private Date createTime;

    public static final String CREATE_TIME = "create_time";

    private Date updateTime;

    public static final String UPDATE_TIME = "update_time";

    private int creatorId;

    public static final String CREATOR_ID = "creator_id";

    private int creatorAgentId;

    public static final String CREATOR_AGENT_ID = "creator_agent_id";

    private int status;

    public static final String STATUS = "status";

    private String remark;

    public static final String REMARK = "remark";

    public int getGelecInfoId() {
        return gelecInfoId;
    }

    public void setGelecInfoId(int gelecInfoId) {
        this.gelecInfoId = gelecInfoId;
    }

    public String getgCode() {
        return gCode;
    }

    public void setgCode(String gCode) {
        this.gCode = gCode == null ? null : gCode.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
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

    public int getItBillId() {
        return itBillId;
    }

    public void setItBillId(int itBillId) {
        this.itBillId = itBillId;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    public String getFaultSource() {
        return faultSource;
    }

    public void setFaultSource(String faultSource) {
        this.faultSource = faultSource == null ? null : faultSource.trim();
    }

    public String getAlarmDetail() {
        return alarmDetail;
    }

    public void setAlarmDetail(String alarmDetail) {
        this.alarmDetail = alarmDetail == null ? null : alarmDetail.trim();
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode == null ? null : operCode.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer == null ? null : odometer.trim();
    }

    public String getPetrolPrice() {
        return petrolPrice;
    }

    public void setPetrolPrice(String petrolPrice) {
        this.petrolPrice = petrolPrice == null ? null : petrolPrice.trim();
    }

    public int getMachineCount() {
        return machineCount;
    }

    public void setMachineCount(int machineCount) {
        this.machineCount = machineCount;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType == null ? null : areaType.trim();
    }

    public String getDataOrigin() {
        return dataOrigin;
    }

    public void setDataOrigin(String dataOrigin) {
        this.dataOrigin = dataOrigin == null ? null : dataOrigin.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(String machinePower) {
        this.machinePower = machinePower == null ? null : machinePower.trim();
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType == null ? null : machineType.trim();
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo == null ? null : machineNo.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getStartVoltage() {
        return startVoltage;
    }

    public void setStartVoltage(String startVoltage) {
        this.startVoltage = startVoltage == null ? null : startVoltage.trim();
    }

    public double getStartLng() {
        return startLng;
    }

    public void setStartLng(double startLng) {
        this.startLng = startLng;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public String getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(String startAddr) {
        this.startAddr = startAddr == null ? null : startAddr.trim();
    }

    public String getEndVoltage() {
        return endVoltage;
    }

    public void setEndVoltage(String endVoltage) {
        this.endVoltage = endVoltage == null ? null : endVoltage.trim();
    }

    public double getEndLng() {
        return endLng;
    }

    public void setEndLng(double endLng) {
        this.endLng = endLng;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public String getEndAddr() {
        return endAddr;
    }

    public void setEndAddr(String endAddr) {
        this.endAddr = endAddr == null ? null : endAddr.trim();
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1 == null ? null : pic1.trim();
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2 == null ? null : pic2.trim();
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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getCreatorAgentId() {
        return creatorAgentId;
    }

    public void setCreatorAgentId(int creatorAgentId) {
        this.creatorAgentId = creatorAgentId;
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