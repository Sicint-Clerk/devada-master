package com.devada.admin.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.devada.base.entity.KKEntity;

@Entity
@Table(name = "SUB_SERVICE")
@DynamicInsert
@DynamicUpdate
public class SubCategory extends KKEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "MAIN_SERVICE_NAME")
	private String mainservicename;

	@Column(name = "SUB_SERVICE_NAME")
	private String subservicename;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}