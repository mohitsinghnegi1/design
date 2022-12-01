package com.glarimy.bank.seven.service;

import java.util.Date;

public class ConsoleLogger implements Logger {
	@Override
	public void log(String severity, String message) {
		System.out.println(String.format("%s : [%s] - %s", new Date(), severity, message));
	}
}