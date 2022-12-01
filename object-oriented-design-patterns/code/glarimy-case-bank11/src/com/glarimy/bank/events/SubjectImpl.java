package com.glarimy.bank.events;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
	private List<Observer> observers;

	public SubjectImpl() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notify(String message) {
		for (Observer o : observers)
			o.on(message);
	}

}
