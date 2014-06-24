package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.CatalogueDao;
import com.epsi.tpecommerce.entity.Catalogue;

public class CatalogueService {
	
	CatalogueDao catalogueDao;
	
	public CatalogueService() {
		catalogueDao = new CatalogueDao();
	}
	
	public void addCatalogue(Catalogue p_catalogue){
		catalogueDao.addCatalogue(p_catalogue);
	}
}
