package com.glarimy.builder;

public class Application {

	public static void main(String[] args) {
		Response response = new Response.ResponseBuilder()
				.setStatus(201)
				.setLocation("http://www.glarimy.com/blog/1")
				.build("your entity");
	}

}
