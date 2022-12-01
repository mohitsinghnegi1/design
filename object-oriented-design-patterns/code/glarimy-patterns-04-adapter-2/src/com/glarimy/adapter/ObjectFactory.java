package com.glarimy.adapter;

import java.io.FileReader;
import java.util.Properties;

public class ObjectFactory {
	private Properties props;

	public ObjectFactory(String config) throws Exception {
		props = new Properties();
		props.load(new FileReader(config));
	}

	@SuppressWarnings("rawtypes")
	public Object get(String key) throws Exception {
		Class claz = Class.forName(props.getProperty(key));
		return claz.newInstance();
	}
}
