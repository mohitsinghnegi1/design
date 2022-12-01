package com.glarimy;

import com.glarimy.core.ums.app.UserController;
import com.glarimy.core.ums.app.UserDTO;
import com.glarimy.generic.framework.ObjectFactory;
import com.glarimy.generic.framework.Response;

public class ArtStation {
	public static void main(String[] args) throws Exception {
		UserDTO user = new UserDTO();
		user.phone = 9731423166L;
		user.firstName = "Krishna Mohan";
		user.lastName = "Koyya";
		user.location = "Pai Layout, Old Madras Road";
		user.city = "Bengaluru";
		user.pincode = 560016;

		UserController uc = (UserController) ObjectFactory.get("user.controller");
		Response response = uc.add(user);
		System.out.println(response.getBody());
	}
}