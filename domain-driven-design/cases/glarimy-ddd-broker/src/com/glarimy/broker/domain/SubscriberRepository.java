package com.glarimy.broker.domain;

import java.util.List;

public interface SubscriberRepository {
	public Long save(Subscriber subscriber);

	public Subscriber findById(Long id);

	public void remove(Long id);

	public List<Subscriber> findByTopic(Topic topic);
}
