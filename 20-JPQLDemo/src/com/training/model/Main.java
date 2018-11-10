package com.training.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
public static void main(String[] args) {
	Person person1=new Person("maha", 21, 7898.00, 'f');
	Person person2=new Person("lakshmi", 22, 8789.00, 'f');
	Person person3=new Person("ravi", 22, 55657.00, 'm');
	Person person4=new Person("rajesh", 23, 87923.00, 'm');
	Person person5=new Person("yeswanth", 24, 63262.00, 'm');
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	em.persist(person1);
	em.persist(person2);
	em.persist(person3);
	em.persist(person4);
	em.persist(person5);
	em.getTransaction().commit();
	em.close();
	factory.close();
}
}
