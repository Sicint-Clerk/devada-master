package com.devada.admin.ui.dto;

import com.devada.base.dto.BaseDto;

public class DyesForrestcorpindexUiDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	  private Integer dyesForrestcorpindexId;
	  private String dyesForrestcorpindexName;
	  private String subStuffName;
	  private Integer cStatus;
	  
	public Integer getDyesForrestcorpindexId() {
		return dyesForrestcorpindexId;
	}
	public void setDyesForrestcorpindexId(Integer dyesForrestcorpindexId) {
		this.dyesForrestcorpindexId = dyesForrestcorpindexId;
	}
	public String getDyesForrestcorpindexName() {
		return dyesForrestcorpindexName;
	}
	public void setDyesForrestcorpindexName(String dyesForrestcorpindexName) {
		this.dyesForrestcorpindexName = dyesForrestcorpindexName;
	}
  public String getSubStuffName() {
    return subStuffName;
  }
  public void setSubStuffName(String subStuffName) {
    this.subStuffName = subStuffName;
  }
public Integer getcStatus() {
	return cStatus;
}
public void setcStatus(Integer cStatus) {
	this.cStatus = cStatus;
}
	
	
	
	  
}
