package com.glarimy.broker.app;

import java.util.function.Consumer;

import com.glarimy.broker.domain.Message;
import com.glarimy.broker.domain.Publisher;
import com.glarimy.broker.domain.Subscriber;
import com.glarimy.broker.domain.SubscriberRepository;
import com.glarimy.broker.domain.Topic;
import com.glarimy.generic.framework.ObjectFactory;

public class Broker {
	private SubscriberRepository repo;
	private Publisher publisher;

	public Broker() throws Exception {
		repo = (SubscriberRepository) ObjectFactory.get("subscriber.repo");
		publisher = (Publisher) ObjectFactory.get("publisher");
	}

	public Long register(String topic, Consumer<Message> handler) {
		return repo.save(new Subscriber() {

			@Override
			public void on(Message message) {
				handler.accept(message);
			}

			@Override
			public Topic getTopic() {
				return new Topic(topic);
			}
		});
	}

	public void unsubscribe(Long id) {
		repo.remove(id);
	}

	public void notify(String topic, Object message) {
		publisher.publish(new Message(new Topic(topic), message));
	}
}
