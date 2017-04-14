package com.fuhj.itower.model;

import java.util.Date;

public class UpdateLog extends BaseModel {
    private int id;

    public static final String ID = "id";

    private String title;

    public static final String TITLE = "title";

    private String content;

    public static final String CONTENT = "content";

    private Date createtime;

    public static final String CREATETIME = "createtime";

    private int sysuserId;

    public static final String SYSUSER_ID = "sysuser_id";

    private int status;

    public static final String STATUS = "status";

    private String remark;

    public static final String REMARK = "remark";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(int sysuserId) {
        this.sysuserId = sysuserId;
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