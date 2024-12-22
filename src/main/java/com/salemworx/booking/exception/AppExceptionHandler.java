package com.salemworx.booking.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BookingException.class)
	public final ResponseEntity<BookingError> handleBookingException(Exception ex, WebRequest request){
			return new ResponseEntity(new BookingError(ex.getMessage()+"\n"
			, LocalDateTime.now()), HttpStatus.CONFLICT);
	}

}
