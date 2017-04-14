package com.fuhj.itower.model;

import java.util.Date;

public class FSUCondItem extends BaseModel {
    private int id;

    public static final String ID = "id";

    private long queryid;

    public static final String QUERYID = "queryId";

    private Date querytime;

    public static final String QUERYTIME = "queryTime";

    private String areaname;

    public static final String AREANAME = "areaName";

    private String itprovinceid;

    public static final String ITPROVINCEID = "itProvinceId";

    private String itcityid;

    public static final String ITCITYID = "itCityId";

    private String itdistrictid;

    public static final String ITDISTRICTID = "itDistrictId";

    private int tdcount;

    public static final String TDCOUNT = "tdCount";

    private int vlowcount;

    public static final String VLOWCOUNT = "vlowCount";

    private int dzcount;

    public static final String DZCOUNT = "dzCount";

    private int offlinecount;

    public static final String OFFLINECOUNT = "offlineCount";

    private int sort;

    public static final String SORT = "sort";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getQueryid() {
        return queryid;
    }

    public void setQueryid(long queryid) {
        this.queryid = queryid;
    }

    public Date getQuerytime() {
        return querytime;
    }

    public void setQuerytime(Date querytime) {
        this.querytime = querytime;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getItprovinceid() {
        return itprovinceid;
    }

    public void setItprovinceid(String itprovinceid) {
        this.itprovinceid = itprovinceid == null ? null : itprovinceid.trim();
    }

    public String getItcityid() {
        return itcityid;
    }

    public void setItcityid(String itcityid) {
        this.itcityid = itcityid == null ? null : itcityid.trim();
    }

    public String getItdistrictid() {
        return itdistrictid;
    }

    public void setItdistrictid(String itdistrictid) {
        this.itdistrictid = itdistrictid == null ? null : itdistrictid.trim();
    }

    public int getTdcount() {
        return tdcount;
    }

    public void setTdcount(int tdcount) {
        this.tdcount = tdcount;
    }

    public int getVlowcount() {
        return vlowcount;
    }

    public void setVlowcount(int vlowcount) {
        this.vlowcount = vlowcount;
    }

    public int getDzcount() {
        return dzcount;
    }

    public void setDzcount(int dzcount) {
        this.dzcount = dzcount;
    }

    public int getOfflinecount() {
        return offlinecount;
    }

    public void setOfflinecount(int offlinecount) {
        this.offlinecount = offlinecount;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}