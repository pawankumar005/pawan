package com.capgemini.forestmanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementsystemspringrest.Exceptions.ClientException;
import com.capgemini.forestmanagementsystemspringrest.Exceptions.ContractException;
import com.capgemini.forestmanagementsystemspringrest.Exceptions.OrderException;
import com.capgemini.forestmanagementsystemspringrest.Exceptions.ProductException;
import com.capgemini.forestmanagementsystemspringrest.bean.ClientResponse;
import com.capgemini.forestmanagementsystemspringrest.bean.ContractResponse;
import com.capgemini.forestmanagementsystemspringrest.bean.OrderResponse;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductResponse;
@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(ContractException.class)
	public ContractResponse handleContractException(ContractException e) {
		ContractResponse contractResponse = new ContractResponse();
		contractResponse.setStatusCode(501);
		contractResponse.setMessage("Exception");
		contractResponse.setDescription(e.getMsg());
		return contractResponse;
	}

	@ExceptionHandler(ClientException.class)
	public ClientResponse handleCustomerException(ClientException e) {
		ClientResponse customerResponse = new ClientResponse();
		customerResponse.setStatusCode(501);
		customerResponse.setMessage("Exception");
		customerResponse.setDescription(e.getMsg());
		return customerResponse;
	}

	@ExceptionHandler(ProductException.class)
	public ProductResponse handleProductException(ProductException e) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setStatusCode(501);
		productResponse.setMessage("Exception");
		productResponse.setDescription(e.getMsg());
		return productResponse;
	}

	@ExceptionHandler(OrderException.class)
	public OrderResponse handleLandException(OrderException e) {
		OrderResponse orderResponse=new OrderResponse();
		orderResponse.setStatusCode(501);
		orderResponse.setMessage("Exception");
		orderResponse.setDescription(e.getMsg());
		return orderResponse;
	}
	
	

}
