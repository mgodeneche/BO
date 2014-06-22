package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Categorie;

public class CategorieDao extends AbstractDao<Categorie,Integer>{
	public CategorieDao() {
        super();
    }
    public Categorie find(int id) {
        return this.find(Categorie.class, id);
    }
    
    public void addCategorie(Categorie p_categorie) {
    	this.session.beginTransaction();
    	
        int exRows = this.session.createSQLQuery(
    			"CALL ADDCATEGORIE(:nom)")
    			.setString("nom", p_categorie.getNom())
    			.executeUpdate();
        
        this.session.getTransaction().commit();
    }
}
