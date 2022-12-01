package com.glarimy.core.ums.domain;

public class Phone {
	private long number;

	public Phone(long number) {
		if (number < 6000000000L || number > 9999999999L)
			throw new RuntimeException();
		this.number = number;
	}

	public long getNumber() {
		return number;
	}

	public boolean equals(Phone other) {
		if (this.number == other.number)
			return true;
		return false;
	}
}
