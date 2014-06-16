package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.ApprovisionnementDao;
import com.epsi.tpecommerce.entity.Approvisionnement;

public class ApprovisionnementService {
	
	ApprovisionnementDao approvisionnementDao;
	
	public ApprovisionnementService() {
		approvisionnementDao = new ApprovisionnementDao();
	}

	public Approvisionnement find(int id) {
		return approvisionnementDao.find(id);
	}
}
