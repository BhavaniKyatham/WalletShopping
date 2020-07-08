package com.example.walletshopping.exception;

public class InsufficientAmountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public InsufficientAmountException(String message) {
		super(message);
		this.message = message;
	}

	public InsufficientAmountException() {
		super();
	}

}
