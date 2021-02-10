package com.devada.admin.api.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devada.admin.api.entity.Contact;
import com.devada.admin.api.entity.DBFile;
import com.devada.admin.api.entity.FamilyInformation;
import com.devada.admin.api.entity.MainCategory;
import com.devada.admin.api.entity.MarriageInformation;
import com.devada.admin.api.entity.MarriedDaughter;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.api.entity.SubCategory;
import com.devada.admin.ui.dto.LoginUiDto;
import com.devada.base.exception.KKDaoException;

@Service
public interface AdminRepository<E> {
	public List<PersonInformation> getPersonInformation() throws KKDaoException;

	public PersonInformation savePersonInformation(PersonInformation personInformation) throws KKDaoException;

	public void updatePersonInformation(PersonInformation personInformation) throws KKDaoException;

	public PersonInformation getInformationByKey(Integer key) throws KKDaoException;

	public FamilyInformation saveFamilyInformation(FamilyInformation familyInformation) throws KKDaoException;

	public Contact saveContact(Contact contact) throws KKDaoException;

	public List<FamilyInformation> getFamilyInformationByPersonKey(Integer id) throws KKDaoException;

	public List<PersonInformation> getApprovedList() throws KKDaoException;

	public PersonInformation validateUser(LoginUiDto loginUiDto) throws KKDaoException;

	public PersonInformation findEmailId(String emailid) throws Exception;

	public MarriageInformation saveMarriageInformation(MarriageInformation marriageInformation) throws Exception;

	public MarriedDaughter saveMarriedDaughter(MarriedDaughter marriedDaughter) throws Exception;

	public List<MarriageInformation> getMarriageInfo() throws Exception;

	public PersonInformation updatePasword(PersonInformation pInf) throws Exception;

	public MarriageInformation getMarriageInfo(Integer id) throws KKDaoException;

	public List<MarriedDaughter> getMarriedDaughter(Integer id) throws KKDaoException;

	public DBFile uploadFile(DBFile filemode) throws Exception;

	public List<DBFile> getDBFileList() throws Exception;

	public List<MainCategory> getMainCategoryList() throws Exception;

	public List<SubCategory> getSubCategoryList() throws Exception;

	public MainCategory saveMainCategory(MainCategory mainCategory) throws KKDaoException;

	public SubCategory saveSubCategory(SubCategory subCategory) throws KKDaoException;

}
