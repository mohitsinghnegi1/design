package com.glarimy.bank.eight.service;

import com.glarimy.bank.eight.events.Observer;

public class ShortMessagingService implements Observer {

	@Override
	public void on(String message) {
		System.out.println("Sent SMS: " + message);
	}

}
