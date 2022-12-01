package com.glarimy.is.app;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.is.domain.model.Product;
import com.glarimy.is.domain.model.Quantity;
import com.glarimy.is.domain.service.InventoryService;

public class InventoryController {
	private InventoryService is;

	public InventoryController() {
		Factory factory = new ObjectFactory();
		Map<String, String> config = new HashMap<String, String>();
		config.put("comp", "is");
		config.put("logging", "disabled");
		config.put("validation", "enabled");
		is = (InventoryService) factory.get(config);
	}

	public Item add(Item p) {
		Product product = new Product(p.id, new Quantity(p.units, p.available));
		Product result = is.add(product);
		Item value = new Item();
		value.id = result.getId();
		value.available = result.getAvailable().getNumber();
		value.units = result.getAvailable().getUnits();
		return value;
	}

	public Item find(int id) {
		Product result = is.fetch(id);
		Item value = new Item();
		value.id = result.getId();
		value.available = result.getAvailable().getNumber();
		value.reserved = result.getReserved().getNumber();
		value.units = result.getAvailable().getUnits();
		return value;
	}

	public Item reserve(int id, int quantity, String units) {
		Product result = is.reserve(id, new Quantity(units, quantity));
		Item value = new Item();
		value.id = result.getId();
		value.available = result.getAvailable().getNumber();
		value.reserved = result.getReserved().getNumber();
		value.units = result.getAvailable().getUnits();
		return value;
	}

	public Item consume(int id, int quantity, String units) {
		Product result = is.consume(id, new Quantity(units, quantity));
		Item value = new Item();
		value.id = result.getId();
		value.available = result.getAvailable().getNumber();
		value.reserved = result.getReserved().getNumber();
		value.units = result.getAvailable().getUnits();
		return value;
	}

}
