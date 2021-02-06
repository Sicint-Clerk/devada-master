package com.devada.admin.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.devada.base.entity.KKEntity;

@Entity
@Table(name = "mainservice")
@DynamicInsert
@DynamicUpdate
public class MainService extends KKEntity{
	
	public String getMainservicename() {
		return mainservicename;
	}
	public void setMainservicename(String mainservicename) {
		this.mainservicename = mainservicename;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "mainservicename")
	  private String mainservicename;
	
}