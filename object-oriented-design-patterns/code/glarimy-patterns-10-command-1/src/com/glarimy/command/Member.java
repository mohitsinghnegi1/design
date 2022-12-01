package com.glarimy.command;

public class Member {
	private MessageBus mediator;

	public Member(MessageBus mediator) {
		this.mediator = mediator;
		this.mediator.register(new Command() {

			@Override
			public void onMessage(String message) {
				System.out.println("Received " + message);
			}
		});
	}

	public void execute() {
		mediator.notify("Hello");
	}
}
