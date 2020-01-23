package com.capgemini.forestmanagementsystemspringrest.controller;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemspringrest.bean.LoginBean;
import com.capgemini.forestmanagementsystemspringrest.bean.LoginResponse;
import com.capgemini.forestmanagementsystemspringrest.service.LoginService;
@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	@PostMapping(path="/login", produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public  LoginResponse auth(@RequestBody LoginBean bean) {
		LoginBean loginBean= loginService.login(bean.getEmail(), bean.getPassword());

		LoginResponse response= new LoginResponse();
		if(loginBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("login successfull");
			response.setLoginBeans(Arrays.asList(loginBean));
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("invalid credentials");
		}
		return response;
	}


}
