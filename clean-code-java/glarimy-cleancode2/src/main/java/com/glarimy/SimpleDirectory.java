package com.glarimy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDirectory implements Directory {
	private Map<PhoneNumber, User> users = new HashMap<PhoneNumber, User>();

	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		if (user == null)
			throw new DirectoryException("Invalid User");
		users.put(user.getPhoneNumber(), user);
		return user;
	}

	public User findByPhone(PhoneNumber phoneNumber) throws UserNotFoundException, DirectoryException {
		User result = users.get(phoneNumber);
		if (result == null)
			throw new UserNotFoundException();
		return result;
	}

	public List<User> searchByName(Name name) throws DirectoryException {
		List<User> results = new ArrayList<User>();
		for (User user : users.values()) {
			if (user.getName().getValue().contains(name.getValue()))
				results.add(user);
		}
		return results;
	}
}