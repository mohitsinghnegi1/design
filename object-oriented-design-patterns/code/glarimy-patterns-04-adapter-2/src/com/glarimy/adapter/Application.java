package com.glarimy.adapter;

public class Application {
	public static void main(String[] args) throws Exception{
		ObjectFactory factory = new ObjectFactory("conf.properties");
		Adapter adapter = (Adapter) factory.get("adapter");
		adapter.execute();
	}
}
