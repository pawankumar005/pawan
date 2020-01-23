package com.capgemini.forestmanagementsystemspringrest.Exceptions;

public class ClientException extends RuntimeException{
	String msg;

	public ClientException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	


}
