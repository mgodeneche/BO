package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Approvisionnement;

public class ApprovisionnementDao extends AbstractDao<Approvisionnement,Integer>{
	public ApprovisionnementDao() {
        super();
    }
    public Approvisionnement find(int id) {
        return this.find(Approvisionnement.class, id);
    }
}
