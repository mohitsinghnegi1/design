package com.glarimy.dir.service;

import java.util.Date;
import java.util.List;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.DuplicateUserException;
import com.glarimy.dir.api.exceptions.InvalidUserException;
import com.glarimy.dir.api.exceptions.UserNotFoundException;
import com.glarimy.dir.domain.User;

public class Auditor implements Directory {
	private Directory target;

	public Auditor(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws DuplicateUserException, InvalidUserException, DirectoryException {
		System.out.println(new Date() + ": add() -entering");
		User result = target.add(user);
		System.out.println(new Date() + ": add() -leaving");
		return result;
	}

	@Override
	public User findByPhone(long phone) throws UserNotFoundException, DirectoryException {
		System.out.println(new Date() + ": findByPhone() -entering");
		User result = target.findByPhone(phone);
		System.out.println(new Date() + ": findByPhone() -leaving");
		return result;
	}

	@Override
	public List<User> searchByName(String name) throws DirectoryException {
		System.out.println(new Date() + ": searchByName() -entering");
		List<User> result = target.searchByName(name);
		System.out.println(new Date() + ": searchByName() -leaving");
		return result;
	}

}
