package com.codejava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {
	
	protected SessionFactory sessionFactory;
	
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	public void exit() {
		sessionFactory.close();
	}
	
	public void create(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Book book = session.find(Book.class, id);
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}
	
    public static void main( String[] args ) {
    	BookManager manager = new BookManager();
    	manager.setup();
    	manager.delete(4l);
    	manager.exit();
    }
}
