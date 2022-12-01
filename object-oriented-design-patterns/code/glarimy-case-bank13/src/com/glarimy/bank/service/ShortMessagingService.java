package com.glarimy.bank.service;

import com.glarimy.bank.events.Observer;

public class ShortMessagingService implements Observer {

	@Override
	public void on(String message) {
		System.out.println(Thread.currentThread().getName() + " Sent SMS: " + message);
	}

}
