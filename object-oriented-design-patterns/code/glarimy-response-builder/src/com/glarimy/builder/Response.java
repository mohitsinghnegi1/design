package com.glarimy.builder;

import java.net.InetAddress;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.management.ImmutableDescriptor;

public class Response {
	private String payload;
	private Map<String, String> headers;

	private Response(Map<String, String> headers, String payload) {
		this.headers = headers;
		this.payload = payload;

		if (headers.get("status") == null)
			headers.put("status", Integer.toString(200));

		if (headers.get("type") == null)
			headers.put("type", "plain/text");

		headers.put("length", Integer.toString(payload.length()));
		headers.put("timestamp", Long.toString(new Date().getTime()));

		try {
			headers.put("address", InetAddress.getLocalHost().getHostName());
		} catch (Exception e) {
			headers.put("address", "not available");
		}
	}

	public int getStatus() {
		return Integer.parseInt(headers.get("status"));
	}

	public String getType() {
		return headers.get("type");
	}

	public String getPayload() {
		return payload;
	}

	public Map<String, String> getHeaders() {
		return Collections.unmodifiableMap(headers);
	}

	public int getLength() {
		return Integer.parseInt(headers.get("length"));
	}

	public Date getTimestamp() {
		return new Date(Long.parseLong(headers.get("timestamp")));
	}

	public String getAddress() {
		return headers.get("address");
	}

	@Override
	public String toString() {
		return "Response [payload=" + payload + ", headers=" + headers + "]";
	}

	public static class ResponseBuilder {
		private Map<String, String> headers = new HashMap<String, String>();

		public ResponseBuilder setStatus(int status) {
			headers.put("status", Integer.toString(status));
			return this;
		}

		public ResponseBuilder setType(String type) {
			headers.put("type", type);
			return this;
		}

		public ResponseBuilder setLocation(String location) {
			headers.put("location", location);
			return this;
		}

		public ResponseBuilder addHeader(String name, String value) {
			headers.put(name, value);
			return this;
		}

		public Response build(String payload) {
			return new Response(headers, payload);
		}

	}

}
