package com.glarimy.bank.accounts.api;

public class Address {
	private String location;
	private String city;
	private int pincode;

	public Address(String location, String city, int pincode) {
		this.location = location;
		this.city = city;
		this.pincode = pincode;
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public int getPincode() {
		return pincode;
	}

}
