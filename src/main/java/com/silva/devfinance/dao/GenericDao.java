package com.silva.devfinance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.silva.devfinance.util.HibernateUtil;

public class GenericDao<E> {
	public void save(E entity) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
	}
	
	public void merge(E entity) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(entity);
		transaction.commit();
	}
	
	public void deleteById(E entity) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Object id = HibernateUtil.getPrimaryKeyObject(entity);
		transaction.begin();

		entityManager.createQuery("delete " + entity.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		
		transaction.commit();
		
	}
	
	public List<E> getAllResultList(Class<E> nameClass) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<E> resultList = entityManager.createQuery("from " + nameClass.getName()).getResultList();
		
		transaction.commit();
		
		return resultList;
	}
}
