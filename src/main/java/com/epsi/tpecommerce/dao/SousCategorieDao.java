package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.SousCategorie;

public class SousCategorieDao extends AbstractDao<SousCategorie,Integer>{
	public SousCategorieDao() {
        super();
    }
    public SousCategorie find(int id) {
        return this.find(SousCategorie.class, id);
    }
}
