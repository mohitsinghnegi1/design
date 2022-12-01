package com.glarimy.ecommerce.client;

import com.glarimy.commons.api.Factory;
import com.glarimy.cs.api.Customer;
import com.glarimy.cs.api.CustomerService;

public class EcommerceApplication {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("rawtypes")
			Factory factory = new Factory("config.properties");

			factory.get("os");
			CustomerService cs = (CustomerService) factory.get("cs");
			cs.add(new Customer("krishna@glarimy.com", "Krishna", 9731423166L));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}