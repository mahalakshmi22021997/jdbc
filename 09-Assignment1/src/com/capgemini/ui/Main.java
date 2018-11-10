package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Doctor doctor=new Doctor();
		doctor.setFees(987.00);
		doctor.setName("maha");
		Qualification qualification=new Qualification();
		qualification.setNameOfQuality("mbbs");
		qualification.setExperience(2);
		doctor.setQualification(qualification);
		//doctor.setQualification(qualification);
		em.persist(doctor);
		em.getTransaction().commit();
		System.out.println("Added in database.");
		em.close();
		emf.close();
	}
}
