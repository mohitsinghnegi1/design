package com.glarimy;

public class PhoneNumber {
	private long value;

	public PhoneNumber(long value) throws IllegalValueException {
		if (value < 0 && Long.toString(value).length() != 10)
			throw new IllegalValueException();
		this.value = value;
	}

	public long getValue() {
		return value;
	}
	@Override
	public boolean equals(Object obj) {
		PhoneNumber other = (PhoneNumber) obj;
		return this.value == other.value;
	}

}
