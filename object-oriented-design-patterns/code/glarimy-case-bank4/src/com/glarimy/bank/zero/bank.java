package com.glarimy.bank.zero;

import java.util.HashMap;
import java.util.Map;

public class bank {
	private Map<Integer, Account> accounts;
	private int counter = 1;

	public bank() {
		accounts = new HashMap<Integer, Account>();
		counter = 1;
	}

	public int Openaccount(String name, long phone) {
		Account account = new Account();
		account.number = counter++;
		account.owner = name;
		account.phone = phone;
		account.balance = 0;
		accounts.put(account.number, account);
		return account.number;
	}

	public double Deposit(int number, double amount) {
		Account account = accounts.get(number);
		account.balance += amount;
		return account.balance;
	}

	public double withdrawing(int number, double amount) {
		Account account = accounts.get(number);
		account.balance -= amount;
		return account.balance;
	}

	public Account find(int number) {
		return accounts.get(number);
	}
}
