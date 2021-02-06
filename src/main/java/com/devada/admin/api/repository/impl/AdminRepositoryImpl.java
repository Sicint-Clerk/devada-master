package com.devada.admin.api.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devada.admin.api.dao.ContactDao;
import com.devada.admin.api.dao.DBFileDao;
import com.devada.admin.api.dao.FamilyInformationDao;
import com.devada.admin.api.dao.MainCategoryDao;
import com.devada.admin.api.dao.MarriageInformationDao;
import com.devada.admin.api.dao.MarriedDaughterDao;
import com.devada.admin.api.dao.PersonInformationDao;
import com.devada.admin.api.dao.SubCategoryDao;
import com.devada.admin.api.entity.Contact;
import com.devada.admin.api.entity.DBFile;
import com.devada.admin.api.entity.FamilyInformation;
import com.devada.admin.api.entity.MainCategory;
import com.devada.admin.api.entity.MarriageInformation;
import com.devada.admin.api.entity.MarriedDaughter;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.api.entity.SubCategory;
import com.devada.admin.api.repository.AdminRepository;
import com.devada.admin.constants.AdminErrorCodes;
import com.devada.admin.ui.dto.LoginUiDto;
import com.devada.base.exception.KKDaoException;

@Repository
@Transactional
public class AdminRepositoryImpl<E> implements AdminRepository {
	@Autowired
	private PersonInformationDao personInformationDao;

	@Autowired
	private FamilyInformationDao familyInformationDao;

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private MarriageInformationDao marriageInformationDao;

	@Autowired
	private MarriedDaughterDao marriedDaughterDao;

	@Autowired
	private MainCategoryDao mainCategoryDao;

	@Autowired
	private SubCategoryDao subCategoryDao;

	@Autowired
	DBFileDao dbFileDao;

	@Override
	public List<PersonInformation> getPersonInformation() throws KKDaoException {
		try {
			return personInformationDao.findAll(PersonInformation.class);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public PersonInformation savePersonInformation(PersonInformation personInformation) throws KKDaoException {
		try {
			personInformation.setRole("guser");
			return personInformationDao.save(personInformation);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	public FamilyInformation saveFamilyInformation(FamilyInformation familyInformation) throws KKDaoException {
		try {
			return familyInformationDao.save(familyInformation);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	public Contact saveContact(Contact contact) throws KKDaoException {
		try {
			return contactDao.save(contact);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public void updatePersonInformation(PersonInformation personInformation) throws KKDaoException {
		try {
			personInformationDao.update(personInformation);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public PersonInformation getInformationByKey(Integer id) throws KKDaoException {
		try {
			return personInformationDao.findByKey(PersonInformation.class, id);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public List<FamilyInformation> getFamilyInformationByPersonKey(Integer id) throws KKDaoException {
		try {
			List<FamilyInformation> tempList = familyInformationDao.findEntitiesByColumn(FamilyInformation.class,
					"personKey", id);
			return tempList;

		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public List<PersonInformation> getApprovedList() throws KKDaoException {
		try {
			List<PersonInformation> informations = personInformationDao.findEntitiesByColumn(PersonInformation.class,
					"isApproved", "Y");
			return informations;
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_GET_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public PersonInformation validateUser(LoginUiDto loginUiDto) throws KKDaoException {
		PersonInformation personInformation = null;
		try {
			personInformation = personInformationDao.validateUser(loginUiDto);
		} catch (Exception e) {

		}

		return personInformation;
	}

	@Override
	public PersonInformation findEmailId(String emailid) throws Exception {
		List<PersonInformation> personInformation = personInformationDao.findEntitiesByColumn(PersonInformation.class,
				"email", emailid);
		return personInformation.get(0);
	}

	@Override
	public MarriageInformation saveMarriageInformation(MarriageInformation marriageInformation) throws Exception {
		try {
			return marriageInformationDao.save(marriageInformation);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public MarriedDaughter saveMarriedDaughter(MarriedDaughter marriedDaughter) throws Exception {
		try {
			return marriedDaughterDao.save(marriedDaughter);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}

	@Override
	public List<MarriageInformation> getMarriageInfo() throws Exception {
		List<MarriageInformation> mList = null;
		try {
			mList = marriageInformationDao.findAll(MarriageInformation.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public MarriageInformation getMarriageInfo(Integer id) throws KKDaoException {
		return marriageInformationDao.findByKey(MarriageInformation.class, id);
	}

	@Override
	public List<MarriedDaughter> getMarriedDaughter(Integer id) throws KKDaoException {
		List<MarriedDaughter> informations = marriedDaughterDao.findEntitiesByColumn(MarriedDaughter.class,
				"marriegeKey", id);
		return informations;
	}

	@Override
	public PersonInformation updatePasword(PersonInformation pInf) throws Exception {
		return personInformationDao.update(pInf);

	}

	@Override
	public DBFile uploadFile(DBFile filemode) throws Exception {
		return dbFileDao.uploadFile(filemode);
	}

	@Override
	public List<DBFile> getDBFileList() throws Exception {
		// TODO Auto-generated method stub
		return dbFileDao.getDBFileList();
	}

	@Override
	public MainCategory saveMainCategory(MainCategory mainCategory) throws KKDaoException {
		// TODO Auto-generated method stub
		try {
			return mainCategoryDao.save(mainCategory);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}

	}

	@Override
	public SubCategory saveSubCategory(SubCategory subCategory) throws KKDaoException {
		// TODO Auto-generated method stub
		try {
			return subCategoryDao.save(subCategory);
		} catch (IllegalStateException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION, ex);
		} catch (IllegalArgumentException ex) {
			throw new KKDaoException(AdminErrorCodes.ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION, ex);
		}
	}
}
