package com.glarimy.infra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.glarimy.domain.Storage;
import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.PhoneNumber;

public class InMemoryStorage implements Storage {
	private Map<PhoneNumber, User> users = new HashMap<PhoneNumber, User>();

	@Override
	public User save(User user) {
		users.put(user.getPhoneNumber(), user);
		return user;
	}

	@Override
	public Optional<User> findById(PhoneNumber id) {
		User user = users.get(id);
		if (user == null)
			return Optional.empty();
		return Optional.of(user);
	}

	@Override
	public List<User> search(Predicate<User> condition) {
		return users.values().stream().filter(condition).collect(Collectors.toList());
	}

}
