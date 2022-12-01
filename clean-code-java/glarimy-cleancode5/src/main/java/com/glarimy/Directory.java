package com.glarimy;

import java.util.List;

public interface Directory {
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException;

	public User findByPhone(PhoneNumber phone) throws UserNotFoundException, DirectoryException;

	public List<User> searchByName(Name name) throws DirectoryException;
}
