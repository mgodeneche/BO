package com.epsi.tpecommerce.dao;

import com.epsi.tpecommerce.common.HibernateUtils;
import org.hibernate.Session;

import java.io.Serializable;

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
