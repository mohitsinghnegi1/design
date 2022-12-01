package com.glarimy.cs.service;

import java.util.Date;

import com.glarimy.cs.api.Customer;
import com.glarimy.cs.api.CustomerNotFound;
import com.glarimy.cs.api.CustomerService;
import com.glarimy.cs.api.DuplicateCustomer;
import com.glarimy.cs.api.InvalidRequest;

public class Logger implements CustomerService {
	private CustomerService target;

	public Logger(CustomerService target) throws Exception {
		this.target = target;
	}

	@Override
	public Customer add(Customer customer) throws InvalidRequest, DuplicateCustomer, Error {
		System.out.println(new Date() + ": add - started ");
		try {
			Customer result = target.add(customer);
			System.out.println(new Date() + ": add - finished ");
			return result;
		} catch (Exception e) {
			System.out.println(new Date() + ": add - failed ");
			throw e;
		}
	}

	@Override
	public Customer find(String cid) throws CustomerNotFound, Error {
		System.out.println(new Date() + ": find - started ");
		try {
			Customer result = target.find(cid);
			System.out.println(new Date() + ": find - finished ");
			return result;
		} catch (Exception e) {
			System.out.println(new Date() + ": find - failed ");
			throw e;
		}
	}

}
