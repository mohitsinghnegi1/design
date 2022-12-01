package com.glarimy.decorator;

public class Decorator implements Component {
	private Component target;
	
	public Decorator(Component target) {
		this.target = target;
	}
	
	public void mandatory() {
		this.target.mandatory();
	}
	
	public void optional() {
		System.out.println("Decorator::optional pre processing");
		this.target.mandatory();
		System.out.println("Decorator::optional post processing");

	}
}
