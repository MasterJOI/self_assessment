package com.ipze.self_assessment.exceptions.custom;

import lombok.Getter;

@Getter
public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException(String message) {
		super(message);
	}

}
