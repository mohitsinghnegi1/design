package com.glarimy.is.domain.data;

import com.glarimy.is.domain.model.Product;

public interface ProductStore {
	public Product create(Product p);
	public Product read(int id);
	public Product update(Product p);
	public Product delete(int id);
}
