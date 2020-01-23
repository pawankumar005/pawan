package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;

@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	public boolean addProduct(ProductBean productBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(productBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}

	public boolean deleteProduct(int productid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ProductBean productBean = manager.find(ProductBean.class, productid);
		if (productBean != null) {
			transaction.begin();
			manager.remove(productBean);
			transaction.commit();
			return true;
		}
		manager.close();
		return false;
	}

	public List<ProductBean> sellAllproducts() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);
		try {
			List<ProductBean> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean productCheck(int productid) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select productId from ProductBean";
		Query query = manager.createQuery(jpql);
		try {
			List<Integer> list = query.getResultList();
			for (Integer id : list) {
				if (id == productid)
					return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateQuantity(int productId, int quantity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			ProductBean productBean = manager.find(ProductBean.class, productId);
			transaction.begin();
			productBean.setQuantity(quantity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ProductBean getProductBean(int productId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			ProductBean productBean = manager.find(ProductBean.class, productId);
			if(productBean!=null) 
				return productBean;
				
			}catch(Exception e){
				return null;
			}
		
		return null;
	}

}
