package com.glarimy.generic.framework;

import java.io.FileReader;
import java.util.Properties;

public class ObjectFactory {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object get(String key) throws Exception {
		Properties config = new Properties();
		config.load(new FileReader("config.properties"));
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
		return o;
	}
}
