package com.capgemini.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		Course course=null;
		course=em.find(Course.class, 2);
		System.out.println(course.getC_id()+course.getC_name()+course.getFeeDetails()+course.getFeeDetails());
		/*FeeDetails details=em.find(FeeDetails.class, 5);
		System.out.println(details.getF_id()+details.getNoOfInstallments()+details.getTotalFees());*/
		em.close();
		emf.close();
	}
}
