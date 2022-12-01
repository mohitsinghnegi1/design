package com.glarimy.core.ums.app;

import java.util.List;

import com.glarimy.core.ums.domain.Phone;
import com.glarimy.core.ums.domain.User;
import com.glarimy.core.ums.domain.UserRepository;
import com.glarimy.generic.framework.ObjectFactory;
import com.glarimy.generic.framework.Response;

public class UserController {
	private UserService service;
	private UserRepository repo;

	public UserController() throws Exception {
		this.repo = (UserRepository) ObjectFactory.get("user.repo");
		this.service = (UserService) ObjectFactory.get("user.service");
	}

	public Response add(UserDTO dto) {
		User user = service.register(UserMapper.from(dto));
		return new Response.ResponseBuilder().addBody(UserMapper.from(user)).buildWithCode(0);
	}

	public Response remove(long phone) {
		service.unregister(new Phone(phone));
		return new Response.ResponseBuilder().buildWithCode(0);
	}

	public Response getByPhone(long phone) {
		User user = repo.findOne(new Phone(phone));
		return new Response.ResponseBuilder().addBody(UserMapper.from(user)).buildWithCode(0);

	}

	public Response getAll() {
		List<User> users = repo.findAll();
		return new Response.ResponseBuilder().addBody(UserMapper.from(users)).buildWithCode(0);
	}

	public Response getByCity(String city) {
		List<User> users = repo.findByCity(city);
		return new Response.ResponseBuilder().addBody(UserMapper.from(users)).buildWithCode(0);

	}

	public Response getByStatus(boolean status) {
		List<User> users = repo.findByStatus(status);
		return new Response.ResponseBuilder().addBody(UserMapper.from(users)).buildWithCode(0);
	}

}
