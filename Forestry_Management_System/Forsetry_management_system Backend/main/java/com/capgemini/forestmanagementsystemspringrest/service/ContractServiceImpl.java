package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemspringrest.bean.ContractBean;
import com.capgemini.forestmanagementsystemspringrest.dao.ContractDao;
import com.capgemini.forestmanagementsystemspringrest.dao.ContractDaoImpl;
@Service
public class ContractServiceImpl implements  ContractService {
	@Autowired
	ContractDao contractDao;
	
	
	public boolean contractVerification(int contractid) {
		
		return contractDao.contractVerification(contractid);
	}

	
	public boolean addContract(ContractBean contractBean) {
		
		return contractDao.addContract(contractBean);
	}

	
	public boolean deleteContract(int contractid) {
		// TODO Auto-generated method stub
		return contractDao.deleteContract(contractid);
	}

	
	public List<ContractBean> seeAllContracts() {
		// TODO Auto-generated method stub
		return contractDao.seeAllContracts();
	}

}
