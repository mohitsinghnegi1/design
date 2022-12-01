package com.glarimy.framework.factory;

import java.io.FileReader;
import java.util.Properties;

public class SimpleFactory<T> implements Factory<T> {
	private Properties props;

	public SimpleFactory() throws Exception {
		props = new Properties();
		props.load(new FileReader("config.properties"));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T get(String key) throws Exception {
		Class claz = Class.forName(props.getProperty(key));
		Object o;

		try {
			o = claz.newInstance();
		} catch (IllegalAccessException | InstantiationException e) {
			o = claz.getMethod("getInstance").invoke(claz);
		}

		String validator = props.getProperty(key + ".validator");
		if (validator != null) {
			Class validatorClaz = Class.forName(validator);
			o = validatorClaz.getConstructor(claz.getInterfaces()[0]).newInstance(o);
		}

		String logger = props.getProperty(key + ".logger");
		if (logger != null) {
			Class loggerClaz = Class.forName(logger);
			o = loggerClaz.getConstructor(claz.getInterfaces()[0]).newInstance(o);
		}

		return (T) o;
	}
}
