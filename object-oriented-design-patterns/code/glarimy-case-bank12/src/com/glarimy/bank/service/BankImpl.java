package com.glarimy.bank.service;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	private AtomicInteger counter;
	private static BankImpl INSTANCE = null;

	private BankImpl() {
		accounts = new Hashtable<Integer, Account>();
		counter = new AtomicInteger(1);
	}

	public synchronized static BankImpl getInstance() {
		if (INSTANCE == null)
			INSTANCE = new BankImpl();
		return INSTANCE;
	}

	@Override
	public synchronized int openAccount(Customer customer) throws InvalidRequestException, BankException {
		Account account = new Account();
		account.setCustomer(customer);
		account.setNumber(counter.getAndIncrement());
		account.setBalance(0);
		accounts.put(account.getNumber(), account);
		return account.getNumber();
	}

	@Override
	public synchronized double deposit(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, BankException {
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundException();
		account.setBalance(account.getBalance() + amount);
		return account.getBalance();
	}

	@Override
	public synchronized double withdraw(int number, double amount)
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
	public synchronized Account find(int number) throws AccountNotFoundException, BankException {
		Account account = accounts.get(number);
		if (account == null)
			throw new AccountNotFoundException();
		return account;
	}

	@Override
	public synchronized Set<Integer> search(Predicate<Account> creteria) throws BankException {
		return accounts.values().stream().filter(creteria).map(e -> e.getNumber()).collect(Collectors.toSet());
	}
}
