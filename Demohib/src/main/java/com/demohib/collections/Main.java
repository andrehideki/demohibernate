package com.demohib.collections;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demohib.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		List<Car> cars = Arrays.asList(
				new Car(null, "Siena", "Azul Calcinha"),
				new Car(null, "Monza", "Preto"),
				new Car(null, "Saveiro", "Prata"));
		Showroom showroom = new Showroom(null, "Sao Paulo", "Ryota Sakamoto", cars);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		session.save(showroom);
		Showroom finded = session.find(Showroom.class, 2l);
		System.out.println(finded);
		session.getTransaction().commit();
		session.close();
	}

}
