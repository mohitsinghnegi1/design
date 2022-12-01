package com.dir.service;

import com.dir.api.Directory;
import com.dir.api.exceptions.InvalidUserException;
import com.dir.api.exceptions.UserNotFoundException;
import com.dir.api.model.User;

public class Validator implements Directory {
	private Directory target;

	public Validator(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException {
		if (user == null || user.getName() == null || user.getName().trim().length() < 8
				|| user.getPhone() < 6000000000L)
			throw new InvalidUserException();
		return target.add(user);
	}

	@Override
	public User find(int id) throws UserNotFoundException {
		return target.find(id);
	}

}
