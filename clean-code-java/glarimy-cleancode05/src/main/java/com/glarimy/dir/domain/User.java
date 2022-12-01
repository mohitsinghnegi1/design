package com.glarimy.dir.domain;

public class User {
	private long phone;
	private String name;
	private String email;
	private Address address;

	private User() {

	}

	public long getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

	public static class UserBuilder {
		String name;
		long phone;
		String city;
		String email;
		String pincode;
		Address address;

		public UserBuilder(String name, long phone, String city) {
			this.name = name;
			this.phone = phone;
			this.address = new Address();
			this.address.setCity(city);
		}

		public UserBuilder addEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder addLocation(String location) {
			this.address.setLocation(location);
			return this;
		}

		public UserBuilder addPincode(int pincode) {
			this.address.setPincode(pincode);
			return this;
		}

		public User build() {
			User user = new User();
			user.name = this.name;
			user.phone = this.phone;
			user.address = this.address;
			if (this.email != null)
				user.email = this.email;

			return user;
		}

	}
}
