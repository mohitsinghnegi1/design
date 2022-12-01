package com.glarimy.app;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.Address;
import com.glarimy.domain.vo.Email;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;
import com.glarimy.infra.IllegalValueException;

public class UserData {
	public String name;
	public long phoneNumber;
	public String email;
	public String location;
	public String city;
	public int pincode;

	public UserData() {

	}

	public UserData(User user) {
		name = user.getName().getValue();
		phoneNumber = user.getPhoneNumber().getValue();
		email = user.getEmail().getValue();
		location = user.getAddress().getLocation();
		city = user.getAddress().getCity();
		pincode = user.getAddress().getPincode();
	}

	public User toUser() throws IllegalValueException {
		User user = new User(new PhoneNumber(phoneNumber), new Name(name), new Email(email));
		user.setAddress(new Address(location, city, pincode));
		return user;

	}
}
