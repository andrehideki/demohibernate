package com.demohib.association;


import org.hibernate.Session;

import com.demohib.HibernateUtil;
import com.demohib.association.onetoone.Carro;
import com.demohib.association.onetoone.Engine;

public class OneToOneTest {

	public static void main(String[] args) {
		Engine engine = new Engine();
		Carro car = new Carro(null, "Fusca", "Amarelo", null);
		engine.setMake("GOLD");
		engine.setModel("V1");
		engine.setSize("10");
		engine.setCar(car);
		car.setEngine(engine);
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
//		s.save(car);
//		s.save(engine);
		Carro carro = s.find(Carro.class, 1l);
		System.out.println(carro);
		s.getTransaction().commit();
		s.close();
	}

}
