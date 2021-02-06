package com.devada.admin.api.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.devada.admin.api.dao.ContactDao;
import com.devada.admin.api.dao.DBFileDao;
import com.devada.admin.api.entity.Contact;
import com.devada.admin.api.entity.DBFile;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.base.dao.impl.BaseDaoImpl;

@Service("dbFileDao")
public class DBFileDaoImpl extends BaseDaoImpl<DBFile, Integer> implements DBFileDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public DBFile uploadFile(DBFile filemode) throws Exception {
		// TODO Auto-generated method stub
		return this.save(filemode);
	}


	@Override
	public List<DBFile> getDBFileList() throws Exception {
		return this.findAll(DBFile.class);
	}
}
