package com.glarimy.command;

public class Application {
	public static void main(String[] args) throws Exception {
		MessageBus mediator = new MessageBus();
		Member member = new Member(mediator);
		new Member(mediator);
		new Member(mediator);
		new Member(mediator);
		new Member(mediator);
		member.execute();
	}
}