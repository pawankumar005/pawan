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

import com.capgemini.forestmanagementsystemspringrest.bean.ContractBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ContractResponse;
import com.capgemini.forestmanagementsystemspringrest.bean.OrderBean;
import com.capgemini.forestmanagementsystemspringrest.bean.ProductBean;
import com.capgemini.forestmanagementsystemspringrest.service.ContractService;
import com.capgemini.forestmanagementsystemspringrest.service.OrderService;
import com.capgemini.forestmanagementsystemspringrest.service.ProductService;
@CrossOrigin
@RestController
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private OrderService orderService;
	

	@PostMapping(path = "/add-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse addContract(@RequestBody ContractBean contractBean) {
		ContractResponse contractResponse = new ContractResponse();

		if (contractService.addContract(contractBean)) {
			OrderBean orderBean= orderService.getOrderInfo(contractBean.getOrderNo());
			orderBean.setExpectedDeliveryDate(contractBean.getDeliveryDate());
			orderBean.setStatus(contractBean.getStatus());
			orderService.updateStatus(orderBean);
			
			contractResponse.setStatusCode(200);
			contractResponse.setMessage("success");
			contractResponse.setDescription("Contract added");
		}
		return contractResponse;
	}

	@DeleteMapping(path = "/delete-contract/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ContractResponse deleteEmployee(@PathVariable("id") int id) {

		ContractResponse response = new ContractResponse();
		contractService.deleteContract(id);
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDescription("contract deleted");
		return response;

	}
	@GetMapping(path="/get-all-contracts",produces= MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse getAllContracts() {
		ContractResponse response= new ContractResponse();
		List<ContractBean> contractBeans=(contractService.seeAllContracts()) ;
		if(contractBeans.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("list of contracts");
			response.setContractBeans(contractBeans);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("No contracts present");
			
		}
		return response;


	}

}
