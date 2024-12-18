package com.salemworx.booking.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Query;
import com.salemworx.booking.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<Customer> getCustomer(Long customerId) {
		// TODO Auto-generated method stub
		String queryString= "select c from customer where c.customerId = :customerId";
		Query query= entityManager.createQuery(queryString);
		query.setParameter(0, customerId);
		Object resObj= query.getSingleResult();
		if(resObj != null && resObj instanceof Customer)
		   return Optional.ofNullable((Customer)resObj);	
		
		return Optional.empty();
	}

}
