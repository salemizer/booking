package com.salemworx.booking.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salemworx.booking.domain.Customer;
import com.salemworx.booking.service.CustomerService;

@RequestMapping("/api")
@RestController
public class CustomerController {

@Autowired
private CustomerService customerService;

@GetMapping("/v1/customer/{customerId}")
private ResponseEntity<Customer>getCustomer(@PathVariable Long customerId){
	Optional<Customer> res= customerService.getCustomer(customerId);
	if(res.isEmpty())
		return null;
	return new ResponseEntity<Customer>(res.get(), HttpStatus.FOUND);
}
}
