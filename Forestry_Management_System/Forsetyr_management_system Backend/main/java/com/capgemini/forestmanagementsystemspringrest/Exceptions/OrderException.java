package com.capgemini.forestmanagementsystemspringrest.Exceptions;

public class OrderException extends RuntimeException {
	String msg;

	public OrderException(String msg) {
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