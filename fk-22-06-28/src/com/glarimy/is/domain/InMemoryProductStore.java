package com.glarimy.is.domain;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductStore implements ProductStore {
	private Map<Integer, Product> products;

	public InMemoryProductStore() {
		products = new HashMap<Integer, Product>();
	}

	@Override
	public Product create(Product p) {
		products.put(p.getId(), p);
		return p;
	}

	@Override
	public Product read(int id) {
		return products.get(id);
	}

	@Override
	public Product update(Product p) {
		products.put(p.getId(), p);
		return p;
	}

	@Override
	public Product delete(int id) {
		return products.remove(id);
	}

}
