package com.glarimy.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.DirectoryException;
import com.glarimy.domain.exceptions.DuplicateUserException;
import com.glarimy.domain.exceptions.InvalidUserException;
import com.glarimy.domain.vo.PhoneNumber;

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
	public Optional<User> findByPhone(PhoneNumber phoneNumber) throws DirectoryException {
		System.out.println(new Date() + " - finding user: " + phoneNumber.getValue());
		Optional<User> user = target.findByPhone(phoneNumber);
		System.out.println(new Date() + " - found user: " + phoneNumber.getValue());
		return user;
	}

	@Override
	public List<User> searchByCondition(Predicate<User> condition) throws DirectoryException {
		System.out.println(new Date() + " - searching users ");
		List<User> users = target.searchByCondition(condition);
		System.out.println(new Date() + " - searched user ");
		return users;
	}

}
