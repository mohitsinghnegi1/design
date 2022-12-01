package com.glarimy.bank.four.api;

import com.glarimy.bank.four.service.BankImpl;

public class FactoryOne {
	public static BankImpl get() {
		return BankImpl.getInstance();
	}
}
