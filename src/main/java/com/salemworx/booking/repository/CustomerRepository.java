package com.salemworx.booking.repository;

import java.util.Optional;
import com.salemworx.booking.domain.Customer;
import com.salemworx.booking.dto.CustomerDTO;

public interface CustomerRepository {

	Optional<CustomerDTO> getCustomer(Long customerId);
	Optional<Customer> createOrUpdateCustomer(Long customerId, Customer customer);
}
