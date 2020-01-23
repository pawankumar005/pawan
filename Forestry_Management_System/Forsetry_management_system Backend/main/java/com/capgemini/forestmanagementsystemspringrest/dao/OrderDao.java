package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.OrderBean;

public interface OrderDao {
	public boolean addOrder(OrderBean orderBean);
	public boolean deleteOrder(int orderId);
	public boolean orderIdCheck(int orderId);
	public boolean updateStatus(OrderBean orderBean);
	public List<OrderBean> seeAllOrders();
	public List<OrderBean> SeeMyOrders(int clientId);
	public List<OrderBean> getOrderInfo(String email) ;
	public OrderBean getOrderInfo(int id) ;

}
