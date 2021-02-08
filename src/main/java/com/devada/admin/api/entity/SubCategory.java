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
@Table(name = "SUB_CATEGORY")
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

	@Column(name = "MAIN_CATEGORY_NAME")
	private String maincategoryname;

	@Column(name = "SUB_CATEGORY_NAME")
	private String subcategoryname;

	public String getMaincategoryname() {
		return maincategoryname;
	}

	public void setMaincategoryname(String maincategoryname) {
		this.maincategoryname = maincategoryname;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}