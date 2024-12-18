package com.salemworx.booking.repository;

import java.util.Optional;
import com.salemworx.booking.domain.Customer;

public interface CustomerRepository {

	Optional<Customer> getCustomer(Long customerId);
}
