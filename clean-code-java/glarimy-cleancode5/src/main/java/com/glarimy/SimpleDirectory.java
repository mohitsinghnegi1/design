package com.glarimy;

import java.util.List;

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