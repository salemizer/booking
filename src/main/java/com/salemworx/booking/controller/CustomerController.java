package com.salemworx.booking.controller;

import java.time.LocalDateTime;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salemworx.booking.domain.Customer;
import com.salemworx.booking.exception.BookingException;
import com.salemworx.booking.exception.CustomException;
import com.salemworx.booking.service.CustomerService;

@RequestMapping("/api")
@RestController
public class CustomerController {

	private static Logger logger= LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/v1/customers/{customerId}")
	private ResponseEntity<Customer> getCustomer(@PathVariable Long customerId){
		Optional<Customer> res = customerService.getCustomer(customerId);
		if (res.isEmpty()) {
			LocalDateTime timestamp= LocalDateTime.now();
			throw new BookingException();
		}
		return new ResponseEntity<Customer>(res.get(), HttpStatus.FOUND);
	}

	@PutMapping("/v1/customers/{customer_id}")
	private ResponseEntity<Customer> createCustomer(@PathVariable Long customer_id, @RequestBody Customer customer) {
		Optional<Customer> resObj = customerService.createOrUpdateCustomer(customer_id, customer);
		if (resObj.isEmpty())
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		return new ResponseEntity<Customer>(resObj.get(), HttpStatus.CONFLICT);
	}
}
