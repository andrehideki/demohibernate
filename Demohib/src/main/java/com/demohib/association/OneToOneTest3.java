package com.demohib.association;


import org.hibernate.Session;

import com.demohib.HibernateUtil;
import com.demohib.association.onetoone.AnoCar;
import com.demohib.association.onetoone.AnoEngine;

public class OneToOneTest3 {

	public static void main(String[] args) {
		AnoEngine engine = new AnoEngine();
		AnoCar car = new AnoCar(null, "Fusca", "Amarelo", null);
		engine.setMake("GOLD");
		engine.setModel("V1");
		engine.setSize("10");
		car.setEngine(engine);
		engine.setCar(car);
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(car);
		s.getTransaction().commit();
		s.close();
	}

}
