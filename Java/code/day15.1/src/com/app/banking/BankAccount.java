package com.app.banking;
//acctNo , type(enum) , balance , creationDate , customerName

import java.time.LocalDate;

import custom_exception.BankingException;

import static utils.ValidationRules.validateBalance;

public class BankAccount {
	private int acctNo;
	private AccountType acType;
	private double balance;
	private LocalDate creationDate;
	private String customerName;
	public BankAccount(int acctNo, AccountType acType, double balance, LocalDate creationDate, String customerName) {
		super();
		this.acctNo = acctNo;
		this.acType = acType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", acType=" + acType + ", balance=" + balance + ", creationDate="
				+ creationDate + ", customerName=" + customerName + "]";
	}
	//B.L
	public void deposit(double amount) 
	{
		balance += amount;
	}
	public void withdraw(double amount) throws BankingException
	{
		validateBalance(balance-amount);
		balance -= amount;
	}
	//transfer funds
	public void transferFunds(BankAccount dest,double amount) throws BankingException
	{
		this.withdraw(amount);
		dest.deposit(amount);
	}
	public int getAcctNo() {
		return acctNo;
	}
	public AccountType getAcType() {
		return acType;
	}
	public double getBalance() {
		return balance;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	
	

}
