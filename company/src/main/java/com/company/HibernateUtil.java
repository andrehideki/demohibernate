package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	private static EntityManagerFactory factory;
	
	public static final String COMPANYDB = "companyDB";
	
	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("companyDB");
		return factory.createEntityManager();
	}
}

