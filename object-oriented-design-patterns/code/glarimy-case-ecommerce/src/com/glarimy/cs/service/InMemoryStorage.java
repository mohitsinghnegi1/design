package com.glarimy.cs.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.commons.api.Singleton;
import com.glarimy.cs.api.Customer;
import com.glarimy.cs.api.Storage;

@Singleton
public class InMemoryStorage implements Storage {
	private static InMemoryStorage INSTANCE = null;
	private Map<String, Customer> entries;

	private InMemoryStorage() throws Exception {
		this.entries = new HashMap<>();
	}

	public synchronized static InMemoryStorage getInstance() throws Exception {
		if (INSTANCE == null)
			INSTANCE = new InMemoryStorage();
		return INSTANCE;
	}

	@Override
	public Customer create(Customer customer) {
		entries.put(customer.mail, customer);
		return customer;
	}

	@Override
	public Customer read(String cid) {
		return entries.get(cid);
	}
}
