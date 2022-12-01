package com.glarimy.bank.eight.events;

public interface Subject {
	public void add(Observer observer);

	public void notify(String message);
}
