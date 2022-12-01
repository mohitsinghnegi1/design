package com.glarimy.broker;

import java.util.HashMap;
import java.util.Map;

public class ConcreteBroker implements Broker {
	private static ConcreteBroker INSTANCE;
	private Map<String, Map<Integer, Handler>> handlers;

	private ConcreteBroker() {
		handlers = new HashMap<String, Map<Integer, Handler>>();
	}

	public static ConcreteBroker getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ConcreteBroker();
		return INSTANCE;
	}

	@Override
	public void publish(Message message) {
		for (Handler handler : handlers.get(message.getType()).values())
			handler.handle(message);
	}

	@Override
	public int subscribe(String type, Handler handler) {
		if (!handlers.containsKey(type))
			handlers.put(type, new HashMap<Integer, Handler>());
		int id = 1; // TODO
		handlers.get(type).put(id, handler);
		return id;
	}

	@Override
	public void unsubscribe(int id) {
		// TODO
	}
}
