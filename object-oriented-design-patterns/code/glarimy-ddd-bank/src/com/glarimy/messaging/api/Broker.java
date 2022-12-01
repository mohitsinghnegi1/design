package com.glarimy.messaging.api;

public interface Broker {
	public void register(Handler handler);
	public void notify(Event event);
}
