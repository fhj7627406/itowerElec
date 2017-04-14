package com.fuhj.itower.model;

import java.util.Date;

public class AlarmQueryLog extends BaseModel {
    private int logId;

    public static final String LOG_ID = "log_id";

    private Date querytime;

    public static final String QUERYTIME = "queryTime";

    private int userid;

    public static final String USERID = "userId";

    private String range;

    public static final String RANGE = "range";

    private int returncode;

    public static final String RETURNCODE = "returnCode";

    private int returncount;

    public static final String RETURNCOUNT = "returnCount";

    private int timetaking;

    public static final String TIMETAKING = "timeTaking";

    private String hasexception;

    public static final String HASEXCEPTION = "hasException";

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public Date getQuerytime() {
        return querytime;
    }

    public void setQuerytime(Date querytime) {
        this.querytime = querytime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range == null ? null : range.trim();
    }

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public int getReturncount() {
        return returncount;
    }

    public void setReturncount(int returncount) {
        this.returncount = returncount;
    }

    public int getTimetaking() {
        return timetaking;
    }

    public void setTimetaking(int timetaking) {
        this.timetaking = timetaking;
    }

    public String getHasexception() {
        return hasexception;
    }

    public void setHasexception(String hasexception) {
        this.hasexception = hasexception == null ? null : hasexception.trim();
    }
}