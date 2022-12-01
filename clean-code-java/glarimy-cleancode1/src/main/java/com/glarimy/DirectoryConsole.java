package com.glarimy;

import java.util.List;

public class DirectoryConsole {
	public static void main(String[] args) {
		Directory dir = new SimpleDirectory();
		User user = new User();
		user.setPhone(123L);
		user.setName("Krishna");
		user.setEmail("krishna@glarimy.com");

		try {
			dir.add(user);
		} catch (InvalidUserException iue) {
			iue.printStackTrace();
		} catch (DuplicateUserException due) {
			due.printStackTrace();
		} catch (DirectoryException de) {
			de.printStackTrace();
		}

		try {
			User result = dir.findByPhone(123L);
			System.out.println("Email: " + result.getEmail());
		} catch (UserNotFoundException unfe) {
			System.out.println("User is not found");
		} catch (DirectoryException de) {
			System.out.println("Internal error. Try again!");
		}

		try {
			List<User> results = dir.searchByName("Krishna");
			System.out.println("Number of results: " + results.size());
		} catch (DirectoryException de) {
			System.out.println("Internal error. Try again!");
		}
	}
}
