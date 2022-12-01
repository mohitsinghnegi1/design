package com.glarimy.core.ums.domain;

public class Name {
	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		if (firstName == null || firstName.trim().length() < 4)
			throw new RuntimeException();

		if (lastName == null || lastName.trim().length() < 1)
			throw new RuntimeException();

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean equals(Name other) {
		if (firstName.equalsIgnoreCase(other.getFirstName()) && lastName.equals(other.getLastName()))
			return true;
		return false;
	}

}
