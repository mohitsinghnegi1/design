package com.glarimy;

import java.util.List;

public interface Directory {
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException;

	public User findByPhone(long phone) throws UserNotFoundException, DirectoryException;

	public List<User> searchByName(String name) throws DirectoryException;
}
