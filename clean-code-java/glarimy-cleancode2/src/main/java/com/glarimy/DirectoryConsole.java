package com.glarimy;

import java.util.List;

public class DirectoryConsole {
	public static void main(String[] args) throws Exception {
		Directory dir = new SimpleDirectory();
		PhoneNumber phone = new PhoneNumber(9731423166L);
		Name name = new Name("Krishna");
		Email email = new Email("krishna@glarimy.com");
		User user = new User(phone, name, email);

		dir.add(user);
		User result = dir.findByPhone(phone);
		System.out.println("Email: " + result.getEmail());

		List<User> results = dir.searchByName(name);
		System.out.println("Number of results: " + results.size());
	}
}
