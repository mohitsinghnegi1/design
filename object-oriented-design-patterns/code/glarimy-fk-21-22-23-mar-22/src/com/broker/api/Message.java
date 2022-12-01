package com.broker.api;

import java.util.Map;

public class Message {
	private String type;
	private Map<String, String> headers;
	private Object body;

	Message(String type, Map<String, String> headers, Object body) {
		this.type = type;
		this.headers = headers;
		this.body = body;
	}

	public String getType() {
		return this.type;
	}

	public String getHeader(String header) {
		return headers.get(header);
	}

	public Object getBody() {
		return this.body;
	}
}
