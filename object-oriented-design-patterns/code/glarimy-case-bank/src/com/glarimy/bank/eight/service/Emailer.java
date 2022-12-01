package com.glarimy.bank.eight.service;

import com.glarimy.bank.eight.events.Observer;

public class Emailer implements Observer {

	@Override
	public void on(String message) {
		System.out.println("Mailed: " + message);
	}

}
