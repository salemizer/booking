package com.salemworx.booking.exception;

import java.time.LocalDateTime;

public class BookingError {

	private String message;
	private LocalDateTime localDateTime;

	public BookingError(String message, LocalDateTime localDateTime) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return this.message;
	}

	public LocalDateTime getlocalDateTime() {
		return this.localDateTime;
	}
}
