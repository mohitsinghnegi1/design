package com.glarimy.bank.domain;

public class Customer {
	private String owner;
	private long phone;

	public Customer() {

	}

	public Customer(String owner, long phone) {
		super();
		this.owner = owner;
		this.phone = phone;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [owner=" + owner + ", phone=" + phone + "]";
	}

}
