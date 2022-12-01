package com.broker.service;

import java.util.HashMap;
import java.util.Map;

import com.broker.api.Broker;
import com.broker.api.Handler;
import com.broker.api.Message;

public class LocalBroker implements Broker {
	private Map<Integer, Handler> handlers;
	private static LocalBroker INSTANCE;
	private int counter;

	private LocalBroker() {
		handlers = new HashMap<Integer, Handler>();
	}

	public synchronized static LocalBroker get() {
		if (INSTANCE == null)
			INSTANCE = new LocalBroker();
		return INSTANCE;
	}

	@Override
	public void publish(Message message) {
		this.handlers.values().stream().filter(handler -> handler.getType().equalsIgnoreCase(message.getType()))
				.forEach(handler -> new Thread(() -> handler.on(message)).start());
	}

	@Override
	public int subscribe(Handler handler) {
		handlers.put(++counter, handler);
		return counter;
	}

	@Override
	public void unsubscribe(int id) {
		handlers.remove(id);
	}

}
