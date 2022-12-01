package com.framework;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
	private static Map<String, String> config = new HashMap<String, String>();
	static {
		config.put("storage", "com.dir.service.data.InMemoryStorage");
		config.put("broker", "com.broker.service.LocalBroker");
		config.put("handler", "com.client.AddHandler");

		config.put("directory", "com.dir.service.SimpleDirectory");
		config.put("directory.1.param", "com.dir.service.data.Storage");
		config.put("directory.1.proxy", "com.dir.service.Notifier");
		config.put("directory.2.proxy", "com.dir.service.Validator");
		config.put("directory.3.proxy", "com.dir.service.Logger");
	}

	@SuppressWarnings("rawtypes")
	public static Object get(String key) {
		String className = config.get(key);
		Class claz;
		Object o;
		if(className == null)
			throw new RuntimeException("Key not found!");
		try {
			claz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Class not found!");
		}
		try {
			o = claz.newInstance();
		}catch(Exception e) {
			
		}
		return null;
	}
}
