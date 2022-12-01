package com.glarimy.calc.api;

import java.io.FileReader;
import java.util.Properties;

public class Factory {
	@SuppressWarnings("unchecked")
	public static Calculator get(String key) throws CalculatorException {
		try {
			Properties config = new Properties();
			config.load(new FileReader("config.properties"));
			Calculator target = (Calculator) Class.forName(config.getProperty(key)).newInstance();
			int order = 1;
			while(config.getProperty(key+"."+order) != null) {
				@SuppressWarnings("rawtypes")
				Class claz = Class.forName(config.getProperty(key+"."+order));
				target = (Calculator) claz.getConstructor(Calculator.class).newInstance(target);
				order++;
			}
			return target;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CalculatorException();
		}
	}
}
