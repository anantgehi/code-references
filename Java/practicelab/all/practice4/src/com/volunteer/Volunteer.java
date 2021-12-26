package com.volunteer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Volunteer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4459114968322168304L;
	private int volunteerId;
	private String vName;
	private List<String> hobbies;
	private boolean isAvailable;
	private LocalDate dob;
	private static int counter;
	static {
		counter=100;
	}
	public Volunteer(String name,List<String> hobbies, boolean isAvailable, LocalDate dob) {
		this.volunteerId=++counter;
		this.vName=name;
		this.hobbies=hobbies;
		this.isAvailable=isAvailable;
		this.dob=dob;
	}
	public Volunteer(String name, LocalDate dob) {
		this.vName=name;
		this.dob=dob;
	}
	@Override
	public String toString() {
		return "Volunteer [volunteerId=" + volunteerId + ", vName=" + vName + ", hobbies=" + hobbies + ", isAvailable="
				+ isAvailable + ", dob=" + dob + "]";
	}
	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(o instanceof Volunteer)
			return this.vName.equals(((Volunteer)o).vName) && this.dob.equals(((Volunteer)o).dob); 
		return false;
	}
	public int getVolunteerId() {
		return volunteerId;
	}
	public String getvName() {
		return vName;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public LocalDate getDob() {
		return dob;
	}
}
