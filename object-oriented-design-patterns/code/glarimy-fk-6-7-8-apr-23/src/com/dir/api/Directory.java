package com.dir.api;

import com.dir.api.exceptions.InvalidUserException;
import com.dir.api.exceptions.UserNotFoundException;
import com.dir.api.model.User;

public interface Directory {
	public User add(User user) throws InvalidUserException;

	public User find(int id) throws UserNotFoundException;
}
