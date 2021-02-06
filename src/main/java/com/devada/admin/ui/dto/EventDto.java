package com.devada.admin.ui.dto;

import java.util.Date;
import java.util.List;

import com.devada.base.dto.BaseDto;

public class EventDto extends BaseDto {

//  private static final long serialVersionUID = 1L;
  private Integer eventId;
  private String eventTitle;
  private String eventDescription;
  private String eventImage;
  private Date eventDate;
  private Date createdOn;
  private Integer createdBy;
  private String createdIp;
  private Date updatedOn;
  private Integer updatedBy;
  private String UpdatedIp;
  private Integer cstatus;
  private List<String> eventImageLst;
public List<String> getEventImageLst() {
	return eventImageLst;
}
public void setEventImageLst(List<String> eventImageLst) {
	this.eventImageLst = eventImageLst;
}
public Integer getEventId() {
	return eventId;
}
public void setEventId(Integer eventId) {
	this.eventId = eventId;
}
public String getEventTitle() {
	return eventTitle;
}
public void setEventTitle(String eventTitle) {
	this.eventTitle = eventTitle;
}
public String getEventDescription() {
	return eventDescription;
}
public void setEventDescription(String eventDescription) {
	this.eventDescription = eventDescription;
}
public String getEventImage() {
	return eventImage;
}
public void setEventImage(String eventImage) {
	this.eventImage = eventImage;
}
public Date getEventDate() {
	return eventDate;
}
public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
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
//public static long getSerialversionuid() {
//	return serialVersionUID;
//}
  	
}
