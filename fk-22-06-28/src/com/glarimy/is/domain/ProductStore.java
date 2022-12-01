package com.glarimy.is.domain;

public interface ProductStore {
	public Product create(Product p);
	public Product read(int id);
	public Product update(Product p);
	public Product delete(int id);
}
