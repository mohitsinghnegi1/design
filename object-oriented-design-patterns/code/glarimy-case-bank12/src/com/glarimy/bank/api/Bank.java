package com.glarimy.bank.api;

import java.util.Set;
import java.util.function.Predicate;

import com.glarimy.bank.domain.Account;
import com.glarimy.bank.domain.Customer;

public interface Bank {
	public int openAccount(Customer customer) throws InvalidRequestException, BankException;

	public double deposit(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, BankException;

	public double withdraw(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, InsufficientBalanceException, BankException;

	public Account find(int number) throws AccountNotFoundException, BankException;
	
	public Set<Integer> search(Predicate<Account> creteria) throws BankException;
}