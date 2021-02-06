package com.devada.admin.api.dao.impl;

import org.springframework.stereotype.Service;

import com.devada.admin.api.dao.MainCategoryDao;
import com.devada.admin.api.entity.MainCategory;
import com.devada.base.dao.impl.BaseDaoImpl;

@Service("mainServiceDao")
public class MainCategoryDaoImpl extends BaseDaoImpl<MainCategory, Integer> implements MainCategoryDao {
}
