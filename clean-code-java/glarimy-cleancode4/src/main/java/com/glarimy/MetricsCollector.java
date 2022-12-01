package com.glarimy;

import java.util.Date;
import java.util.List;

public class MetricsCollector implements Directory {
	private Directory target;

	public MetricsCollector(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		long start = new Date().getTime();
		User result = target.add(user);
		long end = new Date().getTime();
		System.out.println("Metrics: added user in " + (end - start) + " ms");
		return result;
	}

	@Override
	public User findByPhone(PhoneNumber phoneNumber) throws UserNotFoundException, DirectoryException {
		long start = new Date().getTime();
		User user = target.findByPhone(phoneNumber);
		long end = new Date().getTime();
		System.out.println("Metrics: found user in " + (end - start) + " ms");
		return user;
	}

	@Override
	public List<User> searchByName(Name name) throws DirectoryException {
		long start = new Date().getTime();
		List<User> users = target.searchByName(name);
		long end = new Date().getTime();
		System.out.println("Metrics: found user in " + (end - start) + " ms");
		return users;
	}

}
