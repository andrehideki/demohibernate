package com.company;

import java.util.Date;

import javax.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			System.out.println("Iniciando transacao");
			em.getTransaction().begin();
			
			Company c = new Company();
			c.setName("GENERALEMP 2");
			c.setVersion(new Date());
			Status status = new Status();
//			status.setId(3l);
			status.setName("PARADA");
//			c.setStatus(em.find(Status.class, 3l));
			c.setStatus(status);
			
			CompanyDetail detail = new CompanyDetail();
			detail.setEmployeeStrength(1234);
//			detail.setNotes("Aqui todos os funcionarios sao muito preguicosos");
//			c.setDetail(detail);
//			detail.setCompany(c);
//			em.persist(status);
			em.persist(status);
			em.persist(c);
			
			detail.setCompany(c);
			detail.setId(c.getId());
			
			c.setDetail(detail);
			em.persist(c.getDetail());
			
//			em.getTransaction().rollback();
			em.getTransaction().commit();
			System.out.println("Transacao finalizada");
		} catch(Exception e) {
			System.out.println("Falha durante a transacao");
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
