package com.glarimy.dir.service;

import java.util.List;

import com.glarimy.dir.domain.User;

public interface Storage {
	public User save(User user);

	public User read(long id);

	public List<User> read(String name);
}
