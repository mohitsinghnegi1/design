package com.glarimy.is.infra;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.is.domain.data.ProductStore;
import com.glarimy.is.domain.model.Product;

public class InMemoryProductStore implements ProductStore {
	private Map<Integer, Product> products;
	private static InMemoryProductStore instance = null;

	private InMemoryProductStore() {
		products = new HashMap<Integer, Product>();
	}

	public synchronized static InMemoryProductStore getInstance() {
		if (instance == null)
			instance = new InMemoryProductStore();
		return instance;
	}

	@Override
	public Product create(Product p) {
		products.put(p.getId(), p);
		return products.get(p.getId());
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
