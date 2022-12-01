package com.glarimy.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.DirectoryException;
import com.glarimy.domain.exceptions.DuplicateUserException;
import com.glarimy.domain.exceptions.InvalidUserException;
import com.glarimy.domain.exceptions.UserNotFoundException;
import com.glarimy.domain.vo.PhoneNumber;

public class MetricsCollector implements Directory {
	private Directory target;

	public MetricsCollector(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		long start = new Date().getTime();
		User result = target.add(user);
		System.out.println("Metrics: added user in " + (new Date().getTime() - start) + " ms");
		return result;
	}

	@Override
	public Optional<User> findByPhone(PhoneNumber phoneNumber) throws UserNotFoundException, DirectoryException {
		long start = new Date().getTime();
		Optional<User> user = target.findByPhone(phoneNumber);
		System.out.println("Metrics: found user in " + (new Date().getTime() - start) + " ms");
		return user;
	}

	@Override
	public List<User> searchByCondition(Predicate<User> condition) throws DirectoryException {
		long start = new Date().getTime();
		List<User> users = target.searchByCondition(condition);
		System.out.println("Metrics: found user in " + (new Date().getTime() - start) + " ms");
		return users;
	}

}
