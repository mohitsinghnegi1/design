package com.glarimy.cs.service;

import com.glarimy.commons.api.Factory;
import com.glarimy.commons.api.Singleton;
import com.glarimy.cs.api.Customer;
import com.glarimy.cs.api.CustomerNotFound;
import com.glarimy.cs.api.CustomerService;
import com.glarimy.cs.api.DuplicateCustomer;
import com.glarimy.cs.api.InvalidRequest;
import com.glarimy.cs.api.Storage;

@Singleton
public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl INSTANCE = null;
	private Storage storage;

	private CustomerServiceImpl() throws Exception {
		storage = new Factory<Storage>("config.properties").get("storage");
	}

	public synchronized static CustomerServiceImpl getInstance() throws Exception {
		if (INSTANCE == null)
			INSTANCE = new CustomerServiceImpl();
		return INSTANCE;
	}

	@Override
	public Customer add(Customer customer) throws InvalidRequest, DuplicateCustomer, Error {
		if (storage.read(customer.mail) == null)
			return storage.create(customer);
		throw new DuplicateCustomer();
	}

	@Override
	public Customer find(String cid) throws CustomerNotFound, Error {
		return storage.read(cid);
	}

}
