package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Tva;

public class TvaDao extends AbstractDao<Tva,Integer>{
	public TvaDao() {
        super();
    }
    public Tva find(int id) {
        return this.find(Tva.class, id);
    }
}
