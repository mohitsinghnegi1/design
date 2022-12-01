package com.framework;

import java.io.FileReader;
import java.util.Properties;

public class ObjectFactory {

	public static Object get(String key) throws Exception {
		Properties config = new Properties();
		config.load(new FileReader("config.properties"));
		return Class.forName(config.getProperty(key)).newInstance();
	}

}
