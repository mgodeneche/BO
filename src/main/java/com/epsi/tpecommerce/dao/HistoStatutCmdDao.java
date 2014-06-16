package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.HistoriqueStatutCmd;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
public class HistoStatutCmdDao extends AbstractDao<HistoriqueStatutCmd,Integer> {
    public HistoStatutCmdDao() {
        super();
    }
    public HistoriqueStatutCmd find(int id) {
        return this.find(HistoriqueStatutCmd.class, id);
    }
}
