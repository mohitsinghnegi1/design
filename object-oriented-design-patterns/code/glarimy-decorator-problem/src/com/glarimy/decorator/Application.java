package com.glarimy.decorator;

public class Application {
	public static void main(String[] args) throws Exception {
		Component comp = new Component();
		comp.mandatory();
		comp.optional();
	}
}