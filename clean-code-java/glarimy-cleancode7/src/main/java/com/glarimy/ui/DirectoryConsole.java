package com.glarimy.ui;

import java.util.List;

import com.glarimy.app.DirectoryController;
import com.glarimy.app.UserData;
import com.glarimy.infra.Factory;
import com.glarimy.infra.ObjectFactory;

public class DirectoryConsole {
	public static void main(String[] args) throws Exception {
		Factory factory = new ObjectFactory();
		DirectoryController dir = (DirectoryController) factory.get("controller");
		UserData user = new UserData();
		user.name = "Krishna";
		user.phoneNumber = 9731423166L;
		user.email = "krishna@glarimy.com";
		user.location = "Pai Layaout";
		user.city = "Bengaluru";
		user.pincode = 534101;

		dir.register(user);
		dir.findByPhone(9731423166L).ifPresent(u -> System.out.println(">>>> Found user with email: " + u.email));

		List<UserData> results = dir.findByName("Krishna");
		System.out.println(">>>> Found " + results.size() + " result(s)");
	}
}
