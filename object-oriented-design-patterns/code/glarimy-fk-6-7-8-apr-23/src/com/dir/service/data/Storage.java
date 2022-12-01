package com.dir.service.data;

import com.dir.api.model.User;

public interface Storage {
	public User create(User user);

	public User read(int id);
}
