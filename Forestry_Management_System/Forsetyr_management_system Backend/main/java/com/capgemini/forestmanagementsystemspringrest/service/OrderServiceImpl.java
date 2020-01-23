package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemspringrest.Exceptions.OrderException;
import com.capgemini.forestmanagementsystemspringrest.bean.ContractBean;
import com.capgemini.forestmanagementsystemspringrest.bean.OrderBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
import com.capgemini.forestmanagementsystemspringrest.dao.ContractDao;
import com.capgemini.forestmanagementsystemspringrest.dao.OrderDao;
import com.capgemini.forestmanagementsystemspringrest.dao.OrderDaoImpl;
import com.capgemini.forestmanagementsystemspringrest.dao.ProductDao;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	@Autowired
	ProductService productService;
	@Autowired
	ContractService contractService;


	public boolean addOrder(OrderBean orderBean) {
		ProductBean productBean= productService.getProductBean(orderBean.getProductId());
		if(orderBean.getQuantity()<=productBean.getQuantity()) {
			return orderDao.addOrder(orderBean);
		}else {
			throw new OrderException("Ordered Quantity is more than Available Quantity");
		}
	}


	public boolean deleteOrder(int orderId) {
		List<ContractBean> contractList= contractService.seeAllContracts();
		if(contractList.size()!=0) {
			for (ContractBean contractBean : contractList) {
				if(contractBean.getOrderNo()==orderId) {
					throw new OrderException("Order cannot be cancelled as it is shipped");
				}
			}
		}
		return orderDao.deleteOrder(orderId);

	}




	public boolean orderIdCheck(int orderid) {
		return orderDao.orderIdCheck(orderid);
	}


	public List<OrderBean> seeAllOrders() {
		return orderDao.seeAllOrders();
	}


	@Override
	public List<OrderBean> SeeMyOrders(int clientId) {
		return orderDao.SeeMyOrders(clientId);
	}


	@Override
	public boolean updateStatus(OrderBean orderBean) {

		return orderDao.updateStatus(orderBean);
	}


	@Override
	public List<OrderBean> getOrderInfo(String email) {

		return orderDao.getOrderInfo(email);
	}


	@Override
	public OrderBean getOrderInfo(int id) {

		return orderDao.getOrderInfo(id);
	}

}
