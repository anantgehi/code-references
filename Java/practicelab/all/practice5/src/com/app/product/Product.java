package com.app.product;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6899035127171523976L;
	private int productId;
	private String productName;
	private double productPrice;
	private LocalDate expiryDate;
	private static int counter;
	public Product(String name, double price, LocalDate expiryDate) {
		productId=++counter;
		productName = name;
		productPrice = price;
		this.expiryDate=expiryDate;
	}
	public Product(String name, double price) {
		productName=name;
		productPrice=price;
	}
	public Product(String name) {
		productName=name;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", expiryDate=" + expiryDate + "]";
	}
	public int getProductId() {
		return productId;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj instanceof Product)
			return this.productName.equals(((Product)obj).productName) && ((Double)this.productPrice).equals(((Product)obj).productPrice);
		return false;
	}
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public static int getCounter() {
		return counter;
	}
	
}
