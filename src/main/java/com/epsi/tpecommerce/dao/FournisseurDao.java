package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Fournisseur;
import com.epsi.tpecommerce.entity.User;
import org.hibernate.Query;

public class FournisseurDao extends AbstractDao<Fournisseur,Integer> {

    public FournisseurDao() {super(); }

    public Fournisseur find(int id) {
        return this.find(Fournisseur.class, id);
    }

    public void addFournisseur(Fournisseur p_fournisseur){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDFOURNISSEUR(:nom, :email)")
    			.setString("nom", p_fournisseur.getNom())
    			.setString(":email", p_fournisseur.getEmail())
    			.executeUpdate();
    	
    	this.session.getTransaction().commit();
    }

}
