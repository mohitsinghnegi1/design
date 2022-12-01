package com.glarimy.is.domain;

public class SimpleInventoryService implements InventoryService {
	private ProductStore store;

	public SimpleInventoryService(ProductStore store) {
		this.store = store;
	}

	@Override
	public Product add(Product p) {
		return store.create(p);
	}

	@Override
	public Product remove(int id) {
		return store.delete(id);
	}

	@Override
	public Product replenish(int id, Quantity quantity) {
		Product p = store.read(id);
		p.replenish(quantity);
		return store.update(p);
	}

	@Override
	public Product reserve(int id, Quantity quantity) {
		Product p = store.read(id);
		p.reserve(quantity);
		return store.update(p);

	}

	@Override
	public Product consume(int id, Quantity quantity) {
		Product p = store.read(id);
		p.consume(quantity);
		return store.update(p);

	}

	@Override
	public Product fetch(int id) {
		return store.read(id);
	}

}
