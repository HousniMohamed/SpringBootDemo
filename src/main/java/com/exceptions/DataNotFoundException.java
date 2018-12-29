package com.exceptions;

/**
 * 
 * @author Housni Mohamed
 *
 */
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int id;

	public DataNotFoundException(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Task with ID '" + id + "' not found";
	}

}
