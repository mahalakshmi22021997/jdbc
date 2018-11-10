package com.cg.jpastart.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		// Student student = null;
		String myQuery = "from Student";
		Query query = em.createQuery(myQuery);
		List<Student> stdList = null;
		stdList = query.getResultList();
		// student=em.find(Student.class,student.getName());
		for (Student student : stdList) {
			System.out.println(student.getName().toUpperCase());
			em.getTransaction().begin();
			student.setName(student.getName().toUpperCase());
			// System.out.println(stdList);
			em.merge(student);
			em.getTransaction().commit();
		}
		em.close();
		emf.close();
	}
}
