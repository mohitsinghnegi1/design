package com.glarimy.dir.api;

import java.util.List;

import com.glarimy.dir.domain.User;

public interface Directory {
	public User add(User user);

	public User findByPhone(long phone);

	public List<User> searchByName(String name);
}
