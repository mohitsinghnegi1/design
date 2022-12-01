package com.glarimy.cs.api;

public interface Storage {
	public Customer create(Customer customer);

	public Customer read(String cid);
}
