package com.capgemini.forestmanagementsystemspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemspringrest.bean.ClientBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ClientResponse;
import com.capgemini.forestmanagementsystemspringrest.bean.OrderBean;
import com.capgemini.forestmanagementsystemspringrest.bean.OrderResponse;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
import com.capgemini.forestmanagementsystemspringrest.service.OrderService;
import com.capgemini.forestmanagementsystemspringrest.service.ProductService;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;

	@PostMapping(path = "/add-order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse addOrder(@RequestBody OrderBean orderBean) {
		int modifiedQuantity;
		OrderResponse orderResponse = new OrderResponse();

		if (orderService.addOrder(orderBean)) {
			ProductBean productBean = productService.getProductBean(orderBean.getProductId());
			modifiedQuantity = productBean.getQuantity() - orderBean.getQuantity();
			productService.updateQuantity(orderBean.getProductId(), modifiedQuantity);
			orderResponse.setStatusCode(200);
			orderResponse.setMessage("success");
			orderResponse.setDescription("Order placed");
		}
		return orderResponse;
	}

	@DeleteMapping(path = "/delete-order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private OrderResponse deleteOrder(@PathVariable("id") int id) {
		int modifiedQuantity;

		OrderResponse response = new OrderResponse();
		OrderBean orderBean = orderService.getOrderInfo(id);
		orderService.deleteOrder(id); 
		ProductBean productBean = productService.getProductBean(orderBean.getProductId());
		modifiedQuantity = orderBean.getQuantity() + productBean.getQuantity();
		productService.updateQuantity(orderBean.getProductId(), modifiedQuantity);
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDescription("product deleted");
		return response;


	}

	@GetMapping(path = "/get-all-orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse getAllOrders() {
		OrderResponse response = new OrderResponse();
		List<OrderBean> orderBeans = (orderService.seeAllOrders());
		if (orderBeans.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("list of orders");
			response.setOrderBeans(orderBeans);
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("No orders present");

		}
		return response;

	}

	@PutMapping(path = "/modify-order", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse modifyAccount(@RequestBody OrderBean orderBean) {
		OrderResponse response = new OrderResponse();
		if (orderService.updateStatus(orderBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to modify");
		}
		return response;
	}

	@GetMapping(path = "/get-orderInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse getOrder(@RequestParam("email") String email) {
		OrderResponse response = new OrderResponse();
		List<OrderBean> orderBeans = orderService.getOrderInfo(email);
		if (orderBeans.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("orders of " + email + " found");
			response.setOrderBeans(orderBeans);
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("orders of " + email + " not found");

		}
		return response;

	}
}
