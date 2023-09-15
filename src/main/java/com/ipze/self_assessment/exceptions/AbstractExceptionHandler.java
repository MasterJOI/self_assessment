package com.ipze.self_assessment.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;


public abstract class AbstractExceptionHandler {
	protected ApiError setResponseStatusAndReturnError(Exception exception, String code, HttpStatus status, HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(status.value());
		return ApiError.of(status, code, exception.getLocalizedMessage(), request.getRequestURI());
	}
}
