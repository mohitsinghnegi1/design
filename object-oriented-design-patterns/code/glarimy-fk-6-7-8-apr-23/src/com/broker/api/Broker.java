package com.broker.api;

public interface Broker {
	public void notify(Message message);

	public int register(Receiver handler);

	public void unregister(int id);
}
