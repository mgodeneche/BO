package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Tva;

public class TvaDao extends AbstractDao<Tva,Integer>{
	public TvaDao() {
        super();
    }
    public Tva find(int id) {
        return this.find(Tva.class, id);
    }
    
    public void addTva(Tva p_Tva){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDSTATUTCMD(:nom, :taux)")
    			.setString("nom", p_Tva.getNom())
    			.setDouble("taux", p_Tva.getTaux())
    			.executeUpdate();
    	
    	
    	this.session.getTransaction().commit();
    }
}
