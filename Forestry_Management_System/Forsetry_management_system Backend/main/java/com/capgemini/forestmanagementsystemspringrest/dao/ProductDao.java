package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean productBean);
	public boolean deleteProduct(int productid);
	public List<ProductBean> sellAllproducts();
	public boolean productCheck(int productid);
	public ProductBean getProductBean(int productId);
    public boolean updateQuantity(int prodid, int quantity);

}
