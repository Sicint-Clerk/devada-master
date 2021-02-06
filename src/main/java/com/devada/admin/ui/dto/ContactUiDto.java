package com.devada.admin.ui.dto;

import com.devada.base.dto.BaseDto;

public class ContactUiDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	  private String clientEmailId;
	  private String subject;
	  private String clientContactNo;
	  private String discription;
	  private String clientName;
	  
	  
	  
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
    public String getClientContactNo() {
      return clientContactNo;
    }
    public void setClientContactNo(String clientContactNo) {
      this.clientContactNo = clientContactNo;
    }
    public String getDiscription() {
      return discription;
    }
    public void setDiscription(String discription) {
      this.discription = discription;
    }
	  
	
	  
	
	
}
