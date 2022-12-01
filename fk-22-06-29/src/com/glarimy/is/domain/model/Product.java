package com.glarimy.is.domain.model;

import com.glarimy.is.domain.service.InsufficientQuantityException;
import com.glarimy.is.domain.service.InvalidProductException;

public class Product {
	private int id;
	private Quantity available;
	private Quantity reserved;

	public Product(int id, Quantity available) {
		if (id < 0 || available == null)
			throw new InvalidProductException();
		this.id = id;
		this.available = available;
		this.reserved = new Quantity("items", 0);
	}

	public Product(int id, Quantity available, Quantity reserved) {
		if (id < 0 || available == null || reserved == null)
			throw new InvalidProductException();

		this.id = id;
		this.available = available;
		this.reserved = reserved;
	}

	public Quantity getAvailable() {
		return available;
	}

	public Quantity getReserved() {
		return reserved;
	}

	public int getId() {
		return id;
	}

	public void reserve(Quantity quantity) {
		if (quantity.getNumber() > available.getNumber())
			throw new InsufficientQuantityException();
		available = new Quantity(quantity.getUnits(), this.available.getNumber() - quantity.getNumber());
		reserved = new Quantity(quantity.getUnits(), this.reserved.getNumber() + quantity.getNumber());
	}

	public void release(Quantity quantity) {
		if (quantity.getNumber() > reserved.getNumber())
			throw new InsufficientQuantityException();
		available = new Quantity(quantity.getUnits(), this.available.getNumber() + quantity.getNumber());
		reserved = new Quantity(quantity.getUnits(), this.reserved.getNumber() - quantity.getNumber());
	}

	public void consume(Quantity quantity) {
		if (quantity.getNumber() > reserved.getNumber())
			throw new InsufficientQuantityException();
		reserved = new Quantity(quantity.getUnits(), this.reserved.getNumber() - quantity.getNumber());
	}

	public void replenish(Quantity quantity) {
		available = new Quantity(quantity.getUnits(), this.available.getNumber() + quantity.getNumber());
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", available=" + available + ", reserved=" + reserved + "]";
	}

}
