package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee employee = null;
		employee = em.find(Employee.class, 3);
		System.out.println(employee);
		System.out.println(employee instanceof Employee);
		System.out.println(employee instanceof Manager);
		System.out.println(employee instanceof ContractEmployee);
		if (employee instanceof Manager) {
			Manager m = (Manager) employee;

			System.out.println(m.getDepartmentName() + "\t" + m.getEmployeeId()
					+ "\t" + m.getName() + "\t" + m.getSalary());

		}
		if (employee instanceof ContractEmployee) {
			ContractEmployee ce = (ContractEmployee) employee;
			System.out.println(ce.getDuration() + "\t" + ce.getName() + "\t"
					+ ce.getSalary() + "\t" + ce.getEmployeeId() + "\t"
					+ ce.isExtendable());
		}
		em.close();
		emf.close();
	}

}
