package com.example.walletshopping.exception;

public class InavalidCartIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public InavalidCartIdException(String message) {
		super(message);
		this.message = message;
	}

	public InavalidCartIdException() {
		super();
	}

}
