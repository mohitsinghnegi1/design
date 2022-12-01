package com.client;

import com.dir.api.Directory;
import com.dir.api.exceptions.InvalidUserException;
import com.dir.api.exceptions.UserNotFoundException;
import com.dir.api.model.User;

public class PrintableDirectory implements Directory {
	private Directory target;

	public PrintableDirectory(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException {
		return target.add(user);
	}

	@Override
	public User find(int id) throws UserNotFoundException {
		return target.find(id);
	}

	public void print(int id) throws UserNotFoundException {
		User user = target.find(id);
		System.out.println("USER PROFILE");
		System.out.println("------------");
		System.out.println("Id: " + user.getId());
		System.out.println("Name: " + user.getName());
		System.out.println("Phone Number: " + user.getPhone());
	}

}
