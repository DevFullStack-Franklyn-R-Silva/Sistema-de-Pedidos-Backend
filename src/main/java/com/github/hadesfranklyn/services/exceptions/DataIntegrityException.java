package com.github.hadesfranklyn.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException() {
		super();
	}

	
	public DataIntegrityException(String message) {
		super(message);
	}


	public DataIntegrityException(String message, Throwable cause) {
		super(message, cause);
	}

}
