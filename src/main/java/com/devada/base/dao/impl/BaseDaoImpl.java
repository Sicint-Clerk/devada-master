package com.devada.base.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devada.base.dao.BaseDao;
import com.devada.base.entity.KKEntity;

@Transactional
@Repository
public class BaseDaoImpl<E extends KKEntity, K> implements BaseDao<E, K> {

  @PersistenceContext
  private EntityManager entityManager;

  private Class<E> entityClass = null;

  public BaseDaoImpl() {

  }

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @javax.transaction.Transactional
  public E save(final E entity) {
    entityManager.persist(entity);
    entityManager.flush();

    return entity;
  }

  @Override
  public E update(E entity) {

    entity = entityManager.merge(entity);

    return entity;
  }

  @Override
  public E updateWithFlush(E entity) {
    update(entity);
    entityManager.flush();

    return entity;
  }

  @Override
  public void delete(final Class<E> entityClass, final K key) {
    entityManager.remove(findByKey(entityClass, key));

  }

  protected void delete(final K key) {
    delete(this.entityClass, key);
  }

  @Override
  public E findByKey(final Class<E> entityClass, final K key) {
    return entityManager.find(entityClass, key);
  }

  protected E findByKey(final K key) {
    return findByKey(this.entityClass, key);
  }

  @Override
  public List<E> findAll(final Class<E> entityClass) {

    final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
    final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);

    final Root<E> root = criteriaQuery.from(entityClass);
    criteriaQuery.select(root);

    final TypedQuery<E> tQuery = this.entityManager.createQuery(criteriaQuery);

    return tQuery.getResultList();
  }

  protected List<E> findAll() {
    return findAll(this.entityClass);
  }

  @Override
  public List<E> findEntitiesByKey(final Class<E> entityClass, final List<K> keys) {

    List<E> entities = new ArrayList<E>();
    List<List<K>> splitsKeys = splitListForInQuery(keys);

    for (List<K> splitedkeys : splitsKeys) {
      final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
      final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);

      final Root<E> root = criteriaQuery.from(entityClass);
      criteriaQuery.select(root);

      final Predicate predicate = root.get("key").in(splitedkeys);

      criteriaQuery.where(predicate);

      final TypedQuery<E> tQuery = this.entityManager.createQuery(criteriaQuery);

      entities.addAll(tQuery.getResultList());
    }
    return entities;
  }

  @Override
  public List<E> findEntitiesByColumn(final Class<E> entityClass, final String column, final K keys) {

    List<E> entities = new ArrayList<E>();
    final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
    final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);

    final Root<E> root = criteriaQuery.from(entityClass);
    criteriaQuery.select(root);

    final Predicate predicate = root.get(column).in(keys);
    criteriaQuery.where(predicate);

    final TypedQuery<E> tQuery = this.entityManager.createQuery(criteriaQuery);
    entities.addAll(tQuery.getResultList());
    return entities;
  }
  
  @Override
  public List<E> findEntitiesByColumn(final Class<E> entityClass, final String column, final String value) {

    List<E> entities = new ArrayList<E>();
    final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
    final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);

    final Root<E> root = criteriaQuery.from(entityClass);
    criteriaQuery.select(root);

    final Predicate predicate = root.get(column).in(value);
    criteriaQuery.where(predicate);

    final TypedQuery<E> tQuery = this.entityManager.createQuery(criteriaQuery);
    entities.addAll(tQuery.getResultList());
    return entities;
  }

  protected List<E> findEntitiesByKey(final List<K> keys) {
    return findEntitiesByKey(this.entityClass, keys);
  }

  private List<List<K>> splitListForInQuery(final List<K> keys) {
    List<List<K>> filalLists = new ArrayList<List<K>>();
    if (keys != null) {
      int count = keys.size() / 1000;

      int startIndext = 0;
      int endIndex = 1000;
      for (int i = 1; i <= count + 1; i++) {

        if (startIndext > keys.size() - 1)
          break;

        if (keys.size() < endIndex) {
          endIndex = keys.size();
        }

        filalLists.add(keys.subList(startIndext, endIndex));
        startIndext = endIndex + 1;
        endIndex = endIndex + 1000;

      }

    }
    return filalLists;
  }

}
