package com.glarimy.bank.three.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.bank.three.api.AccountNotFoundException;
import com.glarimy.bank.three.api.Bank;
import com.glarimy.bank.three.api.BankException;
import com.glarimy.bank.three.api.InsufficientBalanceException;
import com.glarimy.bank.three.api.InvalidRequestException;
import com.glarimy.bank.three.domain.Account;
import com.glarimy.bank.three.domain.Customer;

public class BankImpl implements Bank {
	private Map<Integer, Account> accounts;
	private int counter = 1;

	public BankImpl() {
		accounts = new HashMap<Integer, Account>();
		counter = 1;
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		if (customer == null || customer.getOwner() == null || customer.getPhone() < 1)
			throw new InvalidRequestException();
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
		if (amount < 0)
			throw new InvalidRequestException();
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundException();
		account.setBalance(account.getBalance() + amount);
		return account.getBalance();
	}

	@Override
	public double withdraw(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, InsufficientBalanceException, BankException {
		if (amount < 0)
			throw new InvalidRequestException();
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
