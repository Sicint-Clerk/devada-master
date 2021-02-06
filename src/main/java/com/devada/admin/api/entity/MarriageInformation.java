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
@Table(name = "MARRIAGE_INFORMATION")
@DynamicInsert
@DynamicUpdate
public class MarriageInformation extends KKEntity {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "BIRTH_DATE")
  private String birthDate;
  
  @Column(name = "FATHER_NAME")
  private String fatherName;

  @Column(name = "MOTHER_NAME")
  private String motherName;

  @Column(name = "MOSAN")
  private String mosan;

  @Column(name = "PRESENT_ADDRESS")
  private String presentAddress;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "MOBILE")
  private String mobile;

  @Column(name = "EDUCATION")
  private String education;

  @Column(name = "BLOOD_GROUP")
  private String bloodGroup;

  @Column(name = "WORK")
  private String work;

  @Column(name = "PERMANENT_ADDRESS")
  private String permanentAddress;

  @Column(name = "VAS")
  private String vas;

  @Column(name = "IS_APPROVED")
  private String isApproved;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public String getMosan() {
    return mosan;
  }

  public void setMosan(String mosan) {
    this.mosan = mosan;
  }

  public String getPresentAddress() {
    return presentAddress;
  }

  public void setPresentAddress(String presentAddress) {
    this.presentAddress = presentAddress;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getWork() {
    return work;
  }

  public void setWork(String work) {
    this.work = work;
  }

  public String getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(String permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  public String getVas() {
    return vas;
  }

  public void setVas(String vas) {
    this.vas = vas;
  }

  public String getIsApproved() {
    return isApproved;
  }

  public void setIsApproved(String isApproved) {
    this.isApproved = isApproved;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }
	
   
  
   
  
  
}
