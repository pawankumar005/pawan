package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
import com.capgemini.forestmanagementsystemspringrest.dao.ProductDao;
import com.capgemini.forestmanagementsystemspringrest.dao.ProductDaoImpl;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;

	
	public boolean addProduct(ProductBean productBean) {
		// TODO Auto-generated method stub
		return productDao.addProduct(productBean);
	}

	
	public boolean deleteProduct(int productid) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productid);
	}

	
	public List<ProductBean> sellAllproducts() {
		// TODO Auto-generated method stub
		return productDao.sellAllproducts();
	}

	
	public boolean productCheck(int productid) {
		// TODO Auto-generated method stub
		return productDao.productCheck(productid);
	}

	
	public boolean updateQuantity(int prodid, int quantity) {
		// TODO Auto-generated method stub
		return productDao.updateQuantity(prodid, quantity);
	}


	@Override
	public ProductBean getProductBean(int productId) {
		// TODO Auto-generated method stub
		return productDao.getProductBean(productId);
	}

}
