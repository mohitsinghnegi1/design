package com.glarimy.proxy;

public class Proxy implements Component {
	private Component target;

	public Proxy(Component target) {
		this.target = target;
	}

	public void service() throws Exception {
		System.out.println("Proxy::pre processing");
		try {
			target.service();
			System.out.println("Proxy::post processing");
		}catch(Exception e) {
			System.out.println("Proxy::error handling");
			throw e;
		}
	}

}
