package com.devada.base.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class KKKeyEntity extends KKEntity {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SKEY")
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long key;

  public Long getKey() {
    return key;
  }

  public void setKey(Long key) {
    this.key = key;
  }
}
