package com.glarimy.adapter;

public class ComponentAdapter implements Adapter {
	private Component component;

	public ComponentAdapter() {
		this.component = new Component();
	}

	@Override
	public void execute() {
		this.component.process();
	}

}
