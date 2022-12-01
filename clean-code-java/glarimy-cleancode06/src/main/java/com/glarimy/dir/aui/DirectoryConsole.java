package com.glarimy.dir.aui;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.Factory;
import com.glarimy.dir.api.ObjectFactory;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.UserNotFoundException;
import com.glarimy.dir.domain.User;

public class DirectoryConsole {

	public static void main(String[] args) {
		Map<String, String> config = new HashMap<>();
		config.put("audit", "disabled");
		Factory factory = new ObjectFactory(config);
		Directory dir;
		try {
			dir = (Directory) factory.get("dir");
			User user = new User.UserBuilder("Krishna", 9731423166L, "Bengaluru").addEmail("krishna@glarimy.com")
					.addPincode(560016).addLocation("Pai Layout").build();
			dir.add(user);
			User result = dir.findByPhone(9731423166L);
			System.out.println(result.getName());
		} catch (UserNotFoundException e) {
			System.out.println("User not found");
		} catch (DirectoryException e) {
			System.out.println("Internal error. Try later!");
		} catch (Exception e) {
			System.out.println("Configuratio error");
		}
	}

}
