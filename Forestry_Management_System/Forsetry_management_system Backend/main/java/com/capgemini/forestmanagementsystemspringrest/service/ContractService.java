package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.ContractBean;

public interface ContractService {
	public boolean contractVerification(int contractid);
	public boolean addContract(ContractBean contractBean);
	public boolean deleteContract(int contractid);
	public List<ContractBean> seeAllContracts();

}
