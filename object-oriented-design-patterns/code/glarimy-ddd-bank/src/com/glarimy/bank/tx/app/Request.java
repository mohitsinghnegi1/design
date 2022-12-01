package com.glarimy.bank.tx.app;

public class Request {
	public int accNo;
	public double amount;
	public String type;

	public Request(int accNo, double amount, String type) {
		super();
		this.accNo = accNo;
		this.amount = amount;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Request [accNo=" + accNo + ", amount=" + amount + ", type=" + type + "]";
	}

}
