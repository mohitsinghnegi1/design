package com.glarimy.bank.one;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<Integer, Account> accounts;
	private int counter = 1;

	public Bank() {
		accounts = new HashMap<Integer, Account>();
		counter = 1;
	}

	public int openAccount(String name, long phone) {
		Account account = new Account();
		account.number = counter++;
		account.owner = name;
		account.phone = phone;
		account.balance = 0;
		accounts.put(account.number, account);
		return account.number;
	}

	public double deposit(int number, double amount) {
		Account account = accounts.get(number);
		account.balance += amount;
		return account.balance;
	}

	public double withdraw(int number, double amount) {
		Account account = accounts.get(number);
		account.balance -= amount;
		return account.balance;
	}

	public Account find(int number) {
		return accounts.get(number);
	}
}
