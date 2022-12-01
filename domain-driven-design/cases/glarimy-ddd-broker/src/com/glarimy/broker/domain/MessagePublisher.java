package com.glarimy.broker.domain;

import com.glarimy.generic.framework.ObjectFactory;

public class MessagePublisher implements Publisher {
	private SubscriberRepository repo;

	public MessagePublisher() throws Exception {
		repo = (SubscriberRepository) ObjectFactory.get("subscriber.repo");
	}

	@Override
	public void publish(Message message) {
		for (Subscriber subscriber : repo.findByTopic(message.getTopic())) {
			subscriber.on(message);
		}
	}
}
