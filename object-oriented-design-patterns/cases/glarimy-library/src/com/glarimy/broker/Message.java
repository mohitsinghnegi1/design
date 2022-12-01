package com.glarimy.broker;

public class Message {
	private String type;
	private String body;

	public Message(String type, String body) {
		super();
		this.type = type;
		this.body = body;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
