package com.glarimy.command;

import java.util.ArrayList;
import java.util.List;

public class MessageBus {
	private List<Command> handlers;

	public MessageBus() {
		handlers = new ArrayList<Command>();
	}

	public void register(Command command) {
		handlers.add(command);
	}

	public void notify(String message) {
		for (Command handler : handlers)
			handler.onMessage(message);
	}
}
