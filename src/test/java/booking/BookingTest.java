package booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.salemworx.booking.domain.Booking;
import com.salemworx.booking.repository.BookingRepository;
import com.salemworx.booking.service.BookingServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookingTest {

	@Mock
	BookingRepository bookingRepo;

	@InjectMocks
	BookingServiceImpl bookingService;

	@Test
	public void listBooking_notEmpty() {
		Booking booking1 = new Booking();
		booking1.setBookingId(1L);
		List<Booking> list = new LinkedList<Booking>();
		list.add(booking1);
		when(bookingRepo.findAll()).thenReturn(list);
		assertEquals(list, bookingService.listBooking());
	}

	@Test
	public void listBooking_Empty() {
		when(bookingRepo.findAll()).thenReturn(null);
		assertEquals(null, bookingService.listBooking());
	}

	@Test
	public void getBooking_NotEmpty() {
		Booking booking1 = new Booking();
		booking1.setBookingId(1L);
		Booking booking2 = new Booking();
		booking2.setBookingId(2L);
		when(bookingRepo.findById(1L)).thenReturn(Optional.ofNullable(booking1));
		Optional<Booking> op1 = bookingService.getBooking(1L);
		assertEquals(Optional.ofNullable(booking1), op1);
//		assertEquals(booking2 , booking1);
	}

}
