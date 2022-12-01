package com.glarimy.domain;

import java.util.List;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.DirectoryException;
import com.glarimy.domain.exceptions.DuplicateUserException;
import com.glarimy.domain.exceptions.InvalidUserException;
import com.glarimy.domain.exceptions.UserNotFoundException;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

public class SimpleDirectory implements Directory {
	private Storage store;

	public SimpleDirectory(Storage store) {
		this.store = store;
	}

	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		if (user == null)
			throw new DirectoryException("Invalid User");
		store.save(user);
		return user;
	}

	public User findByPhone(PhoneNumber phoneNumber) throws UserNotFoundException, DirectoryException {
		User result = store.findById(phoneNumber);
		if (result == null)
			throw new UserNotFoundException();
		return result;
	}

	public List<User> searchByName(Name name) throws DirectoryException {
		return store.findByName(name);
	}
}