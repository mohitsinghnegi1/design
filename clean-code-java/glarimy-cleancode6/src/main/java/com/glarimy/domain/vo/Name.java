package com.glarimy.domain.vo;

import com.glarimy.infra.IllegalValueException;

public class Name {
	private String value;

	public Name(String value) throws IllegalValueException {
		if (value == null || value.trim().length() < 6)
			throw new IllegalValueException();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		Name other = (Name) obj;
		return this.value.equals(other.value);
	}

}
