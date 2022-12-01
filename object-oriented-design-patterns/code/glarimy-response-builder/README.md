# A HTTP Response Builder

Design Patterns are tough nuts to crack, especially for the green-horns. Yet, they remain critical for building reusable object oriented systems, ever since they were published by the famous Gang of Four, almost three decades ago.

Builder is one of the six GoF creational patterns. Let us understand the pattern in the context of a REST based Java Web server.

The interaction between the client and server can be summed up in three steps: 

Step 1: Client makes a request to the server over HTTP protocol and waits for the response.
Step 2: Server processes the request and sends back the response. 
Step 3: Client receives the response. 

Our focus is on the HTTP Response object. 

According to the protocol, both the requests and responses carry headers and optional payloads. Each of the headers is a simple key-value pair. Since HTTP is a text based protocol, both the keys and the values are in the text format. And apart from the well-known HTTP headers, a server application developer can also choose to send some custom headers as well.

As different responses carry different sets of headers, it is impractical to override the constructor for every combination. Also, in many cases, the response might have to be built incrementally, one step at a time, since the server application might not have the information for the all headers, all at once. 

The scenario is analogous to that of making an order at a restaurant which offers several combinations. Typically, a waiter helps the customer in building the order, interactively. The waiter waits till the customer confirm the order, before placing it at the kitchen for processing. In other words, the restaurant delays allocation of the resources like the chef, burner, ingredients and etc., till the order is confirmed. It is also possible that customer may not even place the order in the end!

The builder pattern also recommends similar setup. Look at the following:

```
package com.glarimy.builder;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
			headers.put("address", "");
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
		Map<String, String> heads = new HashMap<String, String>();
		for (String header : headers.keySet()) {
			heads.put(header, headers.get(header));
		}
		return heads;
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
			Response response = new Response(headers, payload);
			return response;
		}

	}

}
```


The ResponseBuilder is playing the role of the waiter in the restaurant. It is offering several optional utility methods like setStatus() to make the job easier. However, it delays the creation of the Response object till the build() method is called. This is a good idea because the creation of Response object is bit resource intensive as it needs to compute some important headers.

That sums up the builder pattern. You know, the wizards that we use to make orders on an e-commerce portal, or to install a piece of software, or to build social media profile , are all builders!

Use this pattern to offer the developers an interactive way to create a resource intensive object. 

The full code is available at 



