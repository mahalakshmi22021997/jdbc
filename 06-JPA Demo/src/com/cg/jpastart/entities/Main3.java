package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main3 {
	public static void main(String[] args) {

		SeatInfo info = new SeatInfo(50, 20, 30);
		Trip trip = new Trip();
		trip.setFrom_city("chennai");
		trip.setTo_city("hyderabad");
		trip.setInfo(info);
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(trip);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}