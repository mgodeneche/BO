package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.HistoStatutCmdDao;
import com.epsi.tpecommerce.entity.HistoriqueStatutCmd;

public class HistoStatutCmdService {
	
	HistoStatutCmdDao histoStatutCmdDao;
	
	public HistoStatutCmdService() {
		histoStatutCmdDao = new HistoStatutCmdDao();
	}

	public HistoriqueStatutCmd find(int id) {
		return histoStatutCmdDao.find(id);
	}
	
	public void addHistoriqueStatutCmd(HistoriqueStatutCmd p_histo){
		histoStatutCmdDao.addHistoriqueStatutCmd(p_histo);
	}
}
