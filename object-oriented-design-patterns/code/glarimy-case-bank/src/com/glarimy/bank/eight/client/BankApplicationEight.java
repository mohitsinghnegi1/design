package com.glarimy.bank.eight.client;

import com.glarimy.bank.eight.api.AccountNotFoundException;
import com.glarimy.bank.eight.api.Bank;
import com.glarimy.bank.eight.api.BankException;
import com.glarimy.bank.eight.api.Factory;
import com.glarimy.bank.eight.api.InsufficientBalanceException;
import com.glarimy.bank.eight.api.InvalidRequestException;
import com.glarimy.bank.eight.api.PrintableBank;
import com.glarimy.bank.eight.domain.Customer;

public class BankApplicationEight {
	public static void main(String[] args) {
		try {
			Factory<Bank> factory = new Factory<>();
			Bank target = factory.get("bank");
			PrintableBank bank = new PrintableBank(target);
			int number = bank.openAccount(new Customer("Krishna", 9731423166L));
			bank.deposit(number, 100);
			bank.deposit(number, 50);
			bank.withdraw(number, 80);
			bank.print(number);
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