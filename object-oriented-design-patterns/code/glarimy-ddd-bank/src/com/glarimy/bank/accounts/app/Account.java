package com.glarimy.bank.accounts.app;

public class Account {
	public int number;
	public String owner;
	public double balance;
	public String address;
	public String phones;

	@Override
	public String toString() {
		return "Account [number=" + number + ", owner=" + owner + ", balance=" + balance + ", address=" + address
				+ ", phones=" + phones + "]";
	}

}
