package com.glarimy.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.DirectoryException;
import com.glarimy.domain.exceptions.DuplicateUserException;
import com.glarimy.domain.exceptions.InvalidUserException;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

@Service
public class SimpleDirectory implements Directory {
	@Autowired
	private Storage store;

	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		if (user == null)
			throw new DirectoryException("Invalid User");
		store.save(user);
		return user;
	}

	public Optional<User> findByPhone(PhoneNumber phoneNumber) throws DirectoryException {
		return store.findById(phoneNumber);
	}

	public List<User> searchByName(Name name) throws DirectoryException {
		return store.findByName(name);
	}
}