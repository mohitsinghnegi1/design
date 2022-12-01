package com.glarimy.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.glarimy.infra.IllegalValueException;

@Embeddable
public class Email {
	@Column(name = "email")
	private String value;
	
	Email() {
		
	}

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

	@Override
	public String toString() {
		return "Email [value=" + value + "]";
	}
	
	

}
