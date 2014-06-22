package com.epsi.tpecommerce.dao;

import java.text.SimpleDateFormat;

import com.epsi.tpecommerce.entity.Catalogue;

public class CatalogueDao extends AbstractDao<Catalogue,Integer>{
	public CatalogueDao() {
        super();
    }
	
	public void addCatalogue(Catalogue p_catalogue){
		this.session.beginTransaction();
		
		int exRows = this.session.createSQLQuery(
    			"CALL ADDCATALOGUE(:idCatalogue, :idProduit, :idTva, :idPrix, :nom, :dateDebut, :dateFin)")
    			.setInteger("idProduit", p_catalogue.getIdCatalogue())
    			.setInteger("idProduit", p_catalogue.getProduit().getIdProduit())
    			.setInteger("idTva", p_catalogue.getTva().getIdTva())
    			.setInteger("idPrix", p_catalogue.getPrix().getIdPrix())
    			.setString("nom", p_catalogue.getNom())
    			.setString("dateDebut", new SimpleDateFormat("yyyy/MM/dd h:m:s")
    						.format(p_catalogue.getDateDebut().getTime()))
    			.setString("dateFin", new SimpleDateFormat("yyyy/MM/dd h:m:s")
    						.format(p_catalogue.getDateFin().getTime()))
    			    			.executeUpdate();
        
        this.session.getTransaction().commit();
	}
}
