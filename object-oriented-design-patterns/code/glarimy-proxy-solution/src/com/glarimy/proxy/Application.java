package com.glarimy.proxy;

public class Application {
	public static void main(String[] args) throws Exception {
		Component target = new ConcreteComponent();
		Component proxy = new Proxy(target);
		
		proxy.service();
	}
}