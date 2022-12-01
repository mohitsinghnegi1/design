package com.glarimy.bank.eight.service;

import com.glarimy.bank.eight.api.AccountNotFoundException;
import com.glarimy.bank.eight.api.Bank;
import com.glarimy.bank.eight.api.BankException;
import com.glarimy.bank.eight.api.InsufficientBalanceException;
import com.glarimy.bank.eight.api.InvalidRequestException;
import com.glarimy.bank.eight.domain.Account;
import com.glarimy.bank.eight.domain.Customer;

public class ValidationProxy implements Bank {
	private Bank target;

	public ValidationProxy(Bank target) {
		this.target = target;
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		if (customer == null || customer.getOwner() == null || customer.getPhone() < 1)
			throw new InvalidRequestException();

		return target.openAccount(customer);
	}

	@Override
	public double deposit(int number, double amount) throws AccountNotFoundException, BankException {
		if (amount < 0)
			throw new InvalidRequestException();

		return target.deposit(number, amount);
	}

	@Override
	public double withdraw(int number, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, BankException {
		if (amount < 0)
			throw new InvalidRequestException();

		return target.withdraw(number, amount);
	}

	@Override
	public Account find(int number) throws AccountNotFoundException, BankException {
		return target.find(number);
	}

}
