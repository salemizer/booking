package com.salemworx.booking.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salemworx.booking.domain.Customer;
import com.salemworx.booking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Optional<Customer> getCustomer(Long customerId) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomer(customerId);
	}
	
	public Optional<Customer> createOrUpdateCustomer(Long customerId, Customer customer){
		return customerRepo.createOrUpdateCustomer(customerId, customer);
	}

}
