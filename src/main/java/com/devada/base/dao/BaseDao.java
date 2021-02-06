package com.devada.base.dao;

import java.util.List;

import com.devada.base.entity.KKEntity;

public interface BaseDao<E extends KKEntity, K> {

  E save(E entity);

  E update(E entity);

  E updateWithFlush(E entity);

  void delete(Class<E> entityClass, K key);

  E findByKey(Class<E> entityClass, K key);

  List<E> findAll(Class<E> entityClass);

  List<E> findEntitiesByKey(Class<E> entityClass, List<K> keys);

  List<E> findEntitiesByColumn(Class<E> entityClass, String column, K keys);

  List<E> findEntitiesByColumn(Class<E> entityClass, String column, String value);

}
