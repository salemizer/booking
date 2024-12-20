package com.salemworx.booking.exception;

import java.time.LocalDateTime;

public class BookingException extends CustomException{

	private String msg;
	private LocalDateTime timestamp;

	public BookingException(String msg, LocalDateTime timestamp) {
		// TODO Auto-generated constructor stub
		this.msg= msg;
		this.timestamp= timestamp;
	}
	
    public String getMsg() {
    	return this.msg;
    }
    
    public LocalDateTime getTimestamp() {
    	return this.timestamp;
    }
}
