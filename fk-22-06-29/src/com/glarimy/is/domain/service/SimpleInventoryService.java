package com.glarimy.is.domain.service;

import com.glarimy.is.domain.data.ProductStore;
import com.glarimy.is.domain.model.Product;
import com.glarimy.is.domain.model.Quantity;

public class SimpleInventoryService implements InventoryService {
	private ProductStore store;

	public SimpleInventoryService(ProductStore store) {
		this.store = store;
	}

	@Override
	public Product add(Product p) {
		if(store.read(p.getId()) != null)
			throw new DuplicateProductException();
		return store.create(p);
	}

	@Override
	public Product remove(int id) {
		Product p = store.read(id);
		if(p.getReserved().getNumber() > 0)
			throw new InsufficientQuantityException();
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
