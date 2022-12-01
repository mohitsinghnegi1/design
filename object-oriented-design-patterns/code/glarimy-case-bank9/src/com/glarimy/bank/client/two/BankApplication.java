package com.glarimy.bank.client.two;

import com.glarimy.bank.api.AccountNotFoundException;
import com.glarimy.bank.api.Bank;
import com.glarimy.bank.api.BankException;
import com.glarimy.bank.api.Factory;
import com.glarimy.bank.api.InsufficientBalanceException;
import com.glarimy.bank.api.InvalidRequestException;
import com.glarimy.bank.api.PrintableBank;
import com.glarimy.bank.domain.Customer;

public class BankApplication {
	public static void main(String[] args) {
		try {
			Factory<Bank> factory = new Factory<>("bank.properties");
			Bank target = factory.get("bank");
			PrintableBank bank = new PrintableBank(target);
			int number = bank.openAccount(new Customer("Krishna", 9731423166L));
			bank.deposit(number, 100);
			bank.deposit(number, 50);
			bank.withdraw(number, 80);
			bank.print(number);
			bank.openAccount(new Customer("Mohan", 9731423166L));
			bank.openAccount(new Customer("Koyya", 9731423166L));
			System.out.println(bank.search(account -> account.getBalance() < 50));
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