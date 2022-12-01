package com.glarimy.bank.six.client;

import com.glarimy.bank.six.api.AccountNotFoundException;
import com.glarimy.bank.six.api.Bank;
import com.glarimy.bank.six.api.BankException;
import com.glarimy.bank.six.api.Factory;
import com.glarimy.bank.six.api.InsufficientBalanceException;
import com.glarimy.bank.six.api.InvalidRequestException;
import com.glarimy.bank.six.domain.Customer;

public class SixthBankApplication {
	public static void main(String[] args) {
		try {
			Factory<Bank> factory = new Factory<>();
			Bank bank = factory.get("bank");
			int number = bank.openAccount(new Customer("Krishna", -9731423166L));
			bank.deposit(number, 100);
			bank.deposit(number, 50);
			bank.withdraw(number, 80);
			System.out.println("Current Balance: Rs. " + bank.find(number).getBalance());
		} catch (InvalidRequestException ice) {
			System.out.println("Invalid data");
		} catch (AccountNotFoundException anfe) {
			System.out.println("No account found");
		} catch (InsufficientBalanceException ibe) {
			System.out.println("Insufficient balance");
		} catch (BankException e) {
			System.out.println("Error. Try later");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}