package com.glarimy.cs.api;

public interface CustomerService {
	public Customer add(Customer customer) throws InvalidRequest, DuplicateCustomer, Error;

	public Customer find(String cid) throws CustomerNotFound, Error;
}