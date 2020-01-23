package com.capgemini.forestmanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.ContractBean;

public interface ContractDao {
	public boolean contractVerification(int contractId);
	public boolean addContract(ContractBean contractBean);
	public boolean deleteContract(int contractId);
	public List<ContractBean> seeAllContracts();

}
