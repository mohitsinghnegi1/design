package com.broker.api;

public interface Handler {
	public void on(Message message);

	public String getType();
}
