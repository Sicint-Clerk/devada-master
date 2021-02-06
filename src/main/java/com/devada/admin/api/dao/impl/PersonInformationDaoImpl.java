package com.devada.admin.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.devada.admin.api.dao.PersonInformationDao;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.ui.dto.LoginUiDto;
import com.devada.base.dao.impl.BaseDaoImpl;

@Service("personInformationDao")
public class PersonInformationDaoImpl extends BaseDaoImpl<PersonInformation, Integer> implements PersonInformationDao {

	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public PersonInformation validateUser(LoginUiDto loginUiDto) throws Exception {
		PersonInformation personInformation =null;
		try {
		    CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		    CriteriaQuery<PersonInformation> criteriaQuery = criteriaBuilder.createQuery(PersonInformation.class);

		    Root<PersonInformation> root = criteriaQuery.from(PersonInformation.class);
		    criteriaQuery.select(root);

		    Predicate user = root.get("username").in(loginUiDto.getUserName());
		    Predicate password = root.get("password").in(loginUiDto.getPassword());
		    Predicate predicate = criteriaBuilder.and(user,password);
		    criteriaQuery.where(predicate);
		    
		    TypedQuery<PersonInformation> tQuery = this.entityManager.createQuery(criteriaQuery);
		  List<PersonInformation> pList =  tQuery.getResultList();
		  personInformation = pList.get(0);
		}catch(Exception e){
			
		}
		return personInformation;
	}
}
