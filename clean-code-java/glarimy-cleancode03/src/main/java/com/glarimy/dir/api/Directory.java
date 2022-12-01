package com.glarimy.dir.api;

import java.util.List;

import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.DuplicateUserException;
import com.glarimy.dir.api.exceptions.InvalidUserException;
import com.glarimy.dir.api.exceptions.UserNotFoundException;
import com.glarimy.dir.domain.User;

public interface Directory {
	public User add(User user)throws DuplicateUserException, InvalidUserException, DirectoryException;

	public User findByPhone(long phone)throws UserNotFoundException, DirectoryException;

	public List<User> searchByName(String name)throws DirectoryException;
}
