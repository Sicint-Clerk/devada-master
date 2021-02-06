package com.devada.admin.ui.dto;

import com.devada.base.dto.BaseDto;

public class SubCategoryUiDto extends BaseDto {

  private static final long serialVersionUID = 1L;
  private Integer subCategoryKey;
  private Integer categoryKey;
  private String subCategoryName;
  private Integer subParentCategoryKey;
  private String subParentCategoryName;
  
  
public String getSubParentCategoryName() {
	return subParentCategoryName;
}
public void setSubParentCategoryName(String subParentCategoryName) {
	this.subParentCategoryName = subParentCategoryName;
}
public Integer getCategoryKey() {
	return categoryKey;
}
public void setCategoryKey(Integer categoryKey) {
	this.categoryKey = categoryKey;
}
public String getSubCategoryName() {
	return subCategoryName;
}
public void setSubCategoryName(String subCategoryName) {
	this.subCategoryName = subCategoryName;
}
public Integer getSubParentCategoryKey() {
	return subParentCategoryKey;
}
public void setSubParentCategoryKey(Integer subParentCategoryKey) {
	this.subParentCategoryKey = subParentCategoryKey;
}
public Integer getSubCategoryKey() {
	return subCategoryKey;
}
public void setSubCategoryKey(Integer subCategoryKey) {
	this.subCategoryKey = subCategoryKey;
}





  
}
