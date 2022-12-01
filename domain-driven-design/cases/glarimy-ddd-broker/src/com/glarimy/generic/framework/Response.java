package com.glarimy.generic.framework;

public class Response {
	private int code;
	private String message;
	private Object body;

	private Response() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public static class ResponseBuilder {
		String message;
		Object body;

		public ResponseBuilder addMessage(String message) {
			this.message = message;
			return this;
		}

		public ResponseBuilder addBody(Object body) {
			this.body = body;
			return this;

		}

		public Response buildWithCode(int code) {
			Response response = new Response();
			response.setMessage(message);
			response.setBody(body);
			response.setCode(code);
			return response;
		}
	}

}
