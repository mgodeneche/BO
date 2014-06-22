package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.HistoriqueStatutCmd;

public class HistoStatutCmdDao extends AbstractDao<HistoriqueStatutCmd,Integer> {
    public HistoStatutCmdDao() {
        super();
    }
    public HistoriqueStatutCmd find(int id) {
        return this.find(HistoriqueStatutCmd.class, id);
    }
    
    public void addHistoriqueStatutCmd(HistoriqueStatutCmd p_histo){
    	this.session.beginTransaction();
    	
    	int exRows = this.session.createSQLQuery(
    			"CALL ADDHISTORIQUESTATUTCMD(:idStatut, :idCommande, :dateStatut)")
    			.setInteger("idStatut", p_histo.getIdHistoStatutCmd())
    			.setInteger("idCommande", p_histo.getCommande().getIdCommande())
    			.executeUpdate();
    	
    	this.session.getTransaction().commit();
    }
}
