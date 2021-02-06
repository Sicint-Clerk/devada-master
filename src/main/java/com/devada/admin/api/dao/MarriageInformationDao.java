package com.devada.admin.api.dao;

import com.devada.admin.api.entity.MarriageInformation;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.ui.dto.LoginUiDto;
import com.devada.base.dao.BaseDao;

public interface MarriageInformationDao extends BaseDao<MarriageInformation, Integer> {

	PersonInformation validateUser(LoginUiDto loginUiDto) throws Exception;
}
