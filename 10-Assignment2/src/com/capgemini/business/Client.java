package com.capgemini.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Course course = new Course();
		course.setC_name("java");
		FeeDetails feeDetails = new FeeDetails();
		feeDetails.setF_id(1);
		feeDetails.setTotalFees(5678.00);
		feeDetails.setNoOfInstallments(2);
		course.setFeeDetails(feeDetails);
		em.persist(course);
		em.getTransaction().commit();

		System.out.println("Added in database.");
		em.close();
		emf.close();

	}
}
