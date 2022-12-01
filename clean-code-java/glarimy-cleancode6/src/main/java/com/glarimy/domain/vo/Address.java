package com.glarimy.domain.vo;

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

	@Override
	public boolean equals(Object obj) {
		Address other = (Address) obj;
		return location.equals(other.location) && city.equals(other.city) && pincode == other.pincode;
	}

}
