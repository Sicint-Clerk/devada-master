package com.devada.admin.ui.dto;

import java.util.Date;
import java.util.List;

import com.devada.base.dto.BaseDto;

public class MailDto extends BaseDto {

//  private static final long serialVersionUID = 1L;
  private String clientName;
  private String clientEmailId;
  private String subject;
  private String clientContact;
  private String mailDiscription;
public String getClientContact() {
	return clientContact;
}
public void setClientContact(String clientContact) {
	this.clientContact = clientContact;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getClientEmailId() {
	return clientEmailId;
}
public void setClientEmailId(String clientEmailId) {
	this.clientEmailId = clientEmailId;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMailDiscription() {
	return mailDiscription;
}
public void setMailDiscription(String mailDiscription) {
	this.mailDiscription = mailDiscription;
}
    	
}
