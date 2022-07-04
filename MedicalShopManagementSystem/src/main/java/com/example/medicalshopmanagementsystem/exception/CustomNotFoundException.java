package com.example.medicalshopmanagementsystem.exception;



public class CustomNotFoundException extends RuntimeException{

	public CustomNotFoundException() {
		super();
	}

	public CustomNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CustomNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CustomNotFoundException(String message) {
		super(message);
		
	}

	public CustomNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
}
