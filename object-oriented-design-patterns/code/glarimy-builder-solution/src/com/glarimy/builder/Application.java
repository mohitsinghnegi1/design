package com.glarimy.builder;

public class Application {
	public static void main(String[] args) throws Exception {
		Component component = new Component.ComponentBuilder().add("color").add("title").add("picture").build();
		component.service();
	}
}
