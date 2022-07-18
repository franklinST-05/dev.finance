package com.silva.devfinance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.silva.devfinance.entity.FinanceEntity;
import com.silva.devfinance.enums.FinanceTypeEnum;
import com.silva.devfinance.util.HibernateUtil;

public class FinanceDao extends GenericDao<FinanceEntity>{
	GenericDao<FinanceEntity> dao = new GenericDao<>();
	
	public List<FinanceEntity> getAllByFinanceType(FinanceTypeEnum type) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<FinanceEntity> resultList = entityManager.createQuery("from " + FinanceEntity.class.getName() + " where financeTypeEnum = " + type.getClass().getName() ).getResultList();
		
		transaction.commit();
		
		return resultList;
	}
	
}
