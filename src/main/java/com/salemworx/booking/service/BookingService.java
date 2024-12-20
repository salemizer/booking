package com.salemworx.booking.service;

import java.util.List;
import java.util.Optional;

import com.salemworx.booking.domain.Booking;

public interface BookingService {
  
  List<Booking> listBooking();	
  Optional<Booking> createOrUpdateBooking(Long bookingId, Booking booking);
  Optional<Booking> getBooking(Long bookingId);
}
