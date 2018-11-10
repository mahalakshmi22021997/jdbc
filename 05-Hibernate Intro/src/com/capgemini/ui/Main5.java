package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Contact;

public class Main5 {
	public static void main(String[] args) {

		Contact contact1 = new Contact(1, "maha", "989789797");
		Contact contact2 = new Contact(2, "lakshmi", "878878393");
		Contact contact3 = new Contact(3, "mounika", "7734783923");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		/*em.persist(contact1);
		em.persist(contact2);
		em.persist(contact3);*/
		em.getTransaction().commit();
		contact3.setPhoneNumber("98765412");       // attached state
		em.merge(contact3);                       //used to update the data in database
		em.close();
		emf.close();
		                                          // contact3.setPhoneNumber("98765412"); detached state
		Contact contact4=null;
		emf=Persistence.createEntityManagerFactory("JPA-PU");	 
		em=emf.createEntityManager();
		contact4=em.find(Contact.class,2);
		contact4.setPhoneNumber("77347823");
		em.merge(contact4);
		System.out.println(contact4.equals(contact3));
		em.close();
		emf.close();
		
		
	}

}
