package com.capgemini.forestmanagementsystemspringrest.Exceptions;

public class ContractException extends RuntimeException {
	String msg;

	public ContractException(String msg) {
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
