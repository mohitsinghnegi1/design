package com.glarimy.is.domain;

@SuppressWarnings("serial")
public class InvalidProductException extends InventoryException {

	public InvalidProductException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
