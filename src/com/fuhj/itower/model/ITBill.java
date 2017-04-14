package com.fuhj.itower.model;

import java.util.Date;

public class ITBill extends BaseModel {
    private int itBillId;

    public static final String IT_BILL_ID = "it_bill_id";

    private String billCode;

    public static final String BILL_CODE = "bill_code";

    private String billStatus;

    public static final String BILL_STATUS = "bill_status";

    private Date acceptTime;

    public static final String ACCEPT_TIME = "accept_time";

    private Date dispatchTime;

    public static final String DISPATCH_TIME = "dispatch_time";

    private Date receiveTime;

    public static final String RECEIVE_TIME = "receive_time";

    private Date alarmTime;

    public static final String ALARM_TIME = "alarm_time";

    private String timeLimit;

    public static final String TIME_LIMIT = "time_limit";

    private Date receiptTime;

    public static final String RECEIPT_TIME = "receipt_time";

    private Date filedTime;

    public static final String FILED_TIME = "filed_time";

    private String faultSource;

    public static final String FAULT_SOURCE = "fault_source";

    private String alarmName;

    public static final String ALARM_NAME = "alarm_name";

    private String alarmStatus;

    public static final String ALARM_STATUS = "alarm_status";

    private String alarmDetail;

    public static final String ALARM_DETAIL = "alarm_detail";

    private String alarmLevel;

    public static final String ALARM_LEVEL = "alarm_level";

    private String stationCode;

    public static final String STATION_CODE = "station_code";

    private String stationName;

    public static final String STATION_NAME = "station_name";

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

    private String goStation;

    public static final String GO_STATION = "go_station";

    private String faultReason;

    public static final String FAULT_REASON = "fault_reason";

    private String immunity;

    public static final String IMMUNITY = "immunity";

    private String disclaimer;

    public static final String DISCLAIMER = "disclaimer";

    private String immunityReason;

    public static final String IMMUNITY_REASON = "immunity_reason";

    private Date alarmClearTime;

    public static final String ALARM_CLEAR_TIME = "alarm_clear_time";

    private String alarmReplyContent;

    public static final String ALARM_REPLY_CONTENT = "alarm_reply_content";

    private String faultDeviceType;

    public static final String FAULT_DEVICE_TYPE = "fault_device_type";

    private String hasPressed;

    public static final String HAS_PRESSED = "has_pressed";

    private String isReceiptTimeout;

    public static final String IS_RECEIPT_TIMEOUT = "is_receipt_timeout";

    private String receiptPerson;

    public static final String RECEIPT_PERSON = "receipt_person";

    private String agentsCorp;

    public static final String AGENTS_CORP = "agents_corp";

    private String billProcess;

    public static final String BILL_PROCESS = "bill_process";

    private String machineRoomType;

    public static final String MACHINE_ROOM_TYPE = "machine_room_type";

    private String powerSupplyMode;

    public static final String POWER_SUPPLY_MODE = "power_supply_mode";

    private String fsuNetworkCardType;

    public static final String FSU_NETWORK_CARD_TYPE = "fsu_network_card_type";

    private String fsuManufactor;

    public static final String FSU_MANUFACTOR = "fsu_manufactor";

    private String acManufactor;

    public static final String AC_MANUFACTOR = "ac_manufactor";

    private String batteryManufactor;

    public static final String BATTERY_MANUFACTOR = "battery_manufactor";

    private String switchManufactor;

    public static final String SWITCH_MANUFACTOR = "switch_manufactor";

    private String elecConditions;

    public static final String ELEC_CONDITIONS = "elec_conditions";

    private String batteryCount;

    public static final String BATTERY_COUNT = "battery_count";

    private String batteryCapacity;

    public static final String BATTERY_CAPACITY = "battery_capacity";

    private String totalCurrent;

    public static final String TOTAL_CURRENT = "total_current";

    private String batteryGuarantee;

    public static final String BATTERY_GUARANTEE = "battery_guarantee";

    private String alarmDuration;

    public static final String ALARM_DURATION = "alarm_duration";

    private String billDuration;

    public static final String BILL_DURATION = "bill_duration";

    private String billHandler;

    public static final String BILL_HANDLER = "bill_handler";

    private String receiptTerminal;

    public static final String RECEIPT_TERMINAL = "receipt_terminal";

    private String receiveDuration;

    public static final String RECEIVE_DURATION = "receive_duration";

    private Date firstReplyTime;

    public static final String FIRST_REPLY_TIME = "first_reply_time";

    private String isReceiveTimeout;

    public static final String IS_RECEIVE_TIMEOUT = "is_receive_timeout";

    private String operator;

    public static final String OPERATOR = "operator";

    private String faultConfirmContent;

    public static final String FAULT_CONFIRM_CONTENT = "fault_confirm_content";

    private String areaManager;

    public static final String AREA_MANAGER = "area_manager";

    private String dataOrigin;

    public static final String DATA_ORIGIN = "data_origin";

    private String receiveTerminal;

    public static final String RECEIVE_TERMINAL = "receive_terminal";

    private Date signTime;

    public static final String SIGN_TIME = "sign_time";

    private String signLng;

    public static final String SIGN_LNG = "sign_lng";

    private String signLat;

    public static final String SIGN_LAT = "sign_lat";

    private String stationLng;

    public static final String STATION_LNG = "station_lng";

    private String stationLat;

    public static final String STATION_LAT = "station_lat";

    private String isElecGenerBill;

    public static final String IS_ELEC_GENER_BILL = "is_elec_gener_bill";

    private String faultType;

    public static final String FAULT_TYPE = "fault_type";

    private String remark;

    public static final String REMARK = "remark";

    private Date updateTime;

    public static final String UPDATE_TIME = "update_time";

    private Date createTime;

    public static final String CREATE_TIME = "create_time";

    private int status;

    public static final String STATUS = "status";

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

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit == null ? null : timeLimit.trim();
    }

    public Date getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    public Date getFiledTime() {
        return filedTime;
    }

    public void setFiledTime(Date filedTime) {
        this.filedTime = filedTime;
    }

    public String getFaultSource() {
        return faultSource;
    }

    public void setFaultSource(String faultSource) {
        this.faultSource = faultSource == null ? null : faultSource.trim();
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName == null ? null : alarmName.trim();
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus == null ? null : alarmStatus.trim();
    }

    public String getAlarmDetail() {
        return alarmDetail;
    }

    public void setAlarmDetail(String alarmDetail) {
        this.alarmDetail = alarmDetail == null ? null : alarmDetail.trim();
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel == null ? null : alarmLevel.trim();
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
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

    public String getGoStation() {
        return goStation;
    }

    public void setGoStation(String goStation) {
        this.goStation = goStation == null ? null : goStation.trim();
    }

    public String getFaultReason() {
        return faultReason;
    }

    public void setFaultReason(String faultReason) {
        this.faultReason = faultReason == null ? null : faultReason.trim();
    }

    public String getImmunity() {
        return immunity;
    }

    public void setImmunity(String immunity) {
        this.immunity = immunity == null ? null : immunity.trim();
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer == null ? null : disclaimer.trim();
    }

    public String getImmunityReason() {
        return immunityReason;
    }

    public void setImmunityReason(String immunityReason) {
        this.immunityReason = immunityReason == null ? null : immunityReason.trim();
    }

    public Date getAlarmClearTime() {
        return alarmClearTime;
    }

    public void setAlarmClearTime(Date alarmClearTime) {
        this.alarmClearTime = alarmClearTime;
    }

    public String getAlarmReplyContent() {
        return alarmReplyContent;
    }

    public void setAlarmReplyContent(String alarmReplyContent) {
        this.alarmReplyContent = alarmReplyContent == null ? null : alarmReplyContent.trim();
    }

    public String getFaultDeviceType() {
        return faultDeviceType;
    }

    public void setFaultDeviceType(String faultDeviceType) {
        this.faultDeviceType = faultDeviceType == null ? null : faultDeviceType.trim();
    }

    public String getHasPressed() {
        return hasPressed;
    }

    public void setHasPressed(String hasPressed) {
        this.hasPressed = hasPressed == null ? null : hasPressed.trim();
    }

    public String getIsReceiptTimeout() {
        return isReceiptTimeout;
    }

    public void setIsReceiptTimeout(String isReceiptTimeout) {
        this.isReceiptTimeout = isReceiptTimeout == null ? null : isReceiptTimeout.trim();
    }

    public String getReceiptPerson() {
        return receiptPerson;
    }

    public void setReceiptPerson(String receiptPerson) {
        this.receiptPerson = receiptPerson == null ? null : receiptPerson.trim();
    }

    public String getAgentsCorp() {
        return agentsCorp;
    }

    public void setAgentsCorp(String agentsCorp) {
        this.agentsCorp = agentsCorp == null ? null : agentsCorp.trim();
    }

    public String getBillProcess() {
        return billProcess;
    }

    public void setBillProcess(String billProcess) {
        this.billProcess = billProcess == null ? null : billProcess.trim();
    }

    public String getMachineRoomType() {
        return machineRoomType;
    }

    public void setMachineRoomType(String machineRoomType) {
        this.machineRoomType = machineRoomType == null ? null : machineRoomType.trim();
    }

    public String getPowerSupplyMode() {
        return powerSupplyMode;
    }

    public void setPowerSupplyMode(String powerSupplyMode) {
        this.powerSupplyMode = powerSupplyMode == null ? null : powerSupplyMode.trim();
    }

    public String getFsuNetworkCardType() {
        return fsuNetworkCardType;
    }

    public void setFsuNetworkCardType(String fsuNetworkCardType) {
        this.fsuNetworkCardType = fsuNetworkCardType == null ? null : fsuNetworkCardType.trim();
    }

    public String getFsuManufactor() {
        return fsuManufactor;
    }

    public void setFsuManufactor(String fsuManufactor) {
        this.fsuManufactor = fsuManufactor == null ? null : fsuManufactor.trim();
    }

    public String getAcManufactor() {
        return acManufactor;
    }

    public void setAcManufactor(String acManufactor) {
        this.acManufactor = acManufactor == null ? null : acManufactor.trim();
    }

    public String getBatteryManufactor() {
        return batteryManufactor;
    }

    public void setBatteryManufactor(String batteryManufactor) {
        this.batteryManufactor = batteryManufactor == null ? null : batteryManufactor.trim();
    }

    public String getSwitchManufactor() {
        return switchManufactor;
    }

    public void setSwitchManufactor(String switchManufactor) {
        this.switchManufactor = switchManufactor == null ? null : switchManufactor.trim();
    }

    public String getElecConditions() {
        return elecConditions;
    }

    public void setElecConditions(String elecConditions) {
        this.elecConditions = elecConditions == null ? null : elecConditions.trim();
    }

    public String getBatteryCount() {
        return batteryCount;
    }

    public void setBatteryCount(String batteryCount) {
        this.batteryCount = batteryCount == null ? null : batteryCount.trim();
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity == null ? null : batteryCapacity.trim();
    }

    public String getTotalCurrent() {
        return totalCurrent;
    }

    public void setTotalCurrent(String totalCurrent) {
        this.totalCurrent = totalCurrent == null ? null : totalCurrent.trim();
    }

    public String getBatteryGuarantee() {
        return batteryGuarantee;
    }

    public void setBatteryGuarantee(String batteryGuarantee) {
        this.batteryGuarantee = batteryGuarantee == null ? null : batteryGuarantee.trim();
    }

    public String getAlarmDuration() {
        return alarmDuration;
    }

    public void setAlarmDuration(String alarmDuration) {
        this.alarmDuration = alarmDuration == null ? null : alarmDuration.trim();
    }

    public String getBillDuration() {
        return billDuration;
    }

    public void setBillDuration(String billDuration) {
        this.billDuration = billDuration == null ? null : billDuration.trim();
    }

    public String getBillHandler() {
        return billHandler;
    }

    public void setBillHandler(String billHandler) {
        this.billHandler = billHandler == null ? null : billHandler.trim();
    }

    public String getReceiptTerminal() {
        return receiptTerminal;
    }

    public void setReceiptTerminal(String receiptTerminal) {
        this.receiptTerminal = receiptTerminal == null ? null : receiptTerminal.trim();
    }

    public String getReceiveDuration() {
        return receiveDuration;
    }

    public void setReceiveDuration(String receiveDuration) {
        this.receiveDuration = receiveDuration == null ? null : receiveDuration.trim();
    }

    public Date getFirstReplyTime() {
        return firstReplyTime;
    }

    public void setFirstReplyTime(Date firstReplyTime) {
        this.firstReplyTime = firstReplyTime;
    }

    public String getIsReceiveTimeout() {
        return isReceiveTimeout;
    }

    public void setIsReceiveTimeout(String isReceiveTimeout) {
        this.isReceiveTimeout = isReceiveTimeout == null ? null : isReceiveTimeout.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getFaultConfirmContent() {
        return faultConfirmContent;
    }

    public void setFaultConfirmContent(String faultConfirmContent) {
        this.faultConfirmContent = faultConfirmContent == null ? null : faultConfirmContent.trim();
    }

    public String getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(String areaManager) {
        this.areaManager = areaManager == null ? null : areaManager.trim();
    }

    public String getDataOrigin() {
        return dataOrigin;
    }

    public void setDataOrigin(String dataOrigin) {
        this.dataOrigin = dataOrigin == null ? null : dataOrigin.trim();
    }

    public String getReceiveTerminal() {
        return receiveTerminal;
    }

    public void setReceiveTerminal(String receiveTerminal) {
        this.receiveTerminal = receiveTerminal == null ? null : receiveTerminal.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignLng() {
        return signLng;
    }

    public void setSignLng(String signLng) {
        this.signLng = signLng == null ? null : signLng.trim();
    }

    public String getSignLat() {
        return signLat;
    }

    public void setSignLat(String signLat) {
        this.signLat = signLat == null ? null : signLat.trim();
    }

    public String getStationLng() {
        return stationLng;
    }

    public void setStationLng(String stationLng) {
        this.stationLng = stationLng == null ? null : stationLng.trim();
    }

    public String getStationLat() {
        return stationLat;
    }

    public void setStationLat(String stationLat) {
        this.stationLat = stationLat == null ? null : stationLat.trim();
    }

    public String getIsElecGenerBill() {
        return isElecGenerBill;
    }

    public void setIsElecGenerBill(String isElecGenerBill) {
        this.isElecGenerBill = isElecGenerBill == null ? null : isElecGenerBill.trim();
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}