package com.devada.admin.api.dao.impl;

import org.springframework.stereotype.Service;

import com.devada.admin.api.dao.ContactDao;
import com.devada.admin.api.entity.Contact;
import com.devada.base.dao.impl.BaseDaoImpl;

@Service("contactDao")
public class ContactDaoImpl extends BaseDaoImpl<Contact, Integer> implements ContactDao {
}
