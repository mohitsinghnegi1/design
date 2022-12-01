package com.glarimy.bank.four.api;

import com.glarimy.bank.four.service.BankImpl;

public class FactoryThree {
	public static Object get(String key) {
		if (key == "bank")
			return BankImpl.getInstance();
		throw new RuntimeException();
	}
}
