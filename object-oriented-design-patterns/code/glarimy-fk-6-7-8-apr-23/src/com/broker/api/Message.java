package com.broker.api;

import java.util.Map;

public class Message {
	private String type;
	private Map<String, String> props;
	private Object body;

	Message(String type, Map<String, String> props, Object body) {
		this.type = type;
		this.props = props;
		this.body = body;
	}

	public String getType() {
		return this.type;
	}

	public String getHeader(String header) {
		return props.get(header);
	}

	public Object getBody() {
		return this.body;
	}
}
