package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Categorie;

public class CategorieDao extends AbstractDao<Categorie,Integer>{
	public CategorieDao() {
        super();
    }
    public Categorie find(int id) {
        return this.find(Categorie.class, id);
    }
}
