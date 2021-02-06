package com.devada.admin.ui.dto;

import com.devada.base.dto.BaseDto;

public class DyesIntermediateUiDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private Integer dyesIntermediateid;
	private String dyesIntermediateName;
	private String cas;
	private String chemicalName;
	private String molWt;
	private String molFormula;
	private String intermidateCategory;
	private Integer cstatus;
	
	
	
	public Integer getCstatus() {
		return cstatus;
	}
	public void setCstatus(Integer cstatus) {
		this.cstatus = cstatus;
	}
	public Integer getDyesIntermediateid() {
		return dyesIntermediateid;
	}
	public void setDyesIntermediateid(Integer dyesIntermediateid) {
		this.dyesIntermediateid = dyesIntermediateid;
	}
	public String getDyesIntermediateName() {
		return dyesIntermediateName;
	}
	public void setDyesIntermediateName(String dyesIntermediateName) {
		this.dyesIntermediateName = dyesIntermediateName;
	}
	public String getCas() {
		return cas;
	}
	public void setCas(String cas) {
		this.cas = cas;
	}
	public String getChemicalName() {
		return chemicalName;
	}
	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}
	public String getMolWt() {
		return molWt;
	}
	public void setMolWt(String molWt) {
		this.molWt = molWt;
	}
	public String getMolFormula() {
		return molFormula;
	}
	public void setMolFormula(String molFormula) {
		this.molFormula = molFormula;
	}
  public String getIntermidateCategory() {
    return intermidateCategory;
  }
  public void setIntermidateCategory(String intermidateCategory) {
    this.intermidateCategory = intermidateCategory;
  }
	
	
	
	
}
