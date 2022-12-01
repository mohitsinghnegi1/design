package com.client;

import com.broker.api.Broker;
import com.broker.api.Factory;
import com.broker.service.LocalBroker;
import com.dir.api.Directory;
import com.dir.service.Logger;
import com.dir.service.Notifier;
import com.dir.service.SimpleDirectory;
import com.dir.service.Validator;
import com.dir.service.data.InMemoryStorage;
import com.dir.service.data.Storage;

public class ObjectFactory implements Factory{

	public Object get(String key) {
		if (key.equalsIgnoreCase("storage")) {
			return InMemoryStorage.get();
		}
		if (key.equalsIgnoreCase("broker")) {
			return LocalBroker.get();
		}
		if (key.equalsIgnoreCase("directory")) {
			Broker broker = (Broker) this.get("broker");
			Storage storage = (Storage) this.get("storage");
			Directory target = new SimpleDirectory(storage);
			Directory notifier = new Notifier(target, broker);
			Directory validator = new Validator(notifier);
			Directory logger = new Logger(validator);
			return logger;
		}
		if (key.equalsIgnoreCase("receiver")) {
			return new MessageReceiver();
		}
		throw new RuntimeException("Failed to get object");
	}

}
