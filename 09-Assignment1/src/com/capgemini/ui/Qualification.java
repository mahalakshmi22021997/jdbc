package com.capgemini.ui;

import javax.persistence.Embeddable;

@Embeddable
public class Qualification {
	private String nameOfQuality;
	private int experience;

	public String getNameOfQuality() {
		return nameOfQuality;
	}

	public void setNameOfQuality(String nameOfQuality) {
		this.nameOfQuality = nameOfQuality;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Qualification [nameOfQuality=" + nameOfQuality
				+ ", experience=" + experience + "]";
	}

}
