package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Fournisseur;
import com.epsi.tpecommerce.entity.User;
import org.hibernate.Query;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
public class FournisseurDao extends AbstractDao<Fournisseur,Integer> {

    public FournisseurDao() {super(); }

    public Fournisseur find(int id) {
        return this.find(Fournisseur.class, id);
    }

    public Fournisseur findByEmail(String email) {
        this.session.beginTransaction();
        String queryString = "from Fournisseur where email = :email";
        Query query = this.session.createQuery(queryString);
        query.setString("email", email);
        Object queryResult = query.uniqueResult();
        Fournisseur fournisseur = (Fournisseur)queryResult;
        this.session.getTransaction().commit();
        return fournisseur;
    }

}
