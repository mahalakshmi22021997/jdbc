package com.capgemini.business;

import javax.persistence.Embeddable;

@Embeddable
public class FeeDetails {

	private int f_id;
	private double totalFees;
	private  int noOfInstallments;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public double getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}
	public int getNoOfInstallments() {
		return noOfInstallments;
	}
	public void setNoOfInstallments(int noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}
	@Override
	public String toString() {
		return "FeeDetails [f_id=" + f_id + ", totalFees=" + totalFees
				+ ", noOfInstallments=" + noOfInstallments + "]";
	}
	
	
}
