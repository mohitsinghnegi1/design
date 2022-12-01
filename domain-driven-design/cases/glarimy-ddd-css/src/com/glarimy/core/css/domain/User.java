package com.glarimy.core.css.domain;

public class User {
	private long number;

	public User(long number) {
		if (number < 6000000000L || number > 9999999999L)
			throw new RuntimeException();
		this.number = number;
	}

	public long getNumber() {
		return number;
	}

	public boolean equals(User other) {
		if (this.number == other.number)
			return true;
		return false;
	}
}
