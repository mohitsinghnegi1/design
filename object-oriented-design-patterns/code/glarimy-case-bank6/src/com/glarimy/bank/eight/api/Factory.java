package com.glarimy.bank.eight.api;

import java.io.FileReader;
import java.util.Properties;

public class Factory<T> {
	Properties config;

	public Factory() throws Exception {
		config = new Properties();
		config.load(new FileReader("eight.properties"));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T get(String key) throws Exception {
		Object o;
		String className = config.getProperty(key);
		Class claz = Class.forName(className);
		if (claz.getAnnotation(Singleton.class) == null)
			o = claz.newInstance();
		else
			o = claz.getMethod("getInstance").invoke(claz);
		int position = 1;
		String proxyClassName = config.getProperty(key + "." + position++);
		while (proxyClassName != null) {
			Class proxy = Class.forName(proxyClassName);
			o = proxy.getConstructor(claz.getInterfaces()[0]).newInstance(o);
			proxyClassName = config.getProperty(key + "." + position++);
		}
		return (T) o;
	}
}
