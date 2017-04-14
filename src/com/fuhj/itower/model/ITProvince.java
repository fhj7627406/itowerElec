package com.fuhj.itower.model;

public class ITProvince extends BaseModel {
	private String itProvinceId;

	private String pname;

	private int sortrule;

	public String getItProvinceId() {
		return itProvinceId;
	}

	public void setItProvinceId(String itProvinceId) {
		this.itProvinceId = itProvinceId == null ? null : itProvinceId.trim();
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname == null ? null : pname.trim();
	}

	public int getSortrule() {
		return sortrule;
	}

	public void setSortrule(int sortrule) {
		this.sortrule = sortrule;
	}
}