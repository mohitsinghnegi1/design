package com.glarimy.is.domain;

public interface InventoryService {
	Product add(Product p);
	Product remove(int id);
	Product replenish(int id, Quantity quantity);
	Product reserve(int id, Quantity quantity);
	Product consume(int id, Quantity quantity);
	Product fetch(int id);
}
