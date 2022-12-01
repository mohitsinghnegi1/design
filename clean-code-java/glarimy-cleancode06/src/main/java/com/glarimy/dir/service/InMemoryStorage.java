package com.glarimy.dir.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.dir.domain.User;

public class InMemoryStorage implements Storage {
	private Map<Long, User> users;
	
	public InMemoryStorage() {
		users = new HashMap<Long, User>();
	}

	@Override
	public User save(User user) {
		users.put(user.getPhone(), user);
		return user;
	}

	@Override
	public User read(long id) {
		return users.get(id);
	}

	@Override
	public List<User> read(String name) {
		List<User> results = new ArrayList<User>();
		for (User user : users.values()) {
			if (user.getName().contains(name))
				results.add(user);
		}
		return results;
	}

}
