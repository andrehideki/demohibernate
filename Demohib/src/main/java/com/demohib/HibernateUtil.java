package com.demohib;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure().build();
			Configuration config = new Configuration().configure();	
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			
		}
		
		return sessionFactory;
	}
}
