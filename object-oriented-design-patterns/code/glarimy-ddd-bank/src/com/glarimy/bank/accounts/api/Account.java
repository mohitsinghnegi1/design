package com.glarimy.bank.accounts.api;

public class Account {
	private int id;
	private Customer customer;
	private double balance;

	public Account() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (this.id == 0)
			this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		if (this.customer == null)
			this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
