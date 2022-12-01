package com.glarimy.core.ums.domain;

public class Address {
	private String location;
	private String city;
	private int pincode;

	public Address(String location, String city, int pincode) {
		super();
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

	public String getAddress() {
		return location + ", " + city + " - " + pincode;
	}

	public boolean equals(Address other) {
		if (this.getAddress().equalsIgnoreCase(other.getAddress()))
			return true;
		return false;
	}

}
