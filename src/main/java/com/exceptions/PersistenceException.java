package com.exceptions;

public class PersistenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public PersistenceException(String message) {
		super();
		this.message = message;
	}

	public PersistenceException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
