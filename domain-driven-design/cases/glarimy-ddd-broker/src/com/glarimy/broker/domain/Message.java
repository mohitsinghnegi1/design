package com.glarimy.broker.domain;

import java.util.Date;

public class Message {
	private Topic topic;
	private Object body;
	private Date time;

	public Message(Topic topic, Object body) {
		super();
		this.topic = topic;
		this.body = body;
		this.time = new Date();
	}

	public Topic getTopic() {
		return topic;
	}

	public Object getBody() {
		return body;
	}

	public Date getTime() {
		return time;
	}

	public boolean equals(Message other) {
		if (this.topic.equals(other.topic) && this.body.equals(other.getBody())
				&& this.time.compareTo(other.getTime()) == 0)
			return true;
		return false;
	}

}
