package com.glarimy.broker;

public class ConcreteFactory implements Factory {
	@Override
	public Broker getBroker() {
		return ConcreteBroker.getInstance();
	}
}
