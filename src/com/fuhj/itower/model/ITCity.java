package com.fuhj.itower.model;

public class ITCity extends BaseModel {
	private String itCityId;

	private String itProvinceId;

	private String cname;

	private int sortrule;

	public String getItCityId() {
		return itCityId;
	}

	public void setItCityId(String itCityId) {
		this.itCityId = itCityId == null ? null : itCityId.trim();
	}

	public String getItProvinceId() {
		return itProvinceId;
	}

	public void setItProvinceId(String itProvinceId) {
		this.itProvinceId = itProvinceId == null ? null : itProvinceId.trim();
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname == null ? null : cname.trim();
	}

	public int getSortrule() {
		return sortrule;
	}

	public void setSortrule(int sortrule) {
		this.sortrule = sortrule;
	}
}