package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean orderBean);
	public boolean deleteOrder(int orderid);
	public boolean orderIdCheck(int orderid);
	public List<OrderBean> seeAllOrders();
	public List<OrderBean> SeeMyOrders(int clientId);
	public boolean updateStatus(OrderBean orderBean);
	public List<OrderBean> getOrderInfo(String email) ;
	public OrderBean getOrderInfo(int id) ;

}
