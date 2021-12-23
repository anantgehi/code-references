package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 4.1 Customer : name(string),email(string),password(string),registrationAmount(double),dob(Date),type (CustomerType : enum)
CustomerType : SILVER,GOLD,DIAMOND,PLATINUM
Unique ID(Primary Key ) : email  (2 customers are SAME iff their email ids are same)
 */
public class Customer {
	private String name;
	private String email;
	private String password;
	private double regAmount;
	private Date dob;
	private CustomerType type;
	//composition between Customer HAS-A AdharCard
	private AdharCard card;
	// static SDF
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public Customer(String name, String email, String password, double regAmount, Date dob, CustomerType type) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.type = type;
	}
	// add overloaded ctor , to accept email: PK

	@Override
	public String toString() {
		String details =card==null?"Adhat Details Not yet Linked":card.toString();
		return "Customer [name=" + name + ", email=" + email + ", regAmount=" + regAmount + ", dob=" + sdf.format(dob)
				+ ", type=" + type + "]";
	}
	//add a method to link adhar card to customer details
	public void linkAdharCard(String cardNumber,String location)
	{
		this.card=new AdharCard(cardNumber, location);
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	// override equals method
	@Override
	public boolean equals(Object o) {
		System.out.println("in cust's equals");
		if (o instanceof Customer) {
			Customer c = (Customer) o;
			return email.equals(c.email);
		}
		return false;
	}
	//inner class : non static nested class
	public class AdharCard 
	{
		private String cardNumber;
		private String location;
		public AdharCard(String cardNumber, String location) {
			super();
			this.cardNumber = cardNumber;
			this.location = location;
		}
		@Override
		public String toString() {
			return "AdharCard [cardNumber=" + cardNumber + ", location=" + location + "]";
		}
		
		
	}

}
