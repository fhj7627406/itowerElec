package com.fuhj.itower.model;

import java.util.Date;

public class BotChatLog extends BaseModel {
    private int id;

    public static final String ID = "id";

    private int receiveorsend;

    public static final String RECEIVEORSEND = "receiveorsend";

    private String fromuser;

    public static final String FROMUSER = "fromUser";

    private String fromusername;

    public static final String FROMUSERNAME = "fromUserName";

    private String touser;

    public static final String TOUSER = "toUser";

    private String tousername;

    public static final String TOUSERNAME = "toUserName";

    private int msgtype;

    public static final String MSGTYPE = "msgType";

    private int frommyself;

    public static final String FROMMYSELF = "fromMyself";

    private int fromgroup;

    public static final String FROMGROUP = "fromGroup";

    private Date logtime;

    public static final String LOGTIME = "logTime";

    private int servicetype;

    public static final String SERVICETYPE = "serviceType";

    private String remark;

    public static final String REMARK = "remark";

    private String content;

    public static final String CONTENT = "content";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiveorsend() {
        return receiveorsend;
    }

    public void setReceiveorsend(int receiveorsend) {
        this.receiveorsend = receiveorsend;
    }

    public String getFromuser() {
        return fromuser;
    }

    public void setFromuser(String fromuser) {
        this.fromuser = fromuser == null ? null : fromuser.trim();
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername == null ? null : fromusername.trim();
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser == null ? null : touser.trim();
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername == null ? null : tousername.trim();
    }

    public int getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(int msgtype) {
        this.msgtype = msgtype;
    }

    public int getFrommyself() {
        return frommyself;
    }

    public void setFrommyself(int frommyself) {
        this.frommyself = frommyself;
    }

    public int getFromgroup() {
        return fromgroup;
    }

    public void setFromgroup(int fromgroup) {
        this.fromgroup = fromgroup;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public int getServicetype() {
        return servicetype;
    }

    public void setServicetype(int servicetype) {
        this.servicetype = servicetype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}