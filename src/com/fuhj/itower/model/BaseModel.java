package com.fuhj.itower.model;

import lombok.Data;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Data public class BaseModel {

	public static final int INSERT_STATE = 1;
	public static final int UPDATE_STATE = 2;
	public static final int DELETE_STATE = 3;
	private String tempStr;
	private int tempInt;
	private long tempLong;
	private double tempDouble;
	private Object tempObject;

	@Override public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
