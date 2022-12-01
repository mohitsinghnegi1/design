package com.glarimy.mediator;

public class Application {
	public static void main(String[] args) throws Exception {
		Mediator mediator = new Mediator();
		ConcreteMember member = new ConcreteMember(mediator);
		mediator.add(member);
		mediator.add(new ConcreteMember(mediator));
		mediator.add(new ConcreteMember(mediator));
		mediator.add(new ConcreteMember(mediator));
		mediator.add(new ConcreteMember(mediator));
		mediator.add(new ConcreteMember(mediator));
		member.execute();
	}
}