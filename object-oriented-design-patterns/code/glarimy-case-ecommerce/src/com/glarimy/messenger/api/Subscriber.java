package com.glarimy.messenger.api;

public interface Subscriber {
	public void on(Event<?> event);

	public String getTopic();
}
