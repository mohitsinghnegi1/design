package com.broker.api;

import java.util.HashMap;
import java.util.Map;

public class MessageBuilder {
	private Map<String, String> headers;
	private Object body;

	public MessageBuilder() {
		headers = new HashMap<String, String>();
	}

	public MessageBuilder setBody(Object body) {
		this.body = body;
		return this;
	}

	public MessageBuilder addHeader(String header, String value) {
		headers.put(header, value);
		return this;
	}

	public Message buildWith(String type) {
		return new Message(type, headers, body);
	}
}
