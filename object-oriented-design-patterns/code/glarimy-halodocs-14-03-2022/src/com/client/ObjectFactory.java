package com.client;

import java.io.FileReader;
import java.util.Properties;

import com.dir.api.exceptions.DirectoryException;
import com.dir.service.MapStorage;
import com.dir.service.SimpleDirectory;

public class ObjectFactory {

	public static Object get(String key) throws DirectoryException {
		Properties config = new Properties();
		try {
			config.load(new FileReader("config.properties"));
			String profile = config.getProperty("profile");

			if (profile.equals("dev")) {
				if (key.equals("directory")) {
					return new SimpleDirectory.Builder().withSecurity().withBroker().withStorage(new MapStorage());
				}
			}

			throw new DirectoryException();

		} catch (Exception e) {
			throw new DirectoryException();
		}
	}

}
