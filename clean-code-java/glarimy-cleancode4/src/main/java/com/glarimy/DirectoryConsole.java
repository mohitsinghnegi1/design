package com.glarimy;

import java.util.List;

public class DirectoryConsole {
	public static void main(String[] args) throws Exception {
		Factory factory = new ObjectFactory();
		Directory dir = (Directory) factory.get("directory");
		PhoneNumber phone = new PhoneNumber(9731423166L);
		Name name = new Name("Krishna");
		Email email = new Email("krishna@glarimy.com");
		User user = new User(phone, name, email);

		dir.add(user);
		//User result = dir.findByPhone(phone);
		//System.out.println(">>>> Found user with email: " + result.getEmail().getValue());
		PrintableDirectory printer = new PrintableDirectory(dir);
		printer.findAndPrintByPhone(phone);

		List<User> results = dir.searchByName(name);
		System.out.println(">>>> Found " + results.size() + " result(s)");
	}
}
