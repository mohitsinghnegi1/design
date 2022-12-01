package com.glarimy.domain;

import java.util.List;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

public interface Storage {
	public User save(User user);
	public User findById(PhoneNumber id);
	public List<User> findByName(Name name);
}
