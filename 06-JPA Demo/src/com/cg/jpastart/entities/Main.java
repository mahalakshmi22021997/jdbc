package com.cg.jpastart.entities;
													///fetching data 

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		Student student = null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter id you want to fetch");
		int fid=scanner.nextInt();
		student=em.find(Student.class,fid);
		System.out.println(student);
		em.close();
		emf.close();

		

	}

}
