package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Prix;

public class PrixDao extends AbstractDao<Prix,Integer>{
	public PrixDao() {
        super();
    }
    public Prix find(int id) {
        return this.find(Prix.class, id);
    }
}
