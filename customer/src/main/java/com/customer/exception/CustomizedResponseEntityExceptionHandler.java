package com.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Data> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		Data data = new Data("FAILURE",ex.getMessage());
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@ExceptionHandler(NoCustomerFoundException.class)
	public final ResponseEntity<Data> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		Data data = new Data("FAILURE",ex.getMessage());
		
		return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		
	}
	

}
