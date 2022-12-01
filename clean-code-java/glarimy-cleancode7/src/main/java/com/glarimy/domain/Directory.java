package com.glarimy.domain;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.DirectoryException;
import com.glarimy.domain.exceptions.DuplicateUserException;
import com.glarimy.domain.exceptions.InvalidUserException;
import com.glarimy.domain.vo.PhoneNumber;

public interface Directory {
	public User add(User user) throws InvalidUserException, DuplicateUserException, DirectoryException;

	public Optional<User> findByPhone(PhoneNumber phone) throws DirectoryException;

	public List<User> searchByCondition(Predicate<User> condition) throws DirectoryException;
}
