package com.glarimy;

import java.util.List;

public class PrintableDirectory implements Directory {
	private Directory target;

	public PrintableDirectory(Directory target) {
		this.target = target;
	}

	@Override
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException {
		return target.add(user);
	}

	@Override
	public User findByPhone(PhoneNumber phone) throws UserNotFoundException, DirectoryException {
		return target.findByPhone(phone);
	}

	@Override
	public List<User> searchByName(Name name) throws DirectoryException {
		return target.searchByName(name);
	}

	public void findAndPrintByPhone(PhoneNumber number) throws UserNotFoundException, DirectoryException {
		System.out.println(target.findByPhone(number));
	}

}
