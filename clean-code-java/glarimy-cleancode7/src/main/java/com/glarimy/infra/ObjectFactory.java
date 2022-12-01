package com.glarimy.infra;

import java.io.FileReader;
import java.util.Properties;

import com.glarimy.app.DirectoryController;
import com.glarimy.domain.Directory;
import com.glarimy.domain.Logger;
import com.glarimy.domain.MetricsCollector;
import com.glarimy.domain.SimpleDirectory;
import com.glarimy.domain.Storage;

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
		if (key.equals("controller")) {
			Storage repo = (Storage) get("storage");
			Directory dir = new SimpleDirectory(repo);
			if (logging)
				dir = new Logger(dir);
			if (metrics)
				dir = new MetricsCollector(dir);
			return new DirectoryController(dir);
		}
		if (key.equals("storage")) {
			return new InMemoryStorage();
		}
		throw new Exception("Not supported");
	}

}
