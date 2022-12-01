package com.glarimy;

import java.util.List;

public interface Directory {
	public User add(User user);

	public User findByPhone(long phone);

	public List<User> searchByName(String name);
}
