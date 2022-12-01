package com.glarimy.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
	private List<Member> members;

	public Mediator() {
		members = new ArrayList<Member>();
	}

	public void add(Member member) {
		members.add(member);
	}

	public void notify(String message) {
		for (Member member : members)
			member.onMessage(message);

	}
}
