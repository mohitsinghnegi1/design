package com.glarimy.app;

import java.util.ArrayList;
import java.util.List;

import com.glarimy.domain.Directory;
import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.Name;
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

	public UserData findByPhone(long phone) throws Exception {
		User user = directory.findByPhone(new PhoneNumber(phone));
		return new UserData(user);

	}

	public List<UserData> findByName(String name) throws Exception {
		List<User> users = directory.searchByName(new Name(name));
		List<UserData> list = new ArrayList<UserData>();
		for (User user : users)
			list.add(new UserData(user));
		return list;
	}

}
