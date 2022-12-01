package com.glarimy.domain.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.glarimy.domain.vo.Address;
import com.glarimy.domain.vo.Email;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

@Entity
public class User {
	@EmbeddedId
	private PhoneNumber phoneNumber;
	private Name name;
	private Email email;
	private Address address;

	User() {

	}

	public User(PhoneNumber phoneNumber, Name name, Email email) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", name=" + name + ", email=" + email + ", address=" + address
				+ "]";
	}

}
