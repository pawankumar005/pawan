package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean productBean);
	public boolean deleteProduct(int productid);
	public List<ProductBean> sellAllproducts();
	public boolean productCheck(int productid);
	public boolean updateQuantity(int prodid, int quantity);
	public ProductBean getProductBean(int productId);

}
