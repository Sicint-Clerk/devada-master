package com.devada.admin.ui.dto;

public class LoginUiDto {
  private String userName;
  private String password;
  private String emailid;
  private String newPassword;
  private String cnfPassword;

	public String getUserName() {
	  return userName;
	}
	
	public void setUserName(String userName) {
	   this.userName = userName;
	}
	
	public String getPassword() {
	   return password;
	}
	
    public void setPassword(String password) {
	   this.password = password;
    }

	public String getEmailid() {
		return emailid;
	}
	
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCnfPassword() {
		return cnfPassword;
	}

	public void setCnfPassword(String cnfPassword) {
		this.cnfPassword = cnfPassword;
	}
  
  
}
