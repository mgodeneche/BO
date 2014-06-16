package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.TvaDao;
import com.epsi.tpecommerce.entity.Tva;

public class TvaService {
	
	TvaDao tvaDao;
	
	public TvaService() {
		tvaDao = new TvaDao();
	}

	public Tva find(int id) {
		return tvaDao.find(id);
	}
}
