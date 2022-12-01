package com.glarimy.is.app;

import com.glarimy.is.domain.InMemoryProductStore;
import com.glarimy.is.domain.InventoryService;
import com.glarimy.is.domain.Product;
import com.glarimy.is.domain.ProductStore;
import com.glarimy.is.domain.Quantity;
import com.glarimy.is.domain.SimpleInventoryService;

public class InventoryApplication {

	public static void main(String[] args) {
		ProductStore store = new InMemoryProductStore();
		InventoryService is = new SimpleInventoryService(store);
		Product p = new Product(1, new Quantity("items", 100));
		is.add(p);
		System.out.println(is.fetch(1));
		is.replenish(1, new Quantity("items", 25));
		is.reserve(1, new Quantity("items", 5));
		is.consume(1, new Quantity("items", 5));
		System.out.println(is.fetch(1));
	}

}
