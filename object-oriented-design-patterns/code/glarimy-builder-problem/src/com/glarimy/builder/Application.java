package com.glarimy.builder;

public class Application {
	public static void main(String[] args) throws Exception {
		Component order = new Component("color", "title", "picture");
		order.service();
	}
}
