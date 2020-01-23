package com.capgemini.forestmanagementsystemspringrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemspringrest.bean.LoginBean;
import com.capgemini.forestmanagementsystemspringrest.dao.LoginDao;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao loginDao;

	@Override
	public LoginBean login(String email, String password) {
		return loginDao.login(email, password);
	}

	@Override
	public boolean add(LoginBean loginBean) {
		// TODO Auto-generated method stub
		return loginDao.add(loginBean);
	}

	@Override
	public boolean loginIdCheck(int id) {
		// TODO Auto-generated method stub
		return loginDao.loginIdCheck(id);
	}

	@Override
	public boolean deleteAccount(String email) {
		// TODO Auto-generated method stub
		return loginDao.deleteAccount(email);
	}

	@Override
	public boolean changePassword(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.changePassword(email, password);
	}

}
