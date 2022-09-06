package com.training.services;

public class MyUsernameNotFoundException extends Exception {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public MyUsernameNotFoundException(String string) {
		this.message=message;
	}

	
}
