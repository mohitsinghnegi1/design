package com.glarimy.bank.seven.api;

import com.glarimy.bank.seven.domain.Account;
import com.glarimy.bank.seven.domain.Customer;

public class PrintableBank implements Bank {
	private Bank target;

	public PrintableBank(Bank target) {
		this.target = target;
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		return target.openAccount(customer);
	}

	@Override
	public double deposit(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, BankException {
		return target.deposit(number, amount);
	}

	@Override
	public double withdraw(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, InsufficientBalanceException, BankException {
		return target.withdraw(number, amount);
	}

	@Override
	public Account find(int number) throws AccountNotFoundException, BankException {
		return target.find(number);
	}

	public void print(int number) throws AccountNotFoundException, BankException {
		Account account = target.find(number);
		System.out.println("Account Number: " + account.getNumber());
		System.out.println(
				"Account Holder: " + account.getCustomer().getOwner() + "[" + account.getCustomer().getPhone() + "]");
		System.out.println("Latest Balance: Rs. " + account.getBalance());
	}

}
