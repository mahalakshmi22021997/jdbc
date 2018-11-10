package com.training.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main2 {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Query query=em.createNamedQuery("maleFilterQuery");
	List<Person> persons=query.getResultList();
	for (Person p : persons) {
		System.out.println(p.getName()+"\t"+p.getPersonId()+"\t"+p.getAge()+"\t"+p.getGender()+"\t"+p.getSalary());
	
	}
	em.getTransaction().commit();
	em.close();
	factory.close();
}
}
