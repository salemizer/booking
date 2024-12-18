package com.salemworx.booking.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.salemworx.booking.domain.Customer;


public interface CustomerService {

	Optional<Customer> getCustomer(Long customerId);
}
