package com.glarimy;

public class Email {

	private String value;

	public Email(String value) throws IllegalValueException {
		if (value == null || !value.contains("@"))
			throw new IllegalValueException();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		Email other = (Email) obj;
		return this.value.equals(other.value);
	}

}
