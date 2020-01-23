package com.capgemini.forestmanagementsystemspringrest.Exceptions;

public class ProductException extends RuntimeException{
	String msg;

	public ProductException(String msg) {
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
