package com.epsi.tpecommerce.common;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils
{
	private final SessionFactory factory;
	private Session session;

	public HibernateUtils()
	{
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public Session getInstance()
	{
		if(session == null)
		{
			session = factory.openSession();
		}
		return session;
	}

}
