package com.salemworx.booking.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.salemworx.booking.domain.Customer;
import com.salemworx.booking.dto.CustomerDTO;


public interface CustomerService {

	Optional<CustomerDTO> getCustomer(Long customerId);
	Optional<Customer> createOrUpdateCustomer(Long customerId, Customer customer);
}
