package com.training.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Loan loan=new Loan();
		loan.setCustomerName("maha");
		loan.setLoanAmount(2345.00);
		loan.setLoanId(1);
		RePayment rePayment=new RePayment();
		rePayment.setInstallmentNumber(22);
		rePayment.setRePayAmount(7679.00);
		rePayment.setRePaymentId(12);
		
		RePayment rePayment1=new RePayment();
		rePayment1.setInstallmentNumber(23);
		rePayment1.setRePayAmount(7689.00);
		rePayment1.setRePaymentId(17);
		
		loan.addRepayment(rePayment);
		loan.addRepayment(rePayment1);
		em.persist(loan);
		System.out.println("added successfully!!......");
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
