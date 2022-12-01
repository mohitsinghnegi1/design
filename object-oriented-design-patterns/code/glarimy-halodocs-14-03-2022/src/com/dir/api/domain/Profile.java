package com.dir.api.domain;

public class Profile {
	private String id;
	private String name;
	private long phoneNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
