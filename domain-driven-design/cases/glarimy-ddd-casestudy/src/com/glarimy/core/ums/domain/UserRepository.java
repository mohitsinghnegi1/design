package com.glarimy.core.ums.domain;

import java.util.List;

public interface UserRepository {
	public User save(User user);

	public User update(User user);

	public User findOne(Phone phone);

	public List<User> findAll();

	public List<User> findByCity(String city);

	public List<User> findByStatus(boolean status);
}