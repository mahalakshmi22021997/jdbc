package com.training.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {

	public static void main(String[] args) {
		String JPQL="select p from Person p where p.salary between :startRange and :endRange";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query=em.createQuery(JPQL);
		query.setParameter("startRange", 7000.00);
		query.setParameter("endRange", 9000.00);
		
		
		List<Person> persons=query.getResultList();
		for (Person p : persons) {
			System.out.println(p.getName()+"\t"+p.getPersonId()+"\t"+p.getAge()+"\t"+p.getGender()+"\t"+p.getSalary());
		
		}
		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}
}
