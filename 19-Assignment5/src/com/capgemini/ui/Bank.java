package com.capgemini.ui;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bank_master")
public class Bank {

	@Id
	@Column(name="bank_id")
	private int b_id;
	private String name;
	private String headOfficeLocation;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bankList") //inverse side
	List<Customer> customerlist = new ArrayList<Customer>();

	
	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadOfficeLocation() {
		return headOfficeLocation;
	}

	public void setHeadOfficeLocation(String headOfficeLocation) {
		this.headOfficeLocation = headOfficeLocation;
	}

	public List<Customer> getCustomerlist() {
		return customerlist;
	}

	public void setCustomerlist(List<Customer> customerlist) {
		this.customerlist = customerlist;
	}

	@Override
	public String toString() {
		return "Bank [id=" + b_id + ", name=" + name + ", headOfficeLocation="
				+ headOfficeLocation + ", customerlist=" + customerlist + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (b_id != other.b_id)
			return false;
		return true;
	}

	public void addCustomer(Customer customer) {
		this.customerlist.add(customer);
	}
}
