package com.glarimy.bank.tx.app;

public class Record {
	public int reference;
	public int number;
	public double balance;
	public String date;

	@Override
	public String toString() {
		return "Record [reference=" + reference + ", number=" + number + ", balance=" + balance + ", date=" + date
				+ "]";
	}

}
