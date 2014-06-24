package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.PrixDao;
import com.epsi.tpecommerce.entity.Prix;

public class PrixService {
	
	PrixDao prixDao;
	
	public PrixService() {
		prixDao = new PrixDao();
	}

	public Prix find(int id) {
		return prixDao.find(id);
	}
	
	public void addPrix(Prix p_prix){
		prixDao.addPrix(p_prix);
	}
}
