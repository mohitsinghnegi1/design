package com.broker.service;

import java.util.HashMap;
import java.util.Map;

import com.broker.api.Broker;
import com.broker.api.Receiver;
import com.broker.api.Message;

public class LocalBroker implements Broker {
	private Map<Integer, Receiver> receivers;
	private static LocalBroker INSTANCE;
	private int counter;

	private LocalBroker() {
		receivers = new HashMap<Integer, Receiver>();
	}

	public synchronized static LocalBroker get() {
		if (INSTANCE == null)
			INSTANCE = new LocalBroker();
		return INSTANCE;
	}

	@Override
	public void notify(Message message) {
		this.receivers.values().stream().filter(receiver -> receiver.getType().equalsIgnoreCase(message.getType()))
				.forEach(reciever -> new Thread(() -> reciever.recieve(message)).start());
	}

	@Override
	public int register(Receiver receiver) {
		receivers.put(++counter, receiver);
		return counter;
	}

	@Override
	public void unregister(int id) {
		receivers.remove(id);
	}

}
