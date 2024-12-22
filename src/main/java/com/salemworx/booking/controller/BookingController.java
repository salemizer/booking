package com.salemworx.booking.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salemworx.booking.domain.Booking;
import com.salemworx.booking.exception.BookingException;
import com.salemworx.booking.exception.CustomException;
import com.salemworx.booking.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/v1/bookings/{bookingId}")
	private Optional<Booking> getBooking(@PathVariable Long bookingId) {
		return bookingService.getBooking(bookingId);
	}
	
	@GetMapping("/v1/bookings")
	private List<Booking> listBooking() {
		return bookingService.listBooking();
	}

	@PutMapping("/v1/bookings/{bookingId}")
	private ResponseEntity<Booking> createOrUpdateBooking(@PathVariable Long bookingId, @RequestBody Booking booking) {
		
			Optional<Booking> result= bookingService.createOrUpdateBooking(bookingId, booking);
			if(result.isEmpty())
				throw new BookingException("result set is empty!!");

		return new ResponseEntity<Booking>(result.get(), HttpStatus.OK);
	}
}
