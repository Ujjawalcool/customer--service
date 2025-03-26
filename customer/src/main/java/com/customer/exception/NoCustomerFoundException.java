package com.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoCustomerFoundException extends RuntimeException {

	public NoCustomerFoundException(String message) {
		super(message);
	}
	
	

}
