package com.codejava;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonManager {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonDB");
		EntityManager em = factory.createEntityManager();
		
		Person p = new Person();
		p.setFirstName("Fulano");
		p.setLastName("Silva");
		Person p2 = new Person();
		p2.setFirstName("Beltrano");
		p2.setLastName("Filho");
		
		Address a1 = new Address();
		a1.setBuildingName("Santa Cruz");
		a1.setPostCode("00000-000");
		a1.setTown("Sao Paulo");
		Address a2 = new Address();
		a2.setBuildingName("Moema Cruzeiro");
		a2.setPostCode("00000-001");
		a2.setTown("Uberlandia");
		Address a3 = new Address();
		a3.setBuildingName("Predao Luiz de Souza");
		a3.setPostCode("00000-002");
		a3.setTown("Osasco");
		
		Set<Address> addresses1 = new HashSet<Address>();
		addresses1.add(a1);
		addresses1.add(a2);
		addresses1.add(a3);
		
		Set<Address> addresses2 = new HashSet<Address>();
		addresses2.add(a3);
		
		p.setAddresses(addresses1);
		for (Address a: p.getAddresses())
			a.getPersons().add(p);
		
		p2.setAddresses(addresses2);
		for (Address a: p2.getAddresses())
			a.getPersons().add(p2);
		
		em.getTransaction().begin();
		em.persist(p);
		em.persist(p2);
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}
