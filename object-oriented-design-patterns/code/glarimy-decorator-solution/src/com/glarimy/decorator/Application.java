package com.glarimy.decorator;

public class Application {
	public static void main(String[] args) throws Exception {
		Component comp = new ConcreteComponent();
		comp.mandatory();
		Decorator decorator = new Decorator(comp);
		decorator.mandatory();
		decorator.optional();
	}
}