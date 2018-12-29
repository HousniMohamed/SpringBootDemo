package com.exceptions;

public class MappingExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int id;
	private String message;

	public MappingExceptions(String message, int id) {
		super();
		this.message = message;
		this.id = id;
	}

	public MappingExceptions(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
