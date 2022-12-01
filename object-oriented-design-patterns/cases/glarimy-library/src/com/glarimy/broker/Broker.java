package com.glarimy.broker;

public interface Broker {
	public void publish(Message message);

	public int subscribe(String type, Handler handler);

	public void unsubscribe(int id);
}
