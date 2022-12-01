package com.glarimy.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.glarimy.infra.IllegalValueException;

@Embeddable
public class Name {
	@Column(name = "name")
	private String value;

	Name() {

	}

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

	@Override
	public String toString() {
		return "Name [value=" + value + "]";
	}

}
