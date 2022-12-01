package com.broker.api;

import java.util.HashMap;
import java.util.Map;

public class MessageBuilder {
	private Map<String, String> props;
	private Object body;
	private String type;

	public MessageBuilder(String type) {
		props = new HashMap<String, String>();
		this.type = type;
	}

	public MessageBuilder setBody(Object body) {
		this.body = body;
		return this;
	}

	public MessageBuilder addHeader(String header, String value) {
		props.put(header, value);
		return this;
	}

	public Message build() {
		return new Message(type, props, body);
	}
}
