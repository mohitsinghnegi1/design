package com.glarimy.is.domain.service;

import com.glarimy.is.domain.model.Product;
import com.glarimy.is.domain.model.Quantity;

public class Validator implements InventoryService {
	private InventoryService target;

	public Validator(InventoryService target) {
		super();
		this.target = target;
	}

	@Override
	public Product add(Product p) {
		if (p == null || p.getAvailable().getUnits() == null)
			throw new InvalidProductException();
		return target.add(p);
	}

	@Override
	public Product remove(int id) {
		return target.remove(id);
	}

	@Override
	public Product replenish(int id, Quantity quantity) {
		return target.replenish(id, quantity);
	}

	@Override
	public Product reserve(int id, Quantity quantity) {
		return target.reserve(id, quantity);
	}

	@Override
	public Product consume(int id, Quantity quantity) {
		return target.consume(id, quantity);
	}

	@Override
	public Product fetch(int id) {
		return target.fetch(id);
	}

}
