package com.glarimy.core.ums.domain;

public class User {
	private Phone phone;
	private Name name;
	private Address address;
	private boolean active;

	public User(Phone phone, Name name, Address address, boolean active) {
		this.phone = phone;
		this.name = name;
		this.address = address;
		this.active = active;
	}

	public Phone getPhone() {
		return phone;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void activate() {
		this.active = true;
	}

	public void deactivate() {
		this.active = false;
	}

	public boolean isActive() {
		return active;
	}

}
