package com.glarimy.bank.zero;

public class ZeroBankApplication {
	public static void main(String[] args) {
		bank b = new bank();
		int number = b.Openaccount("Krishna", 9731423166L);
		b.Deposit(number, 100);
		b.Deposit(number, 50);
		b.withdrawing(number, 80);
		System.out.println("Current Balance: Rs. " + b.find(number).balance);
	}
}
