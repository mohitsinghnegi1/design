package com.glarimy.bank.service;

import java.util.Set;

import com.glarimy.bank.api.AccountNotFoundException;
import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.BankException;
import com.glarimy.bank.api.Factory;
import com.glarimy.bank.api.InsufficientBalanceException;
import com.glarimy.bank.api.InvalidRequestException;
import com.glarimy.bank.domain.Account;
import com.glarimy.bank.domain.Criteria;
import com.glarimy.bank.domain.Customer;
import com.glarimy.bank.events.Subject;

public class NotificationProxy implements Bank {
	private Bank target;
	private Subject subject;

	public NotificationProxy(Bank target) throws Exception {
		this.target = target;
		this.subject = new Factory<Subject>("bank.properties").get("subject");
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

	@Override
	public Set<Integer> search(Criteria creteria) throws BankException {
		return target.search(creteria);
	}

}
