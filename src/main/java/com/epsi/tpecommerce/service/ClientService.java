package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.ClientDao;
import com.epsi.tpecommerce.entity.Client;

public class ClientService {
	
	ClientDao clientDao;
	
	public ClientService() {
		clientDao = new ClientDao();
	}

	public Client find(int id) {
		return clientDao.find(id);
	}
}
