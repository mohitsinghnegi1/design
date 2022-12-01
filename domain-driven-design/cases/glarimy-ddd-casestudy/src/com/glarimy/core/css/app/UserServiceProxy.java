package com.glarimy.core.css.app;

import com.glarimy.core.ums.app.UserService;
import com.glarimy.core.ums.domain.Phone;
import com.glarimy.core.ums.domain.User;

public class UserServiceProxy implements UserService {
	private UserService target;

	public UserServiceProxy(UserService target) {
		this.target = target;
	}

	@Override
	public User register(User user) {
		User result = target.register(user);
		return result;

	}

	@Override
	public void unregister(Phone phone) {
		target.unregister(phone);
	}
}
