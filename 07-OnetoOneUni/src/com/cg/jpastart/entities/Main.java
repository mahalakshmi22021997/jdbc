package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
		public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		Address address=null;
		address=em.find(Address.class, 1);
		//address.getAddressId();
		System.out.println(address.getStreet()+address.getCity()+address.getState()+address.getZipCode());
		Student student=em.find(Student.class, 7);
		System.out.println(student.getName()+student.getAddress().getCity()+student.getAddress().getState()+student.getAddress().getZipCode());
		
		em.close();
		emf.close();
	}
}
