package com.glarimy.bank.seven.service;

import com.glarimy.bank.seven.api.AccountNotFoundException;
import com.glarimy.bank.seven.api.Bank;
import com.glarimy.bank.seven.api.BankException;
import com.glarimy.bank.seven.api.Factory;
import com.glarimy.bank.seven.api.InsufficientBalanceException;
import com.glarimy.bank.seven.api.InvalidRequestException;
import com.glarimy.bank.seven.domain.Account;
import com.glarimy.bank.seven.domain.Customer;

public class LoggingProxy implements Bank {
	private Bank target;
	private Logger logger;

	public LoggingProxy(Bank target) throws Exception {
		this.target = target;
		logger = new Factory<Logger>().get("logger");
	}

	@Override
	public int openAccount(Customer customer) throws InvalidRequestException, BankException {
		logger.log("INFO", "entering openAccount");
		try {
			int response = target.openAccount(customer);
			logger.log("INFO", "entering openAccount");
			return response;
		} catch (Exception e) {
			logger.log("ERROR", "entering openAccount");
			throw e;
		}
	}

	@Override
	public double deposit(int number, double amount) throws AccountNotFoundException, BankException {
		logger.log("INFO", "entering deposit");
		try {
			double response = target.deposit(number, amount);
			logger.log("INFO", "entering deposit");
			return response;
		} catch (Exception e) {
			logger.log("ERROR", "deposit failed");
			throw e;
		}
	}

	@Override
	public double withdraw(int number, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, BankException {
		logger.log("INFO", "entering withdraw");
		try {
			double response = target.withdraw(number, amount);
			logger.log("INFO", "entering withdraw");
			return response;
		} catch (Exception e) {
			logger.log("ERROR", "withdraw failed");
			throw e;
		}
	}

	@Override
	public Account find(int number) throws AccountNotFoundException, BankException {
		logger.log("INFO", "entering find");
		try {
			Account response = target.find(number);
			logger.log("INFO", "entering find");
			return response;
		} catch (Exception e) {
			logger.log("ERROR", "find failed");
			throw e;
		}
	}

}
