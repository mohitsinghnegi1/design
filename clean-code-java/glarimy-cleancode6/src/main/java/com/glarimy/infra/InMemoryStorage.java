package com.glarimy.infra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.domain.Storage;
import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

public class InMemoryStorage implements Storage {
	private Map<PhoneNumber, User> users = new HashMap<PhoneNumber, User>();

	@Override
	public User save(User user) {
		users.put(user.getPhoneNumber(), user);
		return user;
	}

	@Override
	public User findById(PhoneNumber id) {
		return users.get(id);
	}

	@Override
	public List<User> findByName(Name name) {
		List<User> results = new ArrayList<User>();
		for (User user : users.values()) {
			if (user.getName().getValue().contains(name.getValue()))
				results.add(user);
		}
		return results;

	}

}
