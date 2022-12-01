package com.glarimy.framework;

import java.io.FileReader;
import java.util.Properties;

public class SimpleFactory implements Factory {
	private Properties config;

	public SimpleFactory() {
		config = new Properties();
		try {
			config.load(new FileReader("config.properties"));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/*
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @Override public Object get(String key) { try { String className =
	 * config.getProperty(key); Class claz = Class.forName(className); Object o =
	 * null; try { o = claz.newInstance(); } catch (InstantiationException |
	 * IllegalAccessException e) { Constructor cons = claz.getConstructors()[0];
	 * Class param = cons.getParameterTypes()[0]; o =
	 * cons.newInstance(get(param.getSimpleName().toLowerCase())); } return o; }
	 * catch (Exception e) { e.printStackTrace(); throw new RuntimeException(); } }
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object get(String key) {
		try {
			String className = config.getProperty(key);
			Class claz = Class.forName(className);
			Object o = null;
			try {
				o = claz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				ConstructWith annotation = (ConstructWith) claz.getAnnotation(ConstructWith.class);
				o = claz.getConstructors()[0].newInstance(get(annotation.param()));
			}
			int order = 1;
			while (config.getProperty(key + ".proxy." + order) != null) {
				String proxyClassName = config.getProperty(key + ".proxy." + order);
				Class proxyClass = Class.forName(proxyClassName);
				o = proxyClass.getConstructor(claz.getInterfaces()[0]).newInstance(o);
				order++;
			}
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
