package com.glarimy.broker.domain;

public interface Subscriber {
	public void on(Message message);

	public Topic getTopic();
}
