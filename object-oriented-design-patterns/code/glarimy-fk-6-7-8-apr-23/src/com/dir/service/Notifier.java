package com.dir.service;

import com.broker.api.Broker;
import com.broker.api.Message;
import com.broker.api.MessageBuilder;
import com.dir.api.Directory;
import com.dir.api.exceptions.InvalidUserException;
import com.dir.api.exceptions.UserNotFoundException;
import com.dir.api.model.User;

public class Notifier implements Directory {
	private Directory target;
	private Broker broker;

	public Notifier(Directory target, Broker broker) {
		this.target = target;
		this.broker = broker;
	}

	@Override
	public User add(User user) throws InvalidUserException {
		User result = target.add(user);
		Message message = new MessageBuilder("com.dir.user.add").setBody(result).build();
		broker.notify(message);
		return result;
	}

	@Override
	public User find(int id) throws UserNotFoundException {
		return target.find(id);
	}

}
