package com.glarimy.messaging.api;

import java.util.Map;

public class Event {
	private String topic;
	private Map<String, Object> body;

	public Event(String topic, Map<String, Object> body) {
		this.topic = topic;
		this.body = body;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

}
