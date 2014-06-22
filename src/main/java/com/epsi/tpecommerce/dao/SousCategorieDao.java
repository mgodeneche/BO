package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.SousCategorie;

public class SousCategorieDao extends AbstractDao<SousCategorie,Integer>{
	public SousCategorieDao() {
        super();
    }
    public SousCategorie find(int id) {
        return this.find(SousCategorie.class, id);
    }
    
    public void addSousCategorie(SousCategorie p_sousCategorie){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDSOUSCATEGORIE(:idCategorie, :nom)")
    			.setInteger("idCategorie", p_sousCategorie.getCategorie().getIdCat())
    			.setString("nom", p_sousCategorie.getNom())
    			.executeUpdate();
    	
    	this.session.getTransaction().commit();
    }
}
