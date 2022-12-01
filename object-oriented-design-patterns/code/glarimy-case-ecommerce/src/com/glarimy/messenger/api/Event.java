package com.glarimy.messenger.api;

public class Event<T> {
	public String topic;
	public T body;

	public Event(String topic, T body) {
		super();
		this.topic = topic;
		this.body = body;
	}

}
