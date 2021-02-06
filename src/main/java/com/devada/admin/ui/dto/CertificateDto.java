package com.devada.admin.ui.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.devada.base.dto.BaseDto;

public class CertificateDto extends BaseDto {

	private Integer certificateId;
	private String certificateTitle;
	private List<String> certiImage;
	private List<String> winnerImage;
	private String certificateYear;
	private String certificateDescription;
	
	public List<String> getCertiImage() {
		return certiImage;
	}
	public void setCertiImage(List<String> certiImage) {
		this.certiImage = certiImage;
	}
	public List<String> getWinnerImage() {
		return winnerImage;
	}
	public void setWinnerImage(List<String> winnerImage) {
		this.winnerImage = winnerImage;
	}
	public String getCertificateYear() {
		return certificateYear;
	}
	public void setCertificateYear(String certificateYear) {
		this.certificateYear = certificateYear;
	}
	public String getCertificateDescription() {
		return certificateDescription;
	}
	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
	}
	public Integer getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}
	public String getCertificateTitle() {
		return certificateTitle;
	}
	public void setCertificateTitle(String certificateTitle) {
		this.certificateTitle = certificateTitle;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedIp() {
		return createdIp;
	}
	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedIp() {
		return UpdatedIp;
	}
	public void setUpdatedIp(String updatedIp) {
		UpdatedIp = updatedIp;
	}
	public Integer getCstatus() {
		return cstatus;
	}
	public void setCstatus(Integer cstatus) {
		this.cstatus = cstatus;
	}
	private Date createdOn;
	private Integer  createdBy;
	private String createdIp;
	private Date updatedOn;
	private Integer updatedBy;
	private String UpdatedIp;
	private Integer cstatus;
	

}
