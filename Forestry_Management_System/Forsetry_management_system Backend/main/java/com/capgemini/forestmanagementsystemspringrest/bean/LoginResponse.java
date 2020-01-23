package com.capgemini.forestmanagementsystemspringrest.bean;

import java.util.List;

import lombok.Data;
@Data
public class LoginResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<LoginBean> LoginBeans;

}
