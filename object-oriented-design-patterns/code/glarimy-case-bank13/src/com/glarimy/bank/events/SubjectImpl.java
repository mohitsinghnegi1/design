package com.glarimy.bank.events;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubjectImpl implements Subject {
	private List<Observer> observers;
	private ExecutorService pool;

	public SubjectImpl() {
		observers = new ArrayList<Observer>();
		pool = Executors.newFixedThreadPool(2);
	}

	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notify(String message) {
		observers.stream().forEach(o -> pool.submit(() -> o.on(message)));
	}

}