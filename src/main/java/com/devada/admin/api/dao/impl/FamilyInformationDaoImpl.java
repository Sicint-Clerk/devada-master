package com.devada.admin.api.dao.impl;

import org.springframework.stereotype.Service;

import com.devada.admin.api.dao.FamilyInformationDao;
import com.devada.admin.api.entity.FamilyInformation;
import com.devada.base.dao.impl.BaseDaoImpl;

@Service("familyInformationDao")
public class FamilyInformationDaoImpl extends BaseDaoImpl<FamilyInformation, Integer> implements FamilyInformationDao {
}
