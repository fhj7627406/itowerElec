package com.fuhj.itower.dao;

import java.util.ArrayList;
import java.util.List;


public class Example<T extends Criteria> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<T> oredCriteria;
	
	private Class<T> criteriaClass;

	public static <C extends Criteria> Example<C> getExample(Class<C> criteriaClass) {
		return new Example<C>(criteriaClass);
	}
	
	public Example(Class<T> criteriaClass) {
		this.criteriaClass = criteriaClass;
		oredCriteria = new ArrayList<T>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<T> getOredCriteria() {
		return oredCriteria;
	}

	public void or(T criteria) {
		oredCriteria.add(criteria);
	}

	public T or() {
		T criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public T createCriteria() {
		T criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected T createCriteriaInternal() {
		try {
			T criteria = criteriaClass.newInstance();
			return criteria;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

}
