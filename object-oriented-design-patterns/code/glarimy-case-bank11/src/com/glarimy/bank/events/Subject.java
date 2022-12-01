package com.glarimy.bank.events;

public interface Subject {
	public void add(Observer observer);

	public void notify(String message);
}
