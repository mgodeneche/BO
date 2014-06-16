package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.CommandeDao;
import com.epsi.tpecommerce.entity.Commande;

public class CommandeService {
	
	CommandeDao commandeDao;
	
	public CommandeService() {
		commandeDao = new CommandeDao();
	}
}
