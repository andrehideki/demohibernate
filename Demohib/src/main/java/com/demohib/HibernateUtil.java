package com.demohib;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.demohib.association.manytoone.unidirectional.Order;
import com.demohib.association.manytoone.unidirectional.OrderItem;
import com.demohib.association.onetoone.AnoCar;
import com.demohib.association.onetoone.AnoEngine;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure().build();
			Configuration config = new Configuration()
					.addAnnotatedClass(AnoCar.class)
					.addAnnotatedClass(AnoEngine.class)
					// oneToManyTest
					.addAnnotatedClass(Order.class)
					.addAnnotatedClass(OrderItem.class)
					.configure();	
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			
		}
		
		return sessionFactory;
	}
}
