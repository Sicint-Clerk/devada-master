package com.devada.admin.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.devada.base.entity.KKEntity;

@Entity
@Table(name = "subservice")
@DynamicInsert
@DynamicUpdate
public class SubService extends KKEntity{
	
	public String getMainservicename() {
		return mainservicename;
	}

	public void setMainservicename(String mainservicename) {
		this.mainservicename = mainservicename;
	}

	public String getSubservicename() {
		return subservicename;
	}

	public void setSubservicename(String subservicename) {
		this.subservicename = subservicename;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "mainservicename")
	  private String mainservicename;
	
	@Column(name = "subservicename")
	  private String subservicename;
	
}