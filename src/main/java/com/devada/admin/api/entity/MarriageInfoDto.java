package com.devada.admin.api.entity;

import java.util.List;

public class MarriageInfoDto {

	private List<MarriedDaughter> marriedDaughter;
	private MarriageInformation marriageInformation;
	
	public List<MarriedDaughter> getMarriedDaughter() {
		return marriedDaughter;
	}
	public void setMarriedDaughter(List<MarriedDaughter> marriedDaughter) {
		this.marriedDaughter = marriedDaughter;
	}
	
	public MarriageInformation getMarriageInformation() {
		return marriageInformation;
	}
	public void setMarriageInformation(MarriageInformation marriageInformation) {
		this.marriageInformation = marriageInformation;
	}
}
