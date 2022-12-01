package com.glarimy.bank.domain;

public class Account {
	private int number;
	private double balance;
	private Customer customer;

	public Account() {

	}

	public Account(int number, double balance, Customer customer) {
		super();
		this.number = number;
		this.balance = balance;
		this.customer = customer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + ", customer=" + customer + "]";
	}

}
