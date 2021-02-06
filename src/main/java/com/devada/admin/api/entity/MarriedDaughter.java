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
@Table(name = "MARRIED_DAUGHTER")
@DynamicInsert
@DynamicUpdate
public class MarriedDaughter extends KKEntity {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "MARRIEGE_KEY")
  private Integer marriegeKey;
  
  @Column(name = "DAUGHTER_NAME")
  private String daughterName;

  @Column(name = "DAUGHTER_FATHER")
  private String daughterFather;
  
  @Column(name = "VAS")
  private String vas;

  @Column(name = "LAGAN_GAM")
  private String laganGam;

 
  @Column(name = "PRESENT_ADDRESS")
  private String presentAddress;

  @Column(name = "MOBILE")
  private String mobile;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMarriegeKey() {
		return marriegeKey;
	}
	
	public void setMarriegeKey(Integer marriegeKey) {
		this.marriegeKey = marriegeKey;
	}
	
	public String getDaughterName() {
		return daughterName;
	}
	
	public void setDaughterName(String daughterName) {
		this.daughterName = daughterName;
	}
	
	public String getDaughterFather() {
		return daughterFather;
	}
	
	public void setDaughterFather(String daughterFather) {
		this.daughterFather = daughterFather;
	}
	
	public String getVas() {
		return vas;
	}
	
	public void setVas(String vas) {
		this.vas = vas;
	}
	
	public String getLaganGam() {
		return laganGam;
	}
	
	public void setLaganGam(String laganGam) {
		this.laganGam = laganGam;
	}

public String getPresentAddress() {
	return presentAddress;
}

public void setPresentAddress(String presentAddress) {
	this.presentAddress = presentAddress;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

  
   
  
   
  
  
}
