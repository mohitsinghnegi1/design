package com.glarimy.is.domain;

public class Product {
	private int id;
	private Quantity available;
	private Quantity reserved;

	public Product(int id, Quantity available) {
		super();
		this.id = id;
		this.available = available;
		this.reserved = new Quantity("items", 0);
	}

	public Product(int id, Quantity available, Quantity reserved) {
		super();
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
		available = new Quantity(quantity.getUnits(), this.available.getNumber() - quantity.getNumber());
		reserved = new Quantity(quantity.getUnits(), this.reserved.getNumber() + quantity.getNumber());
	}

	public void release(Quantity quantity) {
		available = new Quantity(quantity.getUnits(), this.available.getNumber() + quantity.getNumber());
		reserved = new Quantity(quantity.getUnits(), this.reserved.getNumber() - quantity.getNumber());
	}

	public void consume(Quantity quantity) {
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
