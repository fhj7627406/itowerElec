package com.fuhj.itower.model;

public class ITDistrict extends BaseModel {
    private String itDistrictId;

    public static final String IT_DISTRICT_ID = "it_district_id";

    private String itProvinceId;

    public static final String IT_PROVINCE_ID = "it_province_id";

    private String itCityId;

    public static final String IT_CITY_ID = "it_city_id";

    private String dname;

    public static final String DNAME = "dname";

    private String dshortname;

    public static final String DSHORTNAME = "dshortname";

    private int sortrule;

    public static final String SORTRULE = "sortrule";

    public String getItDistrictId() {
        return itDistrictId;
    }

    public void setItDistrictId(String itDistrictId) {
        this.itDistrictId = itDistrictId == null ? null : itDistrictId.trim();
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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getDshortname() {
        return dshortname;
    }

    public void setDshortname(String dshortname) {
        this.dshortname = dshortname == null ? null : dshortname.trim();
    }

    public int getSortrule() {
        return sortrule;
    }

    public void setSortrule(int sortrule) {
        this.sortrule = sortrule;
    }
}