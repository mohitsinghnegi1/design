package com.glarimy.bank.two;

/**
 * 
 * @author glarimy
 *
 */
public interface Bank {
	/**
	 * Opens a new account for a valid customer
	 * @param customer 
	 * @return account number
	 * @throws InvalidCustomerException if name or phone are invalid
	 * @throws BankException if internal reasons
	 */
	public int openAccount(Customer customer) throws InvalidCustomerException, BankException;

	/**
	 * 
	 * @param number
	 * @param amount
	 * @return
	 * @throws AccountNotFoundException
	 * @throws BankException
	 */
	public double deposit(int number, double amount) throws AccountNotFoundException, BankException;

	/**
	 * 
	 * @param number
	 * @param amount
	 * @return
	 * @throws AccountNotFoundException
	 * @throws InsufficientBalanceException
	 * @throws BankException
	 */
	public double withdraw(int number, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, BankException;

	/**
	 * 
	 * @param number
	 * @return
	 * @throws AccountNotFoundException
	 * @throws BankException
	 */
	public Account find(int number) throws AccountNotFoundException, BankException;

}