package com.glarimy.domain;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.PhoneNumber;

public interface Storage {
	public User save(User user);
	public Optional<User> findById(PhoneNumber id);
	public List<User> search(Predicate<User> condition);
}
