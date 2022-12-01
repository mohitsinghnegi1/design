package com.glarimy;

import java.util.List;

public interface Storage {
	public User save(User user);
	public User findById(PhoneNumber id);
	public List<User> findByName(Name name);
}
