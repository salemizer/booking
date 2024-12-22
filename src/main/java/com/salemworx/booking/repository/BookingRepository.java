package com.salemworx.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salemworx.booking.domain.Booking;
import com.salemworx.booking.domain.Customer;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query("select b.status from booking b where b.bookingId = :bookingId")
	String findStatusByBookingId(@Param("bookingId") Long bookingId);
}
