package com.glarimy.dir.service;

import java.util.List;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.DuplicateUserException;
import com.glarimy.dir.api.exceptions.InvalidUserException;
import com.glarimy.dir.api.exceptions.UserNotFoundException;
import com.glarimy.dir.domain.User;

public class SimpleDirectory implements Directory{
	private Storage storage;

	public SimpleDirectory(Storage storage) {
		this.storage = storage;
	}

	public User add(User user) throws DuplicateUserException, InvalidUserException, DirectoryException {
		if (user == null)
			throw new InvalidUserException();
		if (storage.read(user.getPhone()) != null)
			throw new DuplicateUserException();
		return storage.save(user);
	}

	public User findByPhone(long phone) throws UserNotFoundException, DirectoryException {
		User user = storage.read(phone);
		if (user == null)
			throw new UserNotFoundException();
		return user;
	}

	public List<User> searchByName(String name) throws DirectoryException {
		return storage.read(name);
	}
}