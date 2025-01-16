package com.salemworx.booking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salemworx.booking.domain.Booking;
import com.salemworx.booking.domain.Item;
import com.salemworx.booking.domain.Status;
import com.salemworx.booking.exception.BookingException;
import com.salemworx.booking.repository.BookingRepository;
import com.salemworx.booking.repository.ItemRepositoryDataJPAImpl;
import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private ItemRepositoryDataJPAImpl itemRepo;

	public List<Booking> listBooking() {
		return bookingRepo.findAll();
	}

	public Optional<Booking> getBooking(Long bookingId) {
		return bookingRepo.findById(bookingId);
	}

	@Transactional
	@Override
	public synchronized Optional<Booking> createOrUpdateBooking(Long bookingId, Booking booking)
			throws BookingException {
		// TODO Auto-generated method stub
		Optional<Booking> resObj = Optional.empty();

		Item item = booking.getItem();
		if (item == null || item.getItemId() == null)
			throw new BookingException("Unable to retrieve Booking Item!");

		Optional<String> itemStatus = itemRepo.findStatusByItemId(item.getItemId());

//			logger.debug("*** " + bookingStatus);
		if (!itemStatus.isEmpty()) {
			if (itemStatus.get().equals("BOOKED"))
				throw new BookingException("Booking status is BOOKED!!!");
			if (itemStatus.get().equals("LOCKED"))
				throw new BookingException("Booking status is LOCKED!!!");
		}

		// Lock item
		if (lockItem(item.getItemId()) != 1)
			throw new BookingException("Unable to lock item!");

		// start new booking
		Booking newBooking = new Booking();

		newBooking.setBookingId(bookingId);
		newBooking.setDesc(booking.getDesc());

		// set customer
		newBooking.setCustomer(booking.getCustomer());

		// set booked item
		item.setStatus(Status.BOOKED);
		newBooking.setItem(item);

		// the lock released automatically after this transaction commit/flush
		try {
			return resObj = Optional.ofNullable(bookingRepo.save(newBooking));
//			return resObj;
		} catch (RuntimeException rte) {
			logger.debug("****" + rte.getMessage());
		}
		return resObj;
	}

	@Transactional
	private int lockItem(Long itemId) {
		// initially locked for Now() + 3 minutes.
		LocalDateTime lockedUntil = LocalDateTime.now().plusMinutes(3L);
		return itemRepo.markItemAsLocked(itemId, Status.LOCKED, lockedUntil);
	}
}
