package com.epsi.tpecommerce.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.hibernate.jdbc.Work;

import com.epsi.tpecommerce.entity.Commande;

public class CommandeDao extends AbstractDao<Commande,Integer>{
	public CommandeDao() {
        super();
    }
	
	public void addCommande(Commande p_commande){
		this.session.beginTransaction();
		
		int exRows = this.session.createSQLQuery(
				"CALL ADDCLIENT(:idCommande, :idCLient, :idProduit, :dateCommande, :qte)")
    			.setInteger("idCommande", p_commande.getIdCommande())
    			.setInteger("idClient", p_commande.getClient().getIdClient())
    			.setInteger("idProduit", p_commande.getProduit().getIdProduit())
    			.setString("dateCommande", new SimpleDateFormat("yyyy/MM/dd h:m:s")
    						.format(p_commande.getDateCommande().getTime()))
    			.setInteger("qqte", p_commande.getQte())
    			.executeUpdate();
		
		this.session.getTransaction().commit();
	}
	
	public Integer getNombreCommandeDuMoisAnnee(String p_mois, String p_annee){
		this.session.beginTransaction();
		
		Integer nombreCommandes = (Integer)this.session.createSQLQuery(
				"SELECT F_GETNBRECOMMDUMOISANNEE(:mois, :annee)")
				.setString("mois",  p_mois)
				.setString("annee", p_annee)
				.uniqueResult();
		
		this.session.getTransaction().commit();
		
		return nombreCommandes;
	}
	
	public Integer getQuantiteMoyenneParCommande(){
		this.session.beginTransaction();
		
		Integer qteMoyenne = (Integer)this.session.createSQLQuery(
				"SELECT F_QTEMOYENNEPARCOMMANDE")
				.uniqueResult();
		
		this.session.getTransaction().commit();
		
		return qteMoyenne;
	}
}
