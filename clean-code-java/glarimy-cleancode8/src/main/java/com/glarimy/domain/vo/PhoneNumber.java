package com.glarimy.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.glarimy.infra.IllegalValueException;

@SuppressWarnings("serial")
@Embeddable
public class PhoneNumber implements Serializable {
	@Column(name = "phone_number")
	private long value;

	public PhoneNumber() {

	}

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

	@Override
	public String toString() {
		return "PhoneNumber [value=" + value + "]";
	}

}
