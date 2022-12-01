package com.glarimy.messaging.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.messaging.api.Broker;
import com.glarimy.messaging.api.Event;
import com.glarimy.messaging.api.Handler;

public class SimpleBroker implements Broker {

	private Map<String, List<Handler>> handlers;
	private static SimpleBroker INSTANCE;

	private SimpleBroker() {
		handlers = new HashMap<String, List<Handler>>();
	}

	public static synchronized SimpleBroker getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SimpleBroker();
		return INSTANCE;
	}

	@Override
	public void register(Handler handler) {
		String topic = handler.getTopic();

		if (handlers.containsKey(topic)) {
			handlers.get(topic).add(handler);
		} else {
			List<Handler> topicHandlers = new ArrayList<Handler>();
			topicHandlers.add(handler);
			handlers.put(topic, topicHandlers);
		}
	}

	@Override
	public void notify(Event event) {
		if (handlers.get(event.getTopic()) != null)
			for (Handler handler : handlers.get(event.getTopic())) {
				handler.on(event);
			}
	}

}
