package com.epsi.tpecommerce.dao;

import java.util.List;

import org.hibernate.Query;

import com.epsi.tpecommerce.entity.Produit;

public class ProduitDao extends AbstractDao<Produit,Integer>{
	public ProduitDao() {
        super();
    }
    public Produit find(int id) {
        return this.find(Produit.class, id);
    }
    
    public void addProduit(Produit p_produit){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDPRODUIT(:idFournisseur, :idTva, :idSousCategorie, :nom, :description, :qteStock)")
    			.setInteger("idFournisseur", p_produit.getFournisseur().getIdFournisseur())
    			.setInteger("idTva", p_produit.getTva().getIdTva())
    			.setInteger("idSousCategorie", p_produit.getSousCategorie().getIdSousCat())
    			.setString("nom", p_produit.getNom())
    			.setString("description", p_produit.getDescription())
    			.setInteger("qteStock", p_produit.getQteStock())
    			.executeUpdate();
    	
    	this.session.getTransaction().commit();
    }
    
    public void editProduit(Produit p_produit){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL EDITPRODUIT(:idProduit, :idFournisseur, :idTva, :idSousCategorie, :nom, :description, :qteStock)")
    			.setInteger("idProduit", p_produit.getIdProduit())
    			.setInteger("idFournisseur", p_produit.getFournisseur().getIdFournisseur())
    			.setInteger("idTva", p_produit.getTva().getIdTva())
    			.setInteger("idSousCategorie", p_produit.getSousCategorie().getIdSousCat())
    			.setString("nom", p_produit.getNom())
    			.setString("description", p_produit.getDescription())
    			.setInteger("qteStock", p_produit.getQteStock())
    			.executeUpdate();
    	
    	this.session.getTransaction().commit();
    }
    
    public List<Produit> getMeilleursProduits(int p_nombreProduits){
    	this.session.beginTransaction();
    	
    	Query query = this.session.createSQLQuery(
    			"SELECT F_PRODUITSPOPULAIRES");
    	
    	this.session.getTransaction().commit();
    	
    	return (List<Produit>)query.setMaxResults(p_nombreProduits).list();
    }
}
