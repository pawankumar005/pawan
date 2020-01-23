package com.capgemini.forestmanagementsystemspringrest.bean;

import java.util.List;

import lombok.Data;
@Data
public class OrderResponse {
	private int statusCode;
	private String message;
	private String description;
	private OrderBean orderBean;
	private List<OrderBean> orderBeans;

}
