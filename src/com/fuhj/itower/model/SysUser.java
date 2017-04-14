package com.fuhj.itower.model;

import java.util.Date;

public class SysUser extends BaseModel {
    private int id;

    public static final String ID = "id";

    private String loginname;

    public static final String LOGINNAME = "loginname";

    private String loginpwd;

    public static final String LOGINPWD = "loginpwd";

    private String username;

    public static final String USERNAME = "username";

    private Date createtime;

    public static final String CREATETIME = "createtime";

    private Date lastlogintime;

    public static final String LASTLOGINTIME = "lastlogintime";

    private String lastloginip;

    public static final String LASTLOGINIP = "lastloginip";

    private int status;

    public static final String STATUS = "status";

    private int level;

    public static final String LEVEL = "level";

    private String perm;

    public static final String PERM = "perm";

    private String remark;

    public static final String REMARK = "remark";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm == null ? null : perm.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}