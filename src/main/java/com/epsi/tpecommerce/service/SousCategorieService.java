package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.SousCategorieDao;
import com.epsi.tpecommerce.entity.SousCategorie;

public class SousCategorieService {
	
	SousCategorieDao sousCategorieDao;
	
	public SousCategorieService() {
		sousCategorieDao = new SousCategorieDao();
	}

	public SousCategorie find(int id) {
		return sousCategorieDao.find(id);
	}
}
