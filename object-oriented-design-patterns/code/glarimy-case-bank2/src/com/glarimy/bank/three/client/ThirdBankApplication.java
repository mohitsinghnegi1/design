package com.glarimy.bank.three.client;

import com.glarimy.bank.three.api.AccountNotFoundException;
import com.glarimy.bank.three.api.Bank;
import com.glarimy.bank.three.api.BankException;
import com.glarimy.bank.three.api.InsufficientBalanceException;
import com.glarimy.bank.three.api.InvalidRequestException;
import com.glarimy.bank.three.domain.Customer;
import com.glarimy.bank.three.service.BankImpl;

public class ThirdBankApplication {
	public static void main(String[] args) {
		try {
			Bank bank = new BankImpl();
			int number = bank.openAccount(new Customer("Krishna", 9731423166L));
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
