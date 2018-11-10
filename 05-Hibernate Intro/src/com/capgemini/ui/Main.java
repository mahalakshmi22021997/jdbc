package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.capgemini.business.Employee;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em=emf.createEntityManager();
		
		Employee employee=new Employee();
		employee.setEmpId(103);
		employee.setEmpName(" LAKSHMI");
		employee.setEmpGender('F');
		employee.setBasicSalary(5000.00);
		employee.setEmpGade('A');
		EntityTransaction entityTransaction =em.getTransaction();
		entityTransaction.begin();
		
		em.persist(employee);
		entityTransaction.commit();
		
		em.close();
		emf.close();
		
		System.out.println("Object is stored in DB");
				
		
	}

}
