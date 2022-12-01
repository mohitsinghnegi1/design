package com.glarimy.bank.accounts.api;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	private Name name;
	private List<Phone> phones;
	private Address address;

	public Customer() {
		phones = new ArrayList<Phone>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (this.id == 0)
			this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
