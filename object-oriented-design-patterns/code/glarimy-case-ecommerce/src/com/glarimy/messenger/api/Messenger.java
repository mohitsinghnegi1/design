package com.glarimy.messenger.api;

public interface Messenger {
	public int add(Subscriber subscriber);
	
	public void remove(int sid);

	public void notify(Event<?> event);
}
