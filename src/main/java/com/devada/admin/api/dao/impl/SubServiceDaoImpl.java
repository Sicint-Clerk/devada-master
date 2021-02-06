package com.devada.admin.api.dao.impl;

import org.springframework.stereotype.Service;

import com.devada.admin.api.dao.SubCategoryDao;
import com.devada.admin.api.entity.SubCategory;
import com.devada.base.dao.impl.BaseDaoImpl;

@Service("subServiceDao")
public class SubServiceDaoImpl extends BaseDaoImpl<SubCategory, Integer> implements SubCategoryDao {
}
