package com.devada.admin.api.dao;

import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.ui.dto.LoginUiDto;
import com.devada.base.dao.BaseDao;

public interface PersonInformationDao extends BaseDao<PersonInformation, Integer> {

	PersonInformation validateUser(LoginUiDto loginUiDto) throws Exception;
}
