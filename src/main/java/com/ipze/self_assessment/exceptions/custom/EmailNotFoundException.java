package com.ipze.self_assessment.exceptions.custom;

public class EmailNotFoundException extends RuntimeException {
	public EmailNotFoundException(String message) {
		super(message);
	}
}
