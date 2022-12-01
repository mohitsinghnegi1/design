package com.glarimy.is.app;

import java.util.Map;

import com.glarimy.is.domain.data.ProductStore;
import com.glarimy.is.domain.service.InventoryException;
import com.glarimy.is.domain.service.InventoryService;
import com.glarimy.is.domain.service.Logger;
import com.glarimy.is.domain.service.SimpleInventoryService;
import com.glarimy.is.domain.service.Validator;
import com.glarimy.is.infra.InMemoryProductStore;

public class ObjectFactory implements Factory {
	@Override
	public Object get(Map<String, String> config) {
		if (config.get("comp") == "is") {
			ProductStore store = InMemoryProductStore.getInstance();
			InventoryService is = new SimpleInventoryService(store);
			if(config.get("logging") == "enabled") {
				is = new Logger(is);
				if(config.get("validation") == "enabled") {
					is = new Validator(is);
				}
			}
			return is;
		}
		throw new InventoryException();
	}
}
