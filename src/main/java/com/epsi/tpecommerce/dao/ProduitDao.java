package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Produit;

public class ProduitDao extends AbstractDao<Produit,Integer>{
	public ProduitDao() {
        super();
    }
    public Produit find(int id) {
        return this.find(Produit.class, id);
    }
}
