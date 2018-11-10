package com.cg.jpastart.entities;
													//deleting data
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Student student=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter id you want to delete");
		int did=scanner.nextInt();
		student=em.find(Student.class,did);
		em.getTransaction().begin();
		em.remove(student);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
