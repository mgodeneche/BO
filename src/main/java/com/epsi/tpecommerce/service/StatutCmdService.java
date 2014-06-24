package com.epsi.tpecommerce.service;

import com.epsi.tpecommerce.dao.StatutCmdDao;
import com.epsi.tpecommerce.entity.StatutCmd;

public class StatutCmdService {
	
	StatutCmdDao statutCmdDao;
	
	public StatutCmdService() {
		statutCmdDao = new StatutCmdDao();
	}

	public StatutCmd find(int id) {
		return statutCmdDao.find(id);
	}
	
	public void addStatutCmd(StatutCmd p_statutCmd){
		statutCmdDao.addStatutCmd(p_statutCmd);
	}
}
