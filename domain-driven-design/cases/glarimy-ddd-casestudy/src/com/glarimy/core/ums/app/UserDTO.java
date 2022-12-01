package com.glarimy.core.ums.app;

public class UserDTO {
	public String firstName;
	public String lastName;
	public long phone;
	public boolean active;
	public String location;
	public String city;
	public int pincode;

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", active=" + active
				+ ", location=" + location + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
