package com.glarimy.is.domain;

@SuppressWarnings("serial")
public class DuplicateProductException extends InventoryException {

	public DuplicateProductException() {
		// TODO Auto-generated constructor stub
	}

	public DuplicateProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
