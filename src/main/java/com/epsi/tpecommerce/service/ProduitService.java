package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.ProduitDao;
import com.epsi.tpecommerce.entity.Produit;

public class ProduitService {
	
	ProduitDao produitDao;
	
	public ProduitService() {
		produitDao = new ProduitDao();
	}

	public Produit find(int id) {
		return produitDao.find(id);
	}
}
