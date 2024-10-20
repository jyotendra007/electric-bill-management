package com.vw.exception;

public class ConsumerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConsumerNotFoundException(String message) {
		super(message);
	}

}
