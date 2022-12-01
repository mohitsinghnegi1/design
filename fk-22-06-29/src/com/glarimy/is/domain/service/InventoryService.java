package com.glarimy.is.domain.service;

import com.glarimy.is.domain.model.Product;
import com.glarimy.is.domain.model.Quantity;

public interface InventoryService {
	Product add(Product p);
	Product remove(int id);
	Product replenish(int id, Quantity quantity);
	Product reserve(int id, Quantity quantity);
	Product consume(int id, Quantity quantity);
	Product fetch(int id);
}
