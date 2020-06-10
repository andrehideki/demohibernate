package com.demohib.association.manytoone.unidirectional;

import org.hibernate.Session;

import com.demohib.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Order o = new Order(null, "A simple order");
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(o);
		OrderItem i1 = new OrderItem(1l, "Item 1", o),
				 i2 = new OrderItem(2l, "Item 2", o),
				 i3 = new OrderItem(3l, "Item 3", o),
				 i4 = new OrderItem(4l, "Item 4", o);
		session.save(i1);
		session.save(i2);
		session.save(i3);
		session.save(i4);
		
		session.getTransaction().commit();
		session.close();
	}
}
