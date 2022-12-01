package com.glarimy.bank.five.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.bank.five.api.Singleton;
import com.glarimy.bank.five.api.AccountNotFoundException;
import com.glarimy.bank.five.api.Bank;
import com.glarimy.bank.five.api.BankException;
import com.glarimy.bank.five.api.InsufficientBalanceException;
import com.glarimy.bank.five.api.InvalidRequestException;
import com.glarimy.bank.five.domain.Account;
import com.glarimy.bank.five.domain.Customer;

@Singleton
public class BankImpl implements Bank {
	private Map<Integer, Account> accounts;
	private int counter = 1;
	private static BankImpl INSTANCE = null;

	private BankImpl() {
		accounts = new HashMap<Integer, Account>();
		counter = 1;
	}

	public static BankImpl getInstance() {
		if (INSTANCE == null)
			INSTANCE = new BankImpl();
		return INSTANCE;
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		Account account = new Account();
		account.setCustomer(customer);
		account.setNumber(counter++);
		account.setBalance(0);
		accounts.put(account.getNumber(), account);
		return account.getNumber();
	}

	@Override
	public double deposit(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, BankException {
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundException();
		account.setBalance(account.getBalance() + amount);
		return account.getBalance();
	}

	@Override
	public double withdraw(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, InsufficientBalanceException, BankException {
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundException();
		if (account.getBalance() < amount)
			throw new InsufficientBalanceException();
		account.setBalance(account.getBalance() - amount);
		return account.getBalance();
	}

	@Override
	public Account find(int number) throws AccountNotFoundException, BankException {
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundException();
		return account;
	}
}
