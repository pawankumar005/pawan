package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemspringrest.bean.ClientBean;

public interface ClientService {
	public boolean login(int id, String pass);
	public boolean addClient(ClientBean clientBean);
	public boolean clientVerification(int id);
	
	public boolean deleteClient(String email);
	public boolean modifyName( int clientId,String clientName);
	public boolean modifyAddress1(int clientId, String address1);
	public boolean modifyAddress2(int clientId, String address2);
	public boolean modifyTown( int clientId,String town);
	public boolean modifyEmail(int clientId, String email);
	public boolean modifyTelephone(int clientId, long telephone);
	public boolean modifyClientInfo(ClientBean recievedClientBean);
	public ClientBean getClientInfo(String email);
	public List<ClientBean> getAllClientsInfo();
	
}
