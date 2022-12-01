package com.glarimy.core.ums.app;

import com.glarimy.core.ums.domain.Phone;
import com.glarimy.core.ums.domain.User;

public interface UserService {
	public User register(User user);

	public void unregister(Phone phone);

}
