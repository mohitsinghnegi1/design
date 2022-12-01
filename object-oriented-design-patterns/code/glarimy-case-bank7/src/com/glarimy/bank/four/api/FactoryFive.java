package com.glarimy.bank.four.api;

import java.io.FileReader;
import java.util.Properties;

public class FactoryFive<T> {
	private Properties config;

	public FactoryFive() throws Exception {
		config = new Properties();
		config.load(new FileReader("four.properties"));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T get(String key) throws Exception {
		String className = config.getProperty(key);
		Class claz = Class.forName(className);
		if (claz.getAnnotation(Singleton.class) == null)
			return (T) claz.newInstance();
		else
			return (T) claz.getMethod("getInstance").invoke(claz);

	}
}
