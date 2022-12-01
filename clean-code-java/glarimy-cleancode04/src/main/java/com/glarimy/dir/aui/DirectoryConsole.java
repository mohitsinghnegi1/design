package com.glarimy.dir.aui;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.Factory;
import com.glarimy.dir.api.ObjectFactory;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.UserNotFoundException;
import com.glarimy.dir.domain.User;

public class DirectoryConsole {

	public static void main(String[] args) {
		Factory factory = new ObjectFactory();
		Directory dir;
		try {
			dir = (Directory) factory.get("dir");
			User user = new User();
			user.setName("Krishna");
			user.setEmail("krishna@glarimy.com");
			user.setPhone(9731423166L);
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
