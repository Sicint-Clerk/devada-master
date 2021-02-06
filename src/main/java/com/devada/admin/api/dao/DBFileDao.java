package com.devada.admin.api.dao;

import java.util.List;

import com.devada.admin.api.entity.DBFile;
import com.devada.base.dao.BaseDao;

public interface DBFileDao extends BaseDao<DBFile, Integer> {

	DBFile uploadFile(DBFile filemode) throws Exception;

	List<DBFile> getDBFileList()  throws Exception;
	
}
