package com.capgemini.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.businesss.Customer;
import com.capgemini.db.CustomerDAO;
import com.capgemini.db.CustomerDAOImpl;

public class Main {
	public static void add() throws ClassNotFoundException, SQLException {
		
		int id;
		String name=null;
		String city=null;
		double amount=0.0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter id: ");
		id=scanner.nextInt();
		System.out.println("enter name: ");
		name=scanner.next();
		System.out.println("enter city: ");
		city=scanner.next();
		System.out.println("enter amount: ");
		amount=scanner.nextDouble();
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setCity(city);
		customer.setOutStandingAmount(amount);
		CustomerDAO dao=new CustomerDAOImpl();
		boolean result=dao.addCustomer(customer);
		if(result==true){
			System.out.println("inserted successfully!!....");
		}else{
		System.out.println("data not inserted!!........");
	}
	}
	public static void update() throws ClassNotFoundException, SQLException {
		int id;
		String name=null;
		String city=null;
		double amount=0.0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter id you want to update: ");
		id=scanner.nextInt();
		System.out.println("enter name: ");
		name=scanner.next();
		System.out.println("enter city: ");
		city=scanner.next();
		System.out.println("enter amount: ");
		amount=scanner.nextDouble();
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setCity(city);
		customer.setOutStandingAmount(amount);
		CustomerDAO dao=new CustomerDAOImpl();
		boolean result=dao.updateCustomer(customer);
		if(result==true){
			System.out.println("updated successfully!!....");
		}else{
		System.out.println("data not updated!!........");
	}

	}

	public static void displayAll() throws ClassNotFoundException, SQLException {
		CustomerDAO dao=new CustomerDAOImpl();
		List<Customer> customers=dao.getAllCustomers();
		//System.out.println(customers);
		for(Customer customer: customers){
			System.out.print(customer.getId());
			System.out.print(customer.getName());
			System.out.print(customer.getCity());
			System.out.println(customer.getOutStandingAmount());
		}
		
	}

	public static void remove() throws ClassNotFoundException, SQLException {
		int inp_id=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id to remove");
		inp_id=scanner.nextInt();
		CustomerDAO dao=new CustomerDAOImpl();
		boolean result=dao.removeCustomer(inp_id);
		if(result==true){
			System.out.println("Record deleted successfully!!...");
		}
		else{
			System.out.println("Record is not deleted");
		}
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		while(true){
		System.out.println("CUSTOMER APPLICATION");
		System.out.println("********************");
		System.out.println("1.Add new customer");
		System.out.println("2.Update customer");
		System.out.println("3.Display all customers");
		System.out.println("4.Delete customer");
		System.out.println("5.exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter choice");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:add();

					break;
			case 2:update();

					break;
			case 3:displayAll();

					break;
			case 4:remove();

					break;
			case 5:
			System.out.println("THANK YOU");

					System.exit(0);

		}

	}
	}

}
