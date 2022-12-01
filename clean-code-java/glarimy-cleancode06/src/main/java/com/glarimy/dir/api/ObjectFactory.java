package com.glarimy.dir.api;

import java.util.Map;

import com.glarimy.dir.service.Auditor;
import com.glarimy.dir.service.InMemoryStorage;
import com.glarimy.dir.service.SimpleDirectory;
import com.glarimy.dir.service.Storage;

public class ObjectFactory implements Factory {
	private Map<String, String> config;

	public ObjectFactory(Map<String, String> config) {
		this.config = config;
	}

	@Override
	public Object get(String key) throws Exception {
		if (key.equalsIgnoreCase("dir")) {
			Storage storage = (Storage) get("storage");
			Directory dir = new SimpleDirectory(storage);
			if (config.get("audit").equals("enabled")) {
				dir = new Auditor(dir);
			}
			return dir;
		}
		if (key.equalsIgnoreCase("storage")) {
			return new InMemoryStorage();
		}
		throw new Exception();
	}

}
