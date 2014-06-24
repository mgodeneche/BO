package com.epsi.tpecommerce.service;

import java.util.Map;

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
	
	public void addClient(Client p_client){
		clientDao.addClient(p_client);
	}
	
	public Map<Client, Integer> getClientFideleNbCommandes(){
		return clientDao.getClientFideleNbCommandes();
	}
	
	public Map<Client, Integer> getClientFideleNbProduits(){
		return clientDao.getClientFideleNbProduits();
	}
	
	public Map<Client, Integer> getCommandeParClient(){
		return clientDao.getCommandeParClient();
	}
}
