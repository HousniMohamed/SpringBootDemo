package com.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.exceptions.DataNotFoundException;
import com.model.ApiErrorResponse;

/**
 * 
 * @author Housni Mohamed
 *
 */
@ControllerAdvice
public class ControllerExceptions {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiErrorResponse handleValidationException(MethodArgumentNotValidException ex) {

		String code = ex.getBindingResult().getFieldError().getDefaultMessage();
		return new ApiErrorResponse(500, 500, code);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataNotFoundException.class)
	public ApiErrorResponse handleDataNotFoundException(DataNotFoundException data) {
		return new ApiErrorResponse(500, 500, data.getMessage());
	}

}
