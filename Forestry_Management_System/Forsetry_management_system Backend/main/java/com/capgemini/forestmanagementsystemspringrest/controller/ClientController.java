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
import com.capgemini.forestmanagementsystemspringrest.bean.LoginBean;
import com.capgemini.forestmanagementsystemspringrest.service.ClientService;
import com.capgemini.forestmanagementsystemspringrest.service.LoginService;

@CrossOrigin(origins = "*", allowCredentials="true", allowedHeaders = "*")
@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;
	@Autowired
	private LoginService loginService;
	@PostMapping(path = "/client-register", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse signup(@RequestBody ClientBean clientBean) {
		ClientResponse clientResponse = new ClientResponse();
		LoginBean loginBean =new LoginBean();
		loginBean.setEmail(clientBean.getEmail());
		loginBean.setPassword(clientBean.getPassword());
		loginBean.setRole("client");
		if (clientService.addClient(clientBean) && loginService.add(loginBean)) {
			clientResponse.setStatusCode(200);
			clientResponse.setMessage("success");
			clientResponse.setDescription("Registered successfully");
			
		}
		else {
			clientResponse.setStatusCode(400);
			clientResponse.setMessage("Failure");
			clientResponse.setDescription("Email Id already present");
			
		}
		return clientResponse;
	}
	
	@DeleteMapping(path="/delete-client",produces= MediaType.APPLICATION_JSON_VALUE)
	private ClientResponse deleteEmployee(@RequestParam("email") String email) {
		
		ClientResponse response= new ClientResponse();
		if(clientService.deleteClient(email) && loginService.deleteAccount(email)) {
		response.setStatusCode(201);
		response.setMessage("success");
		response.setDescription("client deleted");
		return response;
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("client not found");
			return response;
		}
		

	}
	@GetMapping(path="/get-clientInfo",produces= MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse serachClient(@RequestParam ("email") String email) {
		ClientResponse response= new ClientResponse();
		ClientBean clientBean= clientService.getClientInfo(email) ;
		if(clientBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("client of "+ email+" found");
			response.setClientBean(clientBean);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("client of "+ email+" not found");
			
		}
		return response;


	}
	@GetMapping(path="/get-all-clients",produces= MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse getAllClients() {
		ClientResponse response= new ClientResponse();
		List<ClientBean> clientBeans=(clientService.getAllClientsInfo()) ;
		if(clientBeans.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("list of clients");
			response.setClientBeans(clientBeans);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("No clients present");
			
		}
		return response;


	}
	@PutMapping(path="/modify-account",produces= MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse modifyAccount(@RequestBody ClientBean clientBean) {
		ClientResponse response= new ClientResponse();
		if(clientService.modifyClientInfo(clientBean)){
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Modified successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to modify");
		}
		return response;
	}

	


}
