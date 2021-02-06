package com.devada.admin.ui.dto;

import com.devada.base.dto.BaseDto;

public class CategoryUiDto extends BaseDto {

  private static final long serialVersionUID = 1L;
  private String key;
  private String name;


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
