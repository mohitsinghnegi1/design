package com.dir.service;

import java.util.Date;

import com.dir.api.Directory;
import com.dir.api.exceptions.DirectoryException;
import com.dir.api.exceptions.InvalidUserException;
import com.dir.api.exceptions.UserNotFoundException;
import com.dir.api.model.User;

public class Logger implements Directory {
	private Directory target;

	public Logger(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException {
		System.out.println(new Date() + ": adding " + user);
		try {
			User result = target.add(user);
			System.out.println(new Date() + ": added " + result);
			return result;
		} catch (InvalidUserException iue) {
			System.out.println(new Date() + ": " + user + " is invalid");
			iue.printStackTrace();
			throw iue;
		} catch (DirectoryException de) {
			System.out.println(new Date() + "failed to add " + user);
			de.printStackTrace();
			throw de;
		}
	}

	@Override
	public User find(int id) throws UserNotFoundException {
		System.out.println(new Date() + ": finding user with id: " + id);
		try {
			User result = target.find(id);
			System.out.println(new Date() + ": found " + result);
			return result;
		} catch (UserNotFoundException unf) {
			System.out.println(new Date() + "user with id : " + id + " is not found");
			unf.printStackTrace();
			throw unf;
		} catch (DirectoryException de) {
			System.out.println(new Date() + "failed to find user with id: " + id);
			de.printStackTrace();
			throw de;
		}
	}

}
