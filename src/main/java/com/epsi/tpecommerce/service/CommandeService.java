package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.CommandeDao;
import com.epsi.tpecommerce.entity.Commande;

public class CommandeService {
	
	CommandeDao commandeDao;
	
	public CommandeService() {
		commandeDao = new CommandeDao();
	}
	
	
	public void addCommande(Commande p_commande){
		commandeDao.addCommande(p_commande);
	}
	
	public Integer getNombreCommandeDuMoisAnnee(String p_mois, String p_annee){
		return commandeDao.getNombreCommandeDuMoisAnnee(p_mois, p_annee);
	}
	
	public Integer getQuantiteMoyenneParCommande(){
		return commandeDao.getQuantiteMoyenneParCommande();
	}
}
