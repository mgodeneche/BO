package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.StatutCmd;

public class StatutCmdDao extends AbstractDao<StatutCmd, Integer> {

    public StatutCmdDao() {
        super();
    }

    public StatutCmd find(int id) {
        return this.find(StatutCmd.class, id);
    }

    public void addStatutCmd(StatutCmd p_statutCmd){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDSTATUTCMD(:nom)")
    			.setString("nom", p_statutCmd.getNom())
    			.executeUpdate();
    	
    	
    	this.session.getTransaction().commit();
    }
}
