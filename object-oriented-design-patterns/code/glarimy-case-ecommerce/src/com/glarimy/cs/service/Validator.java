package com.glarimy.cs.service;

import com.glarimy.cs.api.Customer;
import com.glarimy.cs.api.CustomerNotFound;
import com.glarimy.cs.api.CustomerService;
import com.glarimy.cs.api.DuplicateCustomer;
import com.glarimy.cs.api.InvalidRequest;

public class Validator implements CustomerService {
	private CustomerService target;

	public Validator(CustomerService target) {
		this.target = target;
	}

	@Override
	public Customer add(Customer customer) throws InvalidRequest, DuplicateCustomer, Error {
		if (customer == null)
			throw new InvalidRequest();
		return target.add(customer);
	}

	@Override
	public Customer find(String cid) throws CustomerNotFound, Error {
		return target.find(cid);
	}

}
