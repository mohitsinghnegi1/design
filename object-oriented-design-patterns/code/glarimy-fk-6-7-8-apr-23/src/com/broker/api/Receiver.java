package com.broker.api;

public interface Receiver {
	public void recieve(Message message);

	public String getType();
}
