package com.glarimy;

public class User {
	private PhoneNumber phoneNumber;
	private Name name;
	private Email email;
	private Address address;

	public User(PhoneNumber phoneNumber, Name name, Email email) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

}
