package com.glarimy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDirectory  {
	private Map<Long, User> users;
	
	public SimpleDirectory() {
		users = new HashMap<Long, User>();
	}

	public User add(User user) {
		if(user == null)
			throw new RuntimeException("Invalid user");
		if(users.containsKey(user.getPhone()))
			throw new RuntimeException("Duplicate User");
		users.put(user.getPhone(), user);
		return user;
	}

	public User findByPhone(long phone) {
		if(users.containsKey(phone))
			return users.get(phone);
		throw new RuntimeException("User not found");
	}

	public List<User> searchByName(String name) {
		List<User> results = new ArrayList<User>();
		for (User user : users.values()) {
			if (user.getName().contains(name))
				results.add(user);
		}
		return results;
	}
}