package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemspringrest.bean.ClientBean;
import com.capgemini.forestmanagementsystemspringrest.bean.LoginBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
@Repository
public class ClientDaoImpl  implements ClientDao{
	@PersistenceUnit
	EntityManagerFactory factory;
	public boolean login(int id, String pass) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from ClientBean where ClientId=:id and password=:pass";
		Query query=manager.createQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("pass", pass);
		try {
			Object object =query.getSingleResult();
			ClientBean clientBean=(ClientBean) object;
			if(clientBean!=null)
				return true;
			else
				return false;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean addClient(ClientBean clientBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(clientBean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}

	public boolean clientVerification(int id) {
		EntityManager manager=factory.createEntityManager();
		String jpql="select clientId from ClientBean";
		Query query=manager.createQuery(jpql);
		try {
		List<Integer> list=query.getResultList();
		for (Integer clientid : list) {
			if(clientid==id)
				return true;
		}
		return false;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean deleteClient(String email) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		String jpql="from ClientBean where email=:email";
		Query query=manager.createQuery(jpql);
		try {
			query.setParameter("email", email);
			Object object =query.getSingleResult();
			ClientBean clientBean=(ClientBean) object;
			manager.getTransaction();
			if(clientBean!=null) {
				transaction.begin();
				manager.remove(clientBean);
				transaction.commit();
				return true;
			}else 
				return false;

		}catch(Exception e) {
			return false;
		}
	}

	public boolean modifyName(int clientid, String clientName) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			ClientBean clientBean=manager.find(ClientBean.class, clientid);
			transaction.begin();
			clientBean.setClientName(clientName);
			transaction.commit();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public boolean modifyAddress1(int clientid, String address1) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			ClientBean clientBean=manager.find(ClientBean.class, clientid);
			transaction.begin();
			clientBean.setStreetAddress1(address1);
			transaction.commit();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public boolean modifyAddress2(int clientid, String address2) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			ClientBean clientBean=manager.find(ClientBean.class, clientid);
			transaction.begin();
			clientBean.setStreetAddress2(address2);
			transaction.commit();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public boolean modifyTown(int clientId, String town) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			ClientBean clientBean=manager.find(ClientBean.class, clientId);
			transaction.begin();
			clientBean.setTown(town);
			transaction.commit();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public boolean modifyEmail(int clientId, String email) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			ClientBean clientBean=manager.find(ClientBean.class, clientId);
			transaction.begin();
			clientBean.setEmail(email);
			transaction.commit();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}


	public boolean modifyTelephone(int clientId, long telephone) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			ClientBean clientBean=manager.find(ClientBean.class, clientId);
			transaction.begin();
			clientBean.setTelephone(telephone);
			transaction.commit();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public boolean modifyClientInfo( ClientBean recievedClientBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			ClientBean clientBean = manager.find(ClientBean.class, recievedClientBean.getClientId());
			transaction.begin();
			clientBean.setClientName(recievedClientBean.getClientName());
			
			clientBean.setPostalCode(recievedClientBean.getPostalCode());
			clientBean.setStreetAddress1(recievedClientBean.getStreetAddress1());
			clientBean.setStreetAddress2(recievedClientBean.getStreetAddress2());
			clientBean.setTelephone(recievedClientBean.getTelephone());
			clientBean.setTown(recievedClientBean.getTown());
			clientBean.setPostalCode(recievedClientBean.getPostalCode());
			clientBean.setPassword(recievedClientBean.getPassword());
			transaction.commit();
			return true;
			
	
		}catch(Exception e) {
			return false;
		}
		
		
	}



	public ClientBean getClientInfo(String email) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from ClientBean where email=:email";
		Query query=manager.createQuery(jpql);
		query.setParameter("email", email);
		try {
		Object object =query.getSingleResult();
		ClientBean clientBean=(ClientBean) object;
		return clientBean;
		}catch(Exception e) {
			return null;
		}
	}

	public List<ClientBean> getAllClientsInfo() {
		EntityManager manager=factory.createEntityManager();
		String jpql="from ClientBean";
		Query query=manager.createQuery(jpql);
		try {
		List<ClientBean> list=query.getResultList();
		return list;
		}catch(Exception e) {
			return null;
		}
	}

}
