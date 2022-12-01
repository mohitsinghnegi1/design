package com.glarimy;

import java.io.FileReader;
import java.util.Properties;

public class ObjectFactory implements Factory {
	private boolean logging;
	private boolean metrics;

	public ObjectFactory() throws Exception {
		Properties config = new Properties();
		config.load(new FileReader("config.properties"));
		this.logging = Boolean.parseBoolean(config.getProperty("logging.enabled"));
		this.metrics = Boolean.parseBoolean(config.getProperty("metrics.enabled"));
	}

	@Override
	public Object get(String key) throws Exception {
		if (key.equals("directory")) {
			Directory dir = new SimpleDirectory();
			if (logging)
				dir = new Logger(dir);
			if (metrics)
				dir = new MetricsCollector(dir);
			return dir;
		}
		throw new Exception("Not supported");
	}

}
