package com.capgemini.ui;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Bank iciciBank = new Bank();
		iciciBank.setB_id(1);
		iciciBank.setName("icici");
		iciciBank.setHeadOfficeLocation("chennai");
		

		Bank kotakBank = new Bank();
		kotakBank.setB_id(2);
		kotakBank.setName("kotak");
		kotakBank.setHeadOfficeLocation("hyderabad");

		Bank hdfcBank = new Bank();
		hdfcBank.setB_id(3);
		hdfcBank.setName("hdfc");
		hdfcBank.setHeadOfficeLocation("pune");

		Customer customer = new Customer();
		customer.setId(11);
		customer.setName("maha");
		customer.setDob(new Date());

		customer.addBank(hdfcBank);
		customer.addBank(kotakBank);
		customer.addBank(iciciBank);
		
		hdfcBank.addCustomer(customer);
		kotakBank.addCustomer(customer);
		iciciBank.addCustomer(customer);

		Customer customer2 = new Customer();
		customer2.setId(12);
		customer2.setName("lakshmi");
		customer2.setDob(new Date());
		
		customer2.addBank(hdfcBank);
		customer2.addBank(kotakBank);
		customer2.addBank(iciciBank);
		
		hdfcBank.addCustomer(customer2);
		kotakBank.addCustomer(customer2);
		iciciBank.addCustomer(customer2);

		

		em.persist(customer);
		em.persist(customer2);

		System.out.println("Bank details are added");
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}
