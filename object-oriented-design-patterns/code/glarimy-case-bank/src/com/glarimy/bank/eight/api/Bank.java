package com.glarimy.bank.eight.api;

import com.glarimy.bank.eight.domain.Account;
import com.glarimy.bank.eight.domain.Customer;

/**
 * 
 * @author glarimy
 *
 */
public interface Bank {
	/**
	 * Opens a new account for a valid customer
	 * 
	 * @param customer
	 * @return account number
	 * @throws InvalidRequestException if name or phone are invalid
	 * @throws BankException           if internal reasons
	 */
	public int openAccount(Customer customer) throws InvalidRequestException, BankException;

	/**
	 * 
	 * @param number
	 * @param amount
	 * @return
	 * @throws InvalidRequestException
	 * @throws AccountNotFoundException
	 * @throws BankException
	 */
	public double deposit(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, BankException;

	/**
	 * 
	 * @param number
	 * @param amount
	 * @return
	 * @throws InvalidRequestException
	 * @throws AccountNotFoundException
	 * @throws InsufficientBalanceException
	 * @throws BankException
	 */
	public double withdraw(int number, double amount)
			throws InvalidRequestException, AccountNotFoundException, InsufficientBalanceException, BankException;

	/**
	 * 
	 * @param number
	 * @return
	 * @throws AccountNotFoundException
	 * @throws BankException
	 */
	public Account find(int number) throws AccountNotFoundException, BankException;

}