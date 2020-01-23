package com.capgemini.forestmanagementsystemspringrest.dao;

import com.capgemini.forestmanagementsystemspringrest.bean.LoginBean;

public interface LoginDao {
	public LoginBean login(String email , String password);
	public boolean add(LoginBean loginBean);
	public boolean loginIdCheck(int id);
	public boolean deleteAccount(String email);
	public boolean changePassword(String email, String password);

}
