package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.StatutCmd;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
public class StatutCmdDao extends AbstractDao<StatutCmd, Integer> {

    public StatutCmdDao() {
        super();
    }

    public StatutCmd find(int id) {
        return this.find(StatutCmd.class, id);
    }


}
