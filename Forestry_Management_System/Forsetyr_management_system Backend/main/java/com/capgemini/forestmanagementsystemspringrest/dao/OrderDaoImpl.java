package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemspringrest.Exceptions.OrderException;
import com.capgemini.forestmanagementsystemspringrest.bean.ClientBean;
import com.capgemini.forestmanagementsystemspringrest.bean.OrderBean;
@Repository
public class OrderDaoImpl implements OrderDao{
	@PersistenceUnit
	EntityManagerFactory factory;

	public boolean addOrder(OrderBean orderBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(orderBean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}


	public boolean deleteOrder(int orderid) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
		OrderBean orderBean=manager.find(OrderBean.class, orderid);
		if(orderBean!=null) {
			transaction.begin();
			manager.remove(orderBean);
			transaction.commit();
			return true;
		}
		manager.close();
		return false;
	}catch(Exception e) {
		throw new OrderException("OrderId not found");
	}
	}
	public boolean orderIdCheck(int orderid) {
		EntityManager manager=factory.createEntityManager();
		String jpql="select orderNo from OrderBean";
		Query query=manager.createQuery(jpql);
		List<Integer> list=query.getResultList();
		for (Integer id : list) {
			if(id==orderid)
				return true;
		}
		return false;

	}

	public List<OrderBean> seeAllOrders() {
		EntityManager manager=factory.createEntityManager();
		String jpql="from OrderBean";
		Query query=manager.createQuery(jpql);
		List<OrderBean> list=query.getResultList();
		return list;
	}


	@Override
	public List<OrderBean> SeeMyOrders(int clientId) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from OrderBean where clientId=:id";
		Query query=manager.createQuery(jpql);
		query.setParameter("id", clientId);
		try {
			List<OrderBean> orderBeans =query.getResultList();

			return orderBeans;
		}catch(Exception e) {
			return null;
		}
	}


	@Override
	public boolean updateStatus(OrderBean recievedOrderBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			OrderBean orderBean = manager.find(OrderBean.class, recievedOrderBean.getOrderNo());
			transaction.begin();
			orderBean.setStatus(recievedOrderBean.getStatus());
			orderBean.setExpectedDeliveryDate(recievedOrderBean.getExpectedDeliveryDate());
			transaction.commit();
			return true;

		}catch(Exception e) {
			return false;
		}


	}


	@Override
	public List<OrderBean> getOrderInfo(String email) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from OrderBean where email=:email";
		Query query=manager.createQuery(jpql);
		query.setParameter("email", email);
		try {

			List<OrderBean> ordersList=query.getResultList();

			return ordersList;
		}catch(Exception e) {
			return null;
		}
	}


	@Override
	public OrderBean getOrderInfo(int id) {
		EntityManager manager=factory.createEntityManager();

		try {
			OrderBean orderBean=manager.find(OrderBean.class, id);
			return orderBean;

		}catch(Exception e) {
			throw new OrderException("Order not found for thid id");
		}
	}
}
