package com.glarimy.messenger.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.glarimy.commons.api.Singleton;
import com.glarimy.messenger.api.Event;
import com.glarimy.messenger.api.Messenger;
import com.glarimy.messenger.api.Subscriber;

@Singleton
public class MessengerImpl implements Messenger {
	private Map<Integer, Subscriber> subscribers;
	private ExecutorService pool;
	private AtomicInteger counter;
	private static MessengerImpl INSTANCE = null;

	private MessengerImpl() {
		subscribers = new HashMap<Integer, Subscriber>();
		pool = Executors.newFixedThreadPool(2);
		counter = new AtomicInteger(0);
	}

	public synchronized static MessengerImpl getInstance() {
		if (INSTANCE == null)
			INSTANCE = new MessengerImpl();
		return INSTANCE;
	}

	@Override
	public int add(Subscriber subscriber) {
		int sid = counter.incrementAndGet();
		subscribers.put(sid, subscriber);
		return sid;
	}

	@Override
	public void remove(int sid) {
		subscribers.remove(sid);
	}

	@Override
	public void notify(Event<?> event) {
		subscribers.values().stream().filter(s -> s.getTopic().equals(event.topic))
				.forEach(s -> pool.submit(() -> s.on(event)));
	}

}