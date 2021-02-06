package com.devada.admin.ui.dto;

import com.devada.base.dto.BaseDto;

public class SubParentCategoryUiDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	  private String subParentCategoryId;
	  private String categoryId;
	  private String categoryName;
	  private String subParentCategoryName;
	  
	public String getSubParentCategoryId() {
		return subParentCategoryId;
	}
	public void setSubParentCategoryId(String subParentCategoryId) {
		this.subParentCategoryId = subParentCategoryId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  public String getSubParentCategoryName() {
    return subParentCategoryName;
  }
  public void setSubParentCategoryName(String subParentCategoryName) {
    this.subParentCategoryName = subParentCategoryName;
  }
	
	
}
