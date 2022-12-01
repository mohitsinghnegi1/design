package com.glarimy.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.glarimy.domain.Directory;
import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.UserNotFoundException;
import com.glarimy.domain.vo.PhoneNumber;

public class DirectoryController {

	private Directory directory;

	public DirectoryController(Directory directory) {
		this.directory = directory;
	}

	public UserData register(UserData data) throws Exception {
		User user = data.toUser();
		User registeredUser = directory.add(user);
		return new UserData(registeredUser);
	}

	public Optional<UserData> findByPhone(long phone) throws Exception {
		try {
			User user = directory.findByPhone(new PhoneNumber(phone)).orElseThrow(() -> new UserNotFoundException());
			return Optional.of(new UserData(user));
		} catch (UserNotFoundException e) {
			return Optional.empty();
		}
	}

	public List<UserData> findByName(String name) throws Exception {
		List<User> users = directory.searchByCondition(u -> u.getName().getValue().contains(name));
		List<UserData> list = new ArrayList<UserData>();
		for (User user : users)
			list.add(new UserData(user));
		return list;
	}

}
