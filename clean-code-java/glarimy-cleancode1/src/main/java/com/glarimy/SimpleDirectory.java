package com.glarimy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDirectory implements Directory {
	private Map<Long, User> users = new HashMap<Long, User>();

	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		if (user == null)
			throw new DirectoryException("Invalid User");
		if (user.getName() == null || user.getName().trim().length() < 6)
			throw new InvalidUserException("Invalid name");
		if (user.getPhone() < 0 && Long.toString(user.getPhone()).length() != 10)
			throw new InvalidUserException("Invalid phone number");
		if (user.getEmail() == null || !user.getEmail().contains("@"))
			throw new InvalidUserException("Invalid email");

		if (users.containsKey(user.getPhone()))
			throw new DuplicateUserException("User already exists");
		
		users.put(user.getPhone(), user);
		return user;
	}

	public User findByPhone(long phone) throws UserNotFoundException, DirectoryException {
		User result = users.get(phone);
		if (result == null)
			throw new UserNotFoundException();
		return result;
	}

	public List<User> searchByName(String name) throws DirectoryException {
		List<User> results = new ArrayList<User>();
		for (User user : users.values()) {
			if (user.getName().contains(name))
				results.add(user);
		}
		return results;
	}
}