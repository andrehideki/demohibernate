package com.codejava;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.sql.ordering.antlr.Factory;

public class UserManager {
	
	private EntityManagerFactory factory;
	private EntityManager entityManager;
	
	public void setup() {
		factory = Persistence.createEntityManagerFactory("UsersDB");
		entityManager = factory.createEntityManager();
	}
	
	public void exit() {
		entityManager.close();
		factory.close();
	}
	
	public void save(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		UserManager manager = new UserManager();
		manager.setup();
		manager.save(new User(0l, "Silvana", "mail@mail.com", "1234",User.Gender.FEMALE));
		manager.exit();
	}
}
