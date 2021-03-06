package com.cg.jpastart.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="con_store2")
public class ContractEmployee extends Employee {

	private int duration;
	private boolean extendable;
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isExtendable() {
		return extendable;
	}
	public void setExtendable(boolean extendable) {
		this.extendable = extendable;
	}
	@Override
	public String toString() {
		return "ContractEmployee [duration=" + duration + ", extendable="
				+ extendable + ", getEmployeeId()=" + getEmployeeId()
				+ ", getName()=" + getName() + ", getSalary()=" + getSalary()
				+ "]";
	}
	
	

}
