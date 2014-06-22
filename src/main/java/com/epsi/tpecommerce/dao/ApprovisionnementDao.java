package com.epsi.tpecommerce.dao;

import java.text.SimpleDateFormat;

import com.epsi.tpecommerce.entity.Approvisionnement;

public class ApprovisionnementDao extends AbstractDao<Approvisionnement,Integer>{
	public ApprovisionnementDao() {
        super();
    }
    public Approvisionnement find(int id) {
        return this.find(Approvisionnement.class, id);
    }
    
    public void addApprovisionnement(Approvisionnement p_approvisionnement) {
    	this.session.beginTransaction();
    	
        int exRows = this.session.createSQLQuery(
    			"CALL ADDAPPROVISIONNEMENT(:idProduit, :dateCommande, :qte, :reception)")
    			.setInteger("idProduit", p_approvisionnement.getProduit().getIdProduit())
    			.setString("dateCommande", new SimpleDateFormat("yyyy/MM/dd h:m:s")
    						.format(p_approvisionnement.getDateCommande().getTime()))
    			.setInteger("qte", p_approvisionnement.getQte())
    			.setInteger("reception", p_approvisionnement.getReception())
    			.executeUpdate();
        
        this.session.getTransaction().commit();
    }
}
