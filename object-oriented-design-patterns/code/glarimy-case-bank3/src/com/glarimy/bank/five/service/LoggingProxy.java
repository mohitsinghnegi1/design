package com.glarimy.bank.five.service;

import java.util.Date;

import com.glarimy.bank.five.api.AccountNotFoundException;
import com.glarimy.bank.five.api.Bank;
import com.glarimy.bank.five.api.BankException;
import com.glarimy.bank.five.api.InsufficientBalanceException;
import com.glarimy.bank.five.api.InvalidRequestException;
import com.glarimy.bank.five.domain.Account;
import com.glarimy.bank.five.domain.Customer;

public class LoggingProxy implements Bank {
	private Bank target;

	public LoggingProxy(Bank target) {
		this.target = target;
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		System.out.println(new Date() + ": entering openAccount");
		try {
			int response = target.openAccount(customer);
			System.out.println(new Date() + ": leaving openAccount");
			return response;
		} catch (Exception e) {
			System.out.println(new Date() + ": openAccount failed");
			throw e;
		}
	}

	@Override
	public double deposit(int number, double amount) throws AccountNotFoundException, BankException {
		System.out.println(new Date() + ": entering deposit");
		try {
			double response = target.deposit(number, amount);
			System.out.println(new Date() + ": leaving deposit");
			return response;
		} catch (Exception e) {
			System.out.println(new Date() + ": deposit failed");
			throw e;
		}
	}

	@Override
	public double withdraw(int number, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, BankException {
		System.out.println(new Date() + ": entering withdraw");
		try {
			double response = target.withdraw(number, amount);
			System.out.println(new Date() + ": leaving withdraw");
			return response;
		} catch (Exception e) {
			System.out.println(new Date() + ": withdraw failed");
			throw e;
		}
	}

	@Override
	public Account find(int number) throws AccountNotFoundException, BankException {
		System.out.println(new Date() + ": entering find");
		try {
			Account response = target.find(number);
			System.out.println(new Date() + ": leaving find");
			return response;
		} catch (Exception e) {
			System.out.println(new Date() + ": find failed");
			throw e;
		}
	}

}
