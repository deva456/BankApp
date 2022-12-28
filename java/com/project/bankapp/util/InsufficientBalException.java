package com.project.bankapp.util;

public class InsufficientBalException extends Exception{

	public InsufficientBalException(String message) {
		super(message);
	}

}
