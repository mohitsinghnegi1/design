package com.glarimy.composit;

public class ConcreteContainer extends Container {
	@Override
	public void service() {
		System.out.println("ConcreteContainer::service - start");
		super.service();
		System.out.println("ConcreteContainer::service - stop");
	}
}
