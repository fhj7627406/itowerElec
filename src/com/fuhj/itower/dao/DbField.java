package com.fuhj.itower.dao;

public class DbField {
    private String fieldName;
    private Object fieldValue;
    
    public DbField(String fieldName, Object fieldValue) {
    	this.fieldName = fieldName;
    	this.fieldValue = fieldValue;
    }
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fileName) {
		this.fieldName = fileName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
}
