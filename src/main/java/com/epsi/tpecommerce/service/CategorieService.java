package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.CategorieDao;
import com.epsi.tpecommerce.entity.Categorie;

public class CategorieService {
	
	CategorieDao categorieDao;
	
	public CategorieService() {
		categorieDao = new CategorieDao();
	}

	public Categorie find(int id) {
		return categorieDao.find(id);
	}
	
	public void addCategorie(Categorie p_categorie){
		categorieDao.addCategorie(p_categorie);
	}
}
