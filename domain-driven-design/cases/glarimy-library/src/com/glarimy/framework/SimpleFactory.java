package com.glarimy.framework;

import com.glarimy.api.Library;
import com.glarimy.service.InMemoryStorage;
import com.glarimy.service.Logger;
import com.glarimy.service.SimpleLibrary;
import com.glarimy.service.Storage;
import com.glarimy.service.Validator;

public class SimpleFactory implements Factory {
	private boolean debug;
	private boolean validation;

	public SimpleFactory(boolean debug, boolean validation) {
		this.debug = debug;
		this.validation = validation;
	}

	public Object get(String key) throws Exception {
		if (key.equalsIgnoreCase("library")) {
			Library target = new SimpleLibrary((Storage) this.get("storage"));
			if (debug) {
				Logger logger = new Logger(target);
				if (validation) {
					Validator validator = new Validator(logger);
					return validator;
				} else {
					return logger;
				}
			} else {
				if (validation) {
					Validator validator = new Validator(target);
					return validator;
				} else {
					return target;
				}
			}
		}
		if (key.equalsIgnoreCase("storage"))
			return new InMemoryStorage();
		throw new Exception();
	}
}
