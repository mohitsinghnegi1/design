package com.glarimy.core.css.domain;

public class Id {
	private int value;

	public Id(int value) {
		if (value < 1)
			throw new RuntimeException();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public boolean equals(Id id) {
		if (this.value == id.getValue())
			return true;
		return false;
	}
}
