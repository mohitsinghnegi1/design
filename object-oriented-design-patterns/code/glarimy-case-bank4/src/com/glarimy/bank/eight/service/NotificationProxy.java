package com.glarimy.bank.eight.service;

import com.glarimy.bank.eight.api.AccountNotFoundException;
import com.glarimy.bank.eight.api.Bank;
import com.glarimy.bank.eight.api.BankException;
import com.glarimy.bank.eight.api.Factory;
import com.glarimy.bank.eight.api.InsufficientBalanceException;
import com.glarimy.bank.eight.api.InvalidRequestException;
import com.glarimy.bank.eight.domain.Account;
import com.glarimy.bank.eight.domain.Customer;
import com.glarimy.bank.eight.events.Subject;

public class NotificationProxy implements Bank {
	private Bank target;
	private Subject subject;

	public NotificationProxy(Bank target) throws Exception {
		this.target = target;
		this.subject = new Factory<Subject>().get("subject");
		this.subject.add(new Emailer());
		this.subject.add(new ShortMessagingService());
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		int response = target.openAccount(customer);
		this.subject.notify(String.format("Hi %s, account with number %s is created.", customer.getOwner(), response));
		return response;
	}

	@Override
	public double deposit(int number, double amount) throws AccountNotFoundException, BankException {
		double response = target.deposit(number, amount);
		this.subject.notify(String.format("Hi, account %d is credited with Rs. %f. Latest balance: Rs. %f", number,
				amount, response));
		return response;

	}

	@Override
	public double withdraw(int number, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, BankException {
		double response = target.withdraw(number, amount);
		this.subject.notify(String.format("Hi, account %d is debited with Rs. %f. Latest balance: Rs. %f", number,
				amount, response));
		return response;
	}

	@Override
	public Account find(int number) throws AccountNotFoundException, BankException {
		return target.find(number);
	}

}
