package com.glarimy.bank.tx.app;

public class Response {
	public int status;
	public Object body;

	public Response(int status) {
		super();
		this.status = status;
	}

	public Response(int status, Object body) {
		super();
		this.status = status;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", body=" + body + "]";
	}

}
