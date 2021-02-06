package com.devada.admin.ui.dto;

import java.util.List;

import com.devada.base.dto.BaseDto;

public class EventImageDetailDto extends BaseDto {

//  private static final long serialVersionUID = 1L;
  private Integer eventImageDetailId;
  private Integer eventId;
  private String eventImage;
  
  private List<String> eventImageLst;

public Integer getEventImageDetailId() {
	return eventImageDetailId;
}

public void setEventImageDetailId(Integer eventImageDetailId) {
	this.eventImageDetailId = eventImageDetailId;
}

public Integer getEventId() {
	return eventId;
}

public void setEventId(Integer eventId) {
	this.eventId = eventId;
}

public String getEventImage() {
	return eventImage;
}

public void setEventImage(String eventImage) {
	this.eventImage = eventImage;
}

public List<String> getEventImageLst() {
	return eventImageLst;
}

public void setEventImageLst(List<String> eventImageLst) {
	this.eventImageLst = eventImageLst;
}
}
