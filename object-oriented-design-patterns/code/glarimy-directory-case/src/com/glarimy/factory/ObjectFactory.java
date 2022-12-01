package com.glarimy.factory;

import java.io.FileReader;
import java.util.Properties;

public class ObjectFactory {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object get(String key) throws Exception {
		Properties config = new Properties();
		config.load(new FileReader("config.properties"));
		
		String className = config.getProperty(key);
		Class claz = Class.forName(className);
		Object o = null;
		
		try {
			o = claz.newInstance();
		} catch (Exception e) {
			Wire wire = (Wire) claz.getAnnotation(Wire.class);
			if (wire != null) {
				String prop = wire.target();
				Object dependency = get(prop);
				o = claz.getConstructor(dependency.getClass().getInterfaces()[0]).newInstance(dependency);
			}else {
				throw new Exception("Failed to create the object");
			}
		}

		int i = 1;
		String proxyClassName = config.getProperty(key + "." + i);
		while (proxyClassName != null) {
			i++;
			o = Class.forName(proxyClassName).getConstructor(o.getClass().getInterfaces()[0]).newInstance(o);
			proxyClassName = config.getProperty(key + "." + i);
		}

		return o;
	}

}
