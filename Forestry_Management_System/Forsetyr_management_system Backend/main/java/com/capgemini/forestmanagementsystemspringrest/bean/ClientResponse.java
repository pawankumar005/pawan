package com.capgemini.forestmanagementsystemspringrest.bean;

import java.util.List;

import lombok.Data;
@Data
public class ClientResponse {
	private int statusCode;
	private String message;
	private String description;
	private ClientBean clientBean;
	private List<ClientBean> clientBeans;

}
