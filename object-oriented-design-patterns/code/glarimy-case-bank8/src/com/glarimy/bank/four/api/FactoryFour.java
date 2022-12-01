package com.glarimy.bank.four.api;

import java.io.FileReader;
import java.util.Properties;

public class FactoryFour {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object get(String key) {
		try {
			Properties config = new Properties();
			config.load(new FileReader("four.properties"));
			String className = config.getProperty(key);
			Class claz = Class.forName(className);
			if (claz.getAnnotation(Singleton.class) == null)
				return claz.newInstance();
			else
				return claz.getMethod("getInstance").invoke(claz);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
