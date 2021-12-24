package com.app.core;

public enum CustomerType {
	SILVER(500), GOLD(1000), DIAMOND(1500), PLATINUM(2000);
	private double planCost;

	private CustomerType(double planCost) {
		this.planCost = planCost;
	}
	//getter

	public double getPlanCost() {
		return planCost;
	}
	
	
	
}
