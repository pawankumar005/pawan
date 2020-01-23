package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemspringrest.bean.LoginBean;

@Repository
public class LoginDaoImpl implements LoginDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	public LoginBean login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from LoginBean where email=:email and password=:pass";
		Query query = manager.createQuery(jpql);
		try {
			query.setParameter("email", email);
			query.setParameter("pass", password);
			Object object = query.getSingleResult();
			LoginBean loginBean = (LoginBean) object;
			if (loginBean != null)
				return loginBean;
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean add(LoginBean loginBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(loginBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}

	@Override
	public boolean loginIdCheck(int id) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select id from LoginBean";
		Query query = manager.createQuery(jpql);
		try {
			List<Integer> list = query.getResultList();
			for (Integer loginId : list) {
				if (loginId == id)
					return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAccount(String email) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		String jpql="from LoginBean where email=:email";
		Query query=manager.createQuery(jpql);
		try {
			query.setParameter("email", email);
			Object object =query.getSingleResult();
			LoginBean loginBean=(LoginBean) object;
			manager.getTransaction();
			if(loginBean!=null) {
				transaction.begin();
				manager.remove(loginBean);
				transaction.commit();
				return true;
			}else 
				return false;

		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean changePassword(String email, String password) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		String jpql="from LoginBean where email=:email";
		Query query=manager.createQuery(jpql);
		try {
			query.setParameter("email", email);
			Object object =query.getSingleResult();
			LoginBean loginBean=(LoginBean) object;
			manager.getTransaction();
			if(loginBean!=null) {
				transaction.begin();
				loginBean.setPassword(password);
				transaction.commit();
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;

		}
	}
}

