package com.capgemini.forestmanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemspringrest.bean.ClientBean;
import com.capgemini.forestmanagementsystemspringrest.dao.ClientDao;
import com.capgemini.forestmanagementsystemspringrest.dao.ClientDaoImpl;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;

	public boolean login(int id, String pass) {
		return clientDao.login(id, pass);
	}

	public boolean addClient(ClientBean clientBean) {
		return clientDao.addClient(clientBean);

	}

	public boolean clientVerification(int id) {
		return clientDao.clientVerification(id);
	}

	public boolean deleteClient(String email) {
		return clientDao.deleteClient(email);
	}

	public boolean modifyName(int clientid, String clientName) {
		// TODO Auto-generated method stub
		return clientDao.modifyName(clientid, clientName);
	}

	public boolean modifyAddress1(int clientid, String address1) {
		// TODO Auto-generated method stub
		return clientDao.modifyAddress1(clientid, address1);
	}

	public boolean modifyAddress2(int clientid, String address2) {
		// TODO Auto-generated method stub
		return clientDao.modifyAddress2(clientid, address2);
	}

	public boolean modifyTown(int clientid, String town) {
		// TODO Auto-generated method stub
		return clientDao.modifyTown(clientid, town);
	}

	public boolean modifyEmail(int clientid, String email) {
		// TODO Auto-generated method stub
		return clientDao.modifyEmail(clientid, email);
	}

	public boolean modifyTelephone(int clientid, long telephone) {
		// TODO Auto-generated method stub
		return clientDao.modifyTelephone(clientid, telephone);
	}

	 public boolean modifyClientInfo(ClientBean recievedClientBean) {
		// TODO Auto-generated method stub
		return clientDao.modifyClientInfo( recievedClientBean);
	}

	public List<ClientBean> getAllClientsInfo() {
		// TODO Auto-generated method stub
		return clientDao.getAllClientsInfo();
	}

	public ClientBean getClientInfo(String email) {
		// TODO Auto-generated method stub
		return clientDao.getClientInfo(email);
	}

}
