package com.glarimy.cs.service;

import com.glarimy.commons.api.Factory;
import com.glarimy.cs.api.Customer;
import com.glarimy.cs.api.CustomerNotFound;
import com.glarimy.cs.api.CustomerService;
import com.glarimy.cs.api.DuplicateCustomer;
import com.glarimy.cs.api.InvalidRequest;
import com.glarimy.messenger.api.Event;
import com.glarimy.messenger.api.Messenger;

public class Notifier implements CustomerService {
	private CustomerService target;
	private Messenger messenger;

	public Notifier(CustomerService target) throws Exception {
		this.target = target;
		this.messenger = new Factory<Messenger>("config.properties").get("messenger");
	}

	@Override
	public Customer add(Customer customer) throws InvalidRequest, DuplicateCustomer, Error {
		Customer result = target.add(customer);
		messenger.notify(new Event<String>("customer.added", customer.mail));
		return result;
	}

	@Override
	public Customer find(String cid) throws CustomerNotFound, Error {
		return target.find(cid);
	}

}
