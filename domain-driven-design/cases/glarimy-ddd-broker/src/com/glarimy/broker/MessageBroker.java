package com.glarimy.broker;

import com.glarimy.broker.app.Broker;

public class MessageBroker {
	public static void main(String[] args) throws Exception {
		Broker broker = new Broker();
		long id = broker.register("com/glarimy/test", message -> {
			System.out.println(message.getTopic().getName());
			System.out.println(message.getBody());
			System.out.println(message.getTime());
		});
		broker.notify("com/glarimy/test", "Hello World");
		broker.unsubscribe(id);
		broker.notify("com/glarimy/test", "Hello World");
	}
}
