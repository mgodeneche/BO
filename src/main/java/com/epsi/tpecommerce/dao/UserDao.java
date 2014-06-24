package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.entity.User;
import org.hibernate.Query;

import java.util.List;


public class UserDao extends AbstractDao<User, Integer>{

	public UserDao() {
		super();
	}
	
	public User find(int id) {
		return this.find(User.class, id);
	}

	public User findByLogin(String login) {
		this.session.beginTransaction();
        String queryString = "from User where login = :login";
        Query query = this.session.createQuery(queryString);
        query.setString("login", login);
        Object queryResult = query.uniqueResult();  
        User user = (User)queryResult;
        this.session.getTransaction().commit(); 
        return user;
	}

    public User findByEmail(String email) {
		this.session.beginTransaction();
        String queryString = "from User where email = :email";
        Query query = this.session.createQuery(queryString);
        query.setString("email", email);
        Object queryResult = query.uniqueResult();
        User user = (User)queryResult;
        this.session.getTransaction().commit();
        return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getLastUsers(int nbUsers) {
		return session.createCriteria(User.class).setMaxResults(nbUsers).list();
	}


}
