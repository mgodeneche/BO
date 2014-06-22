package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public class ClientDao extends AbstractDao<Client,Integer> {

    public ClientDao() {
        super();
    }
    public Client find(int id) {
        return this.find(Client.class, id);
    }

    public void addClient(Client p_client) {
    	this.session.beginTransaction();
    	
        int exRows = this.session.createSQLQuery(
    			"CALL ADDCLIENT(:prenom, :nom, :email)")
    			.setString("prenom", p_client.getPrenom())
    			.setString("nom", p_client.getNom())
    			.setString("email", p_client.getEmail())
    			.executeUpdate();
        
        this.session.getTransaction().commit();
    }
    
    public Map<Client, Integer> getClientFideleNbCommandes(){
    	this.session.beginTransaction();
    	
    	Query query = this.session.createSQLQuery(
    			"CALL CLIENTFIDELENBCOMMANDES");
    	
    	Map<Client, Integer> clientsFideles = new HashMap<Client, Integer>();
    	
    	List<Object[]> resultQuery = (List<Object[]>)query.list();
    	
    	for(Object[] o : resultQuery) clientsFideles.put(this.find((Integer)o[0]), (Integer)o[1]);
    	
    	this.session.getTransaction().commit();
    	
    	return clientsFideles;
    }
    
    public Map<Client, Integer> getClientFideleNbProduits(){
    	this.session.beginTransaction();
    	
    	Query query = this.session.createSQLQuery(
    			"CALL CLIENTFIDELENBPRODUITS");
    	
    	Map<Client, Integer> clientsFideles = new HashMap<Client, Integer>();
    	
    	List<Object[]> resultQuery = (List<Object[]>)query.list();
    	
    	for(Object[] o : resultQuery) clientsFideles.put(this.find((Integer)o[0]), (Integer)o[1]);
    	
    	this.session.getTransaction().commit();
    	
    	return clientsFideles;
    }
    
    public Map<Client, Integer> getCommandeParClient(){
    	this.session.beginTransaction();
    	
    	Query query = this.session.createSQLQuery(
    			"SELECT F_NOMBRECMDPARCLIENT");
    	
    	Map<Client, Integer> commandeParClient = new HashMap<Client, Integer>();
    	
    	List<Object[]> resultQuery = (List<Object[]>)query.list();
    	
    	for(Object[] o : resultQuery) commandeParClient.put(this.find((Integer)o[0]), (Integer)o[1]);
    	
    	this.session.getTransaction().commit();
    	
    	return commandeParClient;
    }
}
