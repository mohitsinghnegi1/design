package com.glarimy.core.css.app;

import java.util.ArrayList;
import java.util.List;

import com.glarimy.core.ums.app.UserDTO;
import com.glarimy.core.ums.domain.Address;
import com.glarimy.core.ums.domain.Name;
import com.glarimy.core.ums.domain.Phone;
import com.glarimy.core.ums.domain.User;

public class UserMapper {
	public static User from(UserDTO dto) {
		Phone email = new Phone(dto.phone);
		Name name = new Name(dto.firstName, dto.lastName);
		Address address = new Address(dto.location, dto.city, dto.pincode);
		User user = new User(email, name, address, dto.active);
		return user;
	}

	public static UserDTO from(User user) {
		UserDTO dto = new UserDTO();
		dto.phone = user.getPhone().getNumber();
		dto.firstName = user.getName().getFirstName();
		dto.lastName = user.getName().getLastName();
		dto.location = user.getAddress().getLocation();
		dto.city = user.getAddress().getCity();
		dto.pincode = user.getAddress().getPincode();
		dto.active = user.isActive();
		return dto;
	}

	public static List<UserDTO> from(List<User> users) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = new UserDTO();
			dto.phone = user.getPhone().getNumber();
			dto.firstName = user.getName().getFirstName();
			dto.lastName = user.getName().getLastName();
			dto.location = user.getAddress().getLocation();
			dto.city = user.getAddress().getCity();
			dto.pincode = user.getAddress().getPincode();
			dto.active = user.isActive();
			dtos.add(dto);
		}
		return dtos;
	}

}
