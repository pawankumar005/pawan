package com.capgemini.forestmanagementsystemspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductResponse;
import com.capgemini.forestmanagementsystemspringrest.service.ProductService;
@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductBean productBean) {
		ProductResponse productResponse = new ProductResponse();

		if (productService.addProduct(productBean)) {
			productResponse.setStatusCode(200);
			productResponse.setMessage("success");
			productResponse.setDescription("Product added");
		}
		return productResponse;
	}

	@DeleteMapping(path = "/delete-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ProductResponse deleteProducts(@PathVariable("id") int id) {

		ProductResponse response = new ProductResponse();
		productService.deleteProduct(id);
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDescription("product deleted");
		return response;

	}

	@GetMapping(path = "/get-all-products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAllproducts() {
		ProductResponse response = new ProductResponse();
		List<ProductBean> productBeans = (productService.sellAllproducts());
		if (productBeans.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("list of products");
			response.setProductBeans(productBeans);
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("No products present");

		}
		return response;

	}

}
