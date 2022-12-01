package com.glarimy.messaging.api;

public interface Handler {
	public void on(Event event);
	public String getTopic();
}
