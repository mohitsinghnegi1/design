package com.glarimy.core.css.infra;

import java.util.ArrayList;
import java.util.List;

import com.glarimy.core.css.domain.User;
import com.glarimy.core.css.domain.UserRepository;
import com.glarimy.generic.framework.Singleton;

@Singleton
public class InMemoryUserRepository implements UserRepository {
	private List<User> users;
	private static InMemoryUserRepository INSTANCE;

	private InMemoryUserRepository() {
		users = new ArrayList<User>();
	}

	public static synchronized InMemoryUserRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryUserRepository();
		return INSTANCE;
	}

	@Override
	public User save(User user) {
		users.add(user);
		return user;
	}

	@Override
	public boolean isFound(User user) {
		for (User current : users) {
			if (current.equals(user))
				return true;
		}
		return false;
	}

	@Override
	public void remove(User user) {
		for (User current : users) {
			if (current.equals(user)) {
				users.remove(current);
				break;
			}
		}
	}
}
