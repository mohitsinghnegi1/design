package com.glarimy.mediator;

public class ConcreteMember implements Member {
	private Mediator mediator;

	public ConcreteMember(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void onMessage(String message) {
		System.out.println("Received: " + message);
	}

	public void execute() {
		mediator.notify("Hello");
	}
}
