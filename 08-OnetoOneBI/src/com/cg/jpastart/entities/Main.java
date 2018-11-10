package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		// Address address=em.find(Address.class, 2);
		Student student = em.find(Student.class, 7);
		System.out.println(student.getName()+"\t" + student.getAddress().getCity()+"\t"
				+ student.getAddress().getState()+"\t"
				+ student.getAddress().getStreet()+"\t"
				+ student.getAddress().getZipCode());
		em.close();
		emf.close();

	}
}
