package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.FournisseurDao;
import com.epsi.tpecommerce.entity.Fournisseur;

public class FournisseurService {
	FournisseurDao fournisseurDao;
	
	public FournisseurService(){
		fournisseurDao= new FournisseurDao();
	}
	
	public Fournisseur find(int id){
		return fournisseurDao.find(id);
	}
	
	public void addFournisseur(Fournisseur p_fournisseur){
		fournisseurDao.addFournisseur(p_fournisseur);
	}
}
