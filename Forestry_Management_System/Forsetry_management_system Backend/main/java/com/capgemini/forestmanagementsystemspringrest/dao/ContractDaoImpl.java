package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemspringrest.bean.ContractBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
@Repository
public class ContractDaoImpl implements ContractDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	public boolean contractVerification(int contractId) {
		EntityManager manager=factory.createEntityManager();
		String jpql="select contractNo from ContractBean";
		try{
			Query query=manager.createQuery(jpql);
		
		List<Integer> list=query.getResultList();
		for (Integer id : list) {
			if(id==contractId)
				return true;
		}
		return false;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean addContract(ContractBean contractBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
		transaction.begin();
		manager.persist(contractBean);
		transaction.commit();
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}
	

	public boolean deleteContract(int contractId) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
		ContractBean contractBean=manager.find(ContractBean.class, contractId);
		if(contractBean!=null) {
			transaction.begin();
			manager.remove(contractBean);
			transaction.commit();
			return true;
		}
		manager.close();
		return false;
	}catch(Exception e) {
		return false;
	}
	}

	public List<ContractBean> seeAllContracts() {
		EntityManager manager=factory.createEntityManager();
		String jpql="from ContractBean";
		try {
		Query query=manager.createQuery(jpql);
		List<ContractBean> list=query.getResultList();
		return list;
		}catch(Exception e) {
			return null;
		}
	}


}
