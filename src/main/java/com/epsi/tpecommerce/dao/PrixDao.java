package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Prix;

public class PrixDao extends AbstractDao<Prix,Integer>{
	public PrixDao() {
        super();
    }
    public Prix find(int id) {
        return this.find(Prix.class, id);
    }
    
    public void addPrix(Prix p_prix){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDPRIX(:prix)")
    			.setDouble("prix", p_prix.getPrix())
    			.executeUpdate();
    	
    	this.session.getTransaction().commit();
    }
}
