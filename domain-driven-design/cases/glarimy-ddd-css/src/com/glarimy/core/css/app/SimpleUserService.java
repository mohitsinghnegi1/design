package com.glarimy.core.css.app;

import com.glarimy.core.ums.app.UserService;
import com.glarimy.core.ums.domain.Phone;
import com.glarimy.core.ums.domain.User;
import com.glarimy.core.ums.domain.UserNotFoundException;
import com.glarimy.core.ums.domain.UserRepository;
import com.glarimy.generic.framework.ObjectFactory;

public class SimpleUserService implements UserService {
	private UserRepository repo;

	public SimpleUserService() throws Exception {
		this.repo = (UserRepository) ObjectFactory.get("user.repo");
	}

	@Override
	public User register(User user) {
		user.activate();
		return repo.save(user);
	}

	@Override
	public void unregister(Phone phone) {
		User user = repo.findOne(phone);
		if (user == null)
			throw new UserNotFoundException();
		user.deactivate();
		repo.update(user);
	}
}
