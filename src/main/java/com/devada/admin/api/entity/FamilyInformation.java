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
@Table(name = "FAMILY_INFORMATION")
@DynamicInsert
@DynamicUpdate
public class FamilyInformation extends KKEntity {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "MEMBER_NAME")
  private String memberName;

  @Column(name = "AGE")
  private String age;

  @Column(name = "RELATION")
  private String relation;

  @Column(name = "EDUCATION")
  private String education;

  @Column(name = "PROFESSION")
  private String profession;  
  
  @Column(name = "MARRIED")
  private String married;

  @Column(name = "BLOOD_GROUP")
  private String bloodGroup;
  
  @Column(name = "PERSON_KEY")
  private Integer personKey;

  public Integer getKey() {
    return id;
  }

  public void setKey(Integer id) {
    this.id = id;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getProfession() {
    return profession;
  }

  public void setWork(String profession) {
    this.profession = profession;
  }

  public String getMarried() {
    return married;
  }

  public void setMarried(String married) {
    this.married = married;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }
  
  public Integer getPersonKey() {
    return personKey;
  }

  public void setPersonKey(Integer personKey) {
    this.personKey = personKey;
  }
}
