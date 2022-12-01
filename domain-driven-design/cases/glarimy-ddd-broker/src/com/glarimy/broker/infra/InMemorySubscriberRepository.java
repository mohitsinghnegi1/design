package com.glarimy.broker.infra;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.broker.domain.Subscriber;
import com.glarimy.broker.domain.SubscriberRepository;
import com.glarimy.broker.domain.Topic;
import com.glarimy.generic.framework.Singleton;

@Singleton
public class InMemorySubscriberRepository implements SubscriberRepository {
	private static InMemorySubscriberRepository INSTANCE;
	private Map<Long, Subscriber> subscribers;

	private InMemorySubscriberRepository() {
		subscribers = new HashMap<Long, Subscriber>();
	}

	public static synchronized InMemorySubscriberRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemorySubscriberRepository();
		return INSTANCE;
	}

	@Override
	public Long save(Subscriber subscriber) {
		Long id = new Date().getTime();
		subscribers.put(id, subscriber);
		return id;
	}

	@Override
	public Subscriber findById(Long id) {
		return subscribers.get(id);
	}

	@Override
	public List<Subscriber> findByTopic(Topic topic) {
		List<Subscriber> matches = new ArrayList<Subscriber>();
		for (Subscriber current : subscribers.values()) {
			if (current.getTopic().equals(topic))
				matches.add(current);
		}
		return matches;
	}

	@Override
	public void remove(Long id) {
		subscribers.remove(id);
	}

}
