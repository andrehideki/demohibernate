package com.demohib.association;


import org.hibernate.Session;

import com.demohib.HibernateUtil;
import com.demohib.association.onetoone.Carro2;
import com.demohib.association.onetoone.Engine2;

public class OneToOneTest2 {

	public static void main(String[] args) {
		Engine2 engine = new Engine2();
		Carro2 car = new Carro2(null, "Fusca", "Amarelo", null);
		engine.setMake("GOLD");
		engine.setModel("V1");
		engine.setSize("10");
		car.setEngine(engine);
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(car);
		s.getTransaction().commit();
		s.close();
	}

}
