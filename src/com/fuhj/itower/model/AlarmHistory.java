package com.fuhj.itower.model;

import java.util.Date;

public class AlarmHistory extends BaseModel {
    private int alarmHistoryId;

    public static final String ALARM_HISTORY_ID = "alarm_history_id";

    private int logId;

    public static final String LOG_ID = "log_id";

    private String itProvinceId;

    public static final String IT_PROVINCE_ID = "it_province_id";

    private String itCityId;

    public static final String IT_CITY_ID = "it_city_id";

    private String itDistrictId;

    public static final String IT_DISTRICT_ID = "it_district_id";

    private int alarmType;

    public static final String ALARM_TYPE = "alarm_type";

    private String troubleno;

    public static final String TROUBLENO = "troubleNO";

    private String billid;

    public static final String BILLID = "billId";

    private String stationcode;

    public static final String STATIONCODE = "stationCode";

    private String stationname;

    public static final String STATIONNAME = "stationName";

    private Date alarmtime;

    public static final String ALARMTIME = "alarmTime";

    private int alarmduration;

    public static final String ALARMDURATION = "alarmDuration";

    private String voltage;

    public static final String VOLTAGE = "voltage";

    private String charge;

    public static final String CHARGE = "charge";

    private String chargephone;

    public static final String CHARGEPHONE = "chargePhone";

    private String prevoltage;

    public static final String PREVOLTAGE = "preVoltage";

    private int spareelecduration;

    public static final String SPAREELECDURATION = "spareElecDuration";

    private int wayofduration;

    public static final String WAYOFDURATION = "wayOfDuration";

    private int eleccountdown;

    public static final String ELECCOUNTDOWN = "elecCountdown";

    private Date generbegin;

    public static final String GENERBEGIN = "generBegin";

    private Date generend;

    public static final String GENEREND = "generEnd";

    private String generperson;

    public static final String GENERPERSON = "generPerson";

    private int status;

    public static final String STATUS = "status";

    public int getAlarmHistoryId() {
        return alarmHistoryId;
    }

    public void setAlarmHistoryId(int alarmHistoryId) {
        this.alarmHistoryId = alarmHistoryId;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
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

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public String getTroubleno() {
        return troubleno;
    }

    public void setTroubleno(String troubleno) {
        this.troubleno = troubleno == null ? null : troubleno.trim();
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid == null ? null : billid.trim();
    }

    public String getStationcode() {
        return stationcode;
    }

    public void setStationcode(String stationcode) {
        this.stationcode = stationcode == null ? null : stationcode.trim();
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public Date getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
    }

    public int getAlarmduration() {
        return alarmduration;
    }

    public void setAlarmduration(int alarmduration) {
        this.alarmduration = alarmduration;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage == null ? null : voltage.trim();
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public String getChargephone() {
        return chargephone;
    }

    public void setChargephone(String chargephone) {
        this.chargephone = chargephone == null ? null : chargephone.trim();
    }

    public String getPrevoltage() {
        return prevoltage;
    }

    public void setPrevoltage(String prevoltage) {
        this.prevoltage = prevoltage == null ? null : prevoltage.trim();
    }

    public int getSpareelecduration() {
        return spareelecduration;
    }

    public void setSpareelecduration(int spareelecduration) {
        this.spareelecduration = spareelecduration;
    }

    public int getWayofduration() {
        return wayofduration;
    }

    public void setWayofduration(int wayofduration) {
        this.wayofduration = wayofduration;
    }

    public int getEleccountdown() {
        return eleccountdown;
    }

    public void setEleccountdown(int eleccountdown) {
        this.eleccountdown = eleccountdown;
    }

    public Date getGenerbegin() {
        return generbegin;
    }

    public void setGenerbegin(Date generbegin) {
        this.generbegin = generbegin;
    }

    public Date getGenerend() {
        return generend;
    }

    public void setGenerend(Date generend) {
        this.generend = generend;
    }

    public String getGenerperson() {
        return generperson;
    }

    public void setGenerperson(String generperson) {
        this.generperson = generperson == null ? null : generperson.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}