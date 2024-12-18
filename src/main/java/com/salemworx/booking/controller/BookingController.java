package com.salemworx.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salemworx.booking.domain.Booking;
import com.salemworx.booking.repository.BookingRepository;

@RestController
@RequestMapping("/api")
public class BookingController {

@Autowired
private BookingRepository bookingRepo;

@GetMapping("/v1/bookings")	
private List<Booking> listBooking() {
	return bookingRepo.findAll();
}

@PostMapping("/v1/bookings")	
private Booking listBooking(@RequestBody Booking booking) {
	return bookingRepo.save(booking);
}
}
