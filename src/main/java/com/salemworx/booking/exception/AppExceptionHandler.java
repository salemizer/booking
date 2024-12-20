package com.salemworx.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler{

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request){
		if(ex instanceof BookingException) {
			return new ResponseEntity("Booking Exception", HttpStatus.NOT_ACCEPTABLE);
		}
		return null;
	}

}
