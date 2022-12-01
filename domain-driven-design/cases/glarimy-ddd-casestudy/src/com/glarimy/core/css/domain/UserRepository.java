package com.glarimy.core.css.domain;

public interface UserRepository {
	public User save(User user);

	public boolean isFound(User user);

	public void remove(User user);
}