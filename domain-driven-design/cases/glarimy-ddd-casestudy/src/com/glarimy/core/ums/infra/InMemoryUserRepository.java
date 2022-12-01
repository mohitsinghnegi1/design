package com.glarimy.core.ums.infra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.glarimy.core.ums.domain.DuplicateUserException;
import com.glarimy.core.ums.domain.Phone;
import com.glarimy.core.ums.domain.User;
import com.glarimy.core.ums.domain.UserNotFoundException;
import com.glarimy.core.ums.domain.UserRepository;
import com.glarimy.generic.framework.Singleton;

@Singleton
public class InMemoryUserRepository implements UserRepository {
	private Map<Phone, User> users;
	private static InMemoryUserRepository INSTANCE;

	private InMemoryUserRepository() {
		users = new HashMap<Phone, User>();
	}

	public static synchronized InMemoryUserRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryUserRepository();
		return INSTANCE;
	}

	@Override
	public User save(User user) {
		if (users.containsKey(user.getPhone()))
			throw new DuplicateUserException();
		users.put(user.getPhone(), user);
		return user;
	}

	@Override
	public User update(User user) {
		if (!users.containsKey(user.getPhone()))
			throw new UserNotFoundException();
		users.put(user.getPhone(), user);
		return user;
	}

	@Override
	public User findOne(Phone phone) {
		return users.get(phone);
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}

	@Override
	public List<User> findByCity(String city) {
		return users.values().stream().filter(u -> u.getAddress().getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
	}

	@Override
	public List<User> findByStatus(boolean status) {
		return users.values().stream().filter(u -> u.isActive() == status).collect(Collectors.toList());
	}

}
