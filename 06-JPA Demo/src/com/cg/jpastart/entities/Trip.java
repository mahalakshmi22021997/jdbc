package com.cg.jpastart.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {

		
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int trip_id;
	String from_city;
	String to_city;
	@Embedded
	SeatInfo info;
	public int getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	public String getFrom_city() {
		return from_city;
	}
	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}
	public String getTo_city() {
		return to_city;
	}
	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}
	public SeatInfo getInfo() {
		return info;
	}
	public void setInfo(SeatInfo info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Trip [trip_id=" + trip_id + ", from_city=" + from_city
				+ ", to_city=" + to_city + ", info=" + info + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + trip_id;
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
		Trip other = (Trip) obj;
		if (trip_id != other.trip_id)
			return false;
		return true;
	}
	

}
