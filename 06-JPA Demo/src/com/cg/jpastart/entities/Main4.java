package com.cg.jpastart.entities;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main4 {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	Trip trip=null;
	trip=em.find(Trip.class, 1);
	System.out.println(trip);
	em.close();
	emf.close();
}
}
