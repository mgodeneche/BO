package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.Client;
import java.util.List;

import com.epsi.tpecommerce.entity.User;
import org.hibernate.Query;

/**
 * Created by Maxence on 04/06/2014.
 */
public class ClientDao extends AbstractDao<Client,Integer> {

    public ClientDao() {
        super();
    }
    public Client find(int id) {
        return this.find(Client.class, id);
    }
    public Client findByLogin(String login) {
        this.session.beginTransaction();
        String queryString = "from CLIENT where login = :login";
        Query query = this.session.createQuery(queryString);
        query.setString("login", login);
        Object queryResult = query.uniqueResult();
        Client client = (Client)queryResult;
        this.session.getTransaction().commit();
        return client;
    }
}
