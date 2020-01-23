package com.capgemini.forestmanagementsystemspringrest.Exceptions;

public class LoginException extends RuntimeException{
	String msg;

	public LoginException(String msg) {
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
