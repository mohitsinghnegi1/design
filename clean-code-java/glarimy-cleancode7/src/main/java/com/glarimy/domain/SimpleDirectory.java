package com.glarimy.domain;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.DirectoryException;
import com.glarimy.domain.exceptions.DuplicateUserException;
import com.glarimy.domain.exceptions.InvalidUserException;
import com.glarimy.domain.vo.PhoneNumber;

public class SimpleDirectory implements Directory {
	private Storage store;

	public SimpleDirectory(Storage store) {
		this.store = store;
	}

	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		if (user == null)
			throw new DirectoryException("Invalid User");
		store.save(user);
		return user;
	}

	public Optional<User> findByPhone(PhoneNumber phoneNumber) throws DirectoryException {
		return store.findById(phoneNumber);
	}

	public List<User> searchByCondition(Predicate<User> predicate) throws DirectoryException {
		return store.search(predicate);
	}
}