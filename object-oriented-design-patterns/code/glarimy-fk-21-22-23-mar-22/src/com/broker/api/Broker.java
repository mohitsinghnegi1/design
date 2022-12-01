package com.broker.api;

public interface Broker {
	public void publish(Message message);

	public int subscribe(Handler handler);

	public void unsubscribe(int id);
}
