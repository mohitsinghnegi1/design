package com.dir.service.data;

import java.util.HashMap;
import java.util.Map;

import com.dir.api.model.User;

public class InMemoryStorage implements Storage {
	private Map<Integer, User> users;
	private int counter;
	private static InMemoryStorage INSTANCE;

	private InMemoryStorage() {
		users = new HashMap<Integer, User>();
	}

	public static synchronized InMemoryStorage get() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryStorage();
		return INSTANCE;
	}

	@Override
	public User create(User user) {
		user.setId(++counter);
		users.put(counter, user);
		return user;
	}

	@Override
	public User read(int id) {
		return users.get(id);
	}

}
