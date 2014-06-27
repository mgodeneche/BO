package com.epsi.tpecommerce.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.epsi.tpecommerce.common.HibernateUtils;

public abstract class AbstractDao<T, PK extends Serializable> {
	
	protected Session session;
	
	public AbstractDao() {
		session = new HibernateUtils().getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public T find(Class<T> c, PK id){
		return (T) session.load(c, id);
	}

}
