package com.glarimy.bank.four.api;

import com.glarimy.bank.four.service.BankImpl;

public class FactoryTwo {
	public static Bank get() {
		return (Bank) BankImpl.getInstance();
	}
}
