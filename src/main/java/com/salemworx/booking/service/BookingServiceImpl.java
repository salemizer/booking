package com.salemworx.booking.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salemworx.booking.domain.Booking;
import com.salemworx.booking.domain.Customer;
import com.salemworx.booking.domain.Item;
import com.salemworx.booking.repository.BookingRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private BookingRepository bookingRepo;

	public List<Booking> listBooking() {
		return bookingRepo.findAll();
	}

	public Optional<Booking> getBooking(Long bookingId){
	  return bookingRepo.findById(bookingId);
	}
	
	@Transactional
	@Override
	public synchronized Optional<Booking> createOrUpdateBooking(Long bookingId, Booking booking) {
		// TODO Auto-generated method stub
		Optional<Booking> resObj = Optional.empty();

		try {
			Booking newBooking = new Booking();
		
		    newBooking.setBookingId(bookingId);
			
			newBooking.setDesc(booking.getDesc());
			newBooking.setFromDateTime(booking.getFromDateTime());
			newBooking.setToDateTime(booking.getToDateTime());
			Customer c= new Customer();
			c.setCustomerId(booking.getCustomer().getCustomerId());
			c.setCustomerName(booking.getCustomer().getCustomerName());
			newBooking.setCustomer(c);
			Item i= new Item();
			i.setItemId(booking.getItem().getItemId());
			i.setItemName(booking.getItem().getItemName());
			newBooking.setItem(i);
			newBooking.setStatus(booking.getStatus());

			return resObj= Optional.ofNullable(bookingRepo.save(newBooking));
			
		} catch (Throwable th) {
			logger.debug("****" + th.getMessage());
		}
		return resObj;
	}
}
