package com.glarimy.bank.one;

public class FirstBankApplication {
	public static void main(String[] args) {
		Bank bank = new Bank();
		int number = bank.openAccount("Krishna", 9731423166L);
		bank.deposit(number, 100);
		bank.deposit(number, 50);
		bank.withdraw(number, 80);
		System.out.println("Current Balance: Rs. " + bank.find(number).balance);
	}
}
