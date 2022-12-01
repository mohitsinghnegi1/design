package com.glarimy.bank.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import com.glarimy.bank.api.AccountNotFoundException;
import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.BankException;
import com.glarimy.bank.api.InsufficientBalanceException;
import com.glarimy.bank.api.InvalidRequestException;
import com.glarimy.bank.api.Singleton;
import com.glarimy.bank.domain.Account;
import com.glarimy.bank.domain.Customer;

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

	@Override
	public Set<Integer> search(Predicate<Account> creteria) throws BankException {
		Set<Integer> results = new HashSet<Integer>();
		for (Account account : accounts.values())
			if (creteria.test(account))
				results.add(account.getNumber());
		return results;
	}
}
