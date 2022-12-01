package com.glarimy.dir.api;

import com.glarimy.dir.service.InMemoryStorage;
import com.glarimy.dir.service.SimpleDirectory;
import com.glarimy.dir.service.Storage;

public class ObjectFactory implements Factory {

	@Override
	public Object get(String key) throws Exception {
		if (key.equalsIgnoreCase("dir")) {
			Storage storage = (Storage) get("storage");
			return new SimpleDirectory(storage);
		}
		if (key.equalsIgnoreCase("storage")) {
			return new InMemoryStorage();
		}
		throw new Exception();
	}

}
