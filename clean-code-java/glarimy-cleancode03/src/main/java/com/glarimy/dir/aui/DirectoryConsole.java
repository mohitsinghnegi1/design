package com.glarimy.dir.aui;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.UserNotFoundException;
import com.glarimy.dir.service.InMemoryStorage;
import com.glarimy.dir.service.SimpleDirectory;
import com.glarimy.dir.service.Storage;

public class DirectoryConsole {

	public static void main(String[] args) {
		Storage storage = new InMemoryStorage();
		Directory dir = new SimpleDirectory(storage);
		try {
			dir.findByPhone(123);
		} catch (UserNotFoundException e) {
			System.out.println("User not found");
		} catch (DirectoryException e) {
			System.out.println("Internal error. Try later!");
		}
	}

}
