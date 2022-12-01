package com.glarimy.proxy;

public class ConcreteComponent implements Component {

	public void service() throws Exception {
		System.out.println("ConcreteComponent::service");
	}

}
