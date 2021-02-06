package com.devada.admin.api.entity;

import java.util.List;

public class PersonInfoDto {

private List<FamilyInformation> familyInformations;
private PersonInformation personInformation;

public List<FamilyInformation> getFamilyInformations() {
  return familyInformations;
}
public void setFamilyInformations(List<FamilyInformation> familyInformations) {
  this.familyInformations = familyInformations;
}
public PersonInformation getPersonInformation() {
  return personInformation;
}
public void setPersonInformation(PersonInformation personInformation) {
  this.personInformation = personInformation;
}
}
