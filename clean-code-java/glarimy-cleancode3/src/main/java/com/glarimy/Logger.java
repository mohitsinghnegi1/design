package com.glarimy;

import java.util.Date;
import java.util.List;

public class Logger implements Directory {
	private Directory target;

	public Logger(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		System.out.println(new Date() + " - adding user: " + user.getPhoneNumber().getValue());
		User result = target.add(user);
		System.out.println(new Date() + " - added user: " + user.getPhoneNumber().getValue());
		return result;
	}

	@Override
	public User findByPhone(PhoneNumber phoneNumber) throws UserNotFoundException, DirectoryException {
		System.out.println(new Date() + " - finding user: " + phoneNumber.getValue());
		User user = target.findByPhone(phoneNumber);
		System.out.println(new Date() + " - found user: " + phoneNumber.getValue());
		return user;
	}

	@Override
	public List<User> searchByName(Name name) throws DirectoryException {
		System.out.println(new Date() + " - searching user: " + name.getValue());
		List<User> users = target.searchByName(name);
		System.out.println(new Date() + " - searched user: " + name.getValue());
		return users;
	}

}
