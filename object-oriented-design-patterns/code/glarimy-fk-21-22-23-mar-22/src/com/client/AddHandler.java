package com.client;

import com.broker.api.Handler;
import com.broker.api.Message;

public class AddHandler implements Handler {
	@Override
	public void on(Message message) {
		System.out.println("Handler: " + message.getBody());
	}

	@Override
	public String getType() {
		return "com.dir.user.add";
	}

}
