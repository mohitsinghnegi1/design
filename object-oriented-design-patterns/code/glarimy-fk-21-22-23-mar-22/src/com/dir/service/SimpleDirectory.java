package com.dir.service;

import com.dir.api.Directory;
import com.dir.api.exceptions.InvalidUserException;
import com.dir.api.exceptions.UserNotFoundException;
import com.dir.api.model.User;
import com.dir.service.data.Storage;

public class SimpleDirectory implements Directory {
	private Storage storage;

	public SimpleDirectory(Storage storage) {
		this.storage = storage;
	}

	@Override
	public User add(User user) throws InvalidUserException {
		return storage.create(user);
	}

	@Override
	public User find(int id) throws UserNotFoundException {
		User user = storage.read(id);
		if (user == null)
			throw new UserNotFoundException();
		return user;
	}

}
