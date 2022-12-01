package com.client;

import com.broker.api.Receiver;
import com.broker.api.Message;

public class MessageReceiver implements Receiver {
	@Override
	public String getType() {
		return "com.dir.user.add";
	}

	@Override
	public void recieve(Message message) {
		System.out.println("Receiver: " + message.getBody());
	}

}
