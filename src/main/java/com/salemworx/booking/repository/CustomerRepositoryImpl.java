package com.salemworx.booking.repository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.salemworx.booking.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<Customer> getCustomer(Long customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> res = Optional.empty();
		String queryString = "select c from customer c where c.customerId = :customerId";
		try {
			Query query = entityManager.createQuery(queryString);
			query.setParameter("customerId", customerId);
			Object resObj = query.getSingleResult();
			if (resObj != null && resObj instanceof Customer)
				res = Optional.ofNullable((Customer) resObj);
		} catch (Throwable th) {
			logger.debug("****** " + th.getMessage());
		}
		return res;
	}

	@Transactional
	public Optional<Customer> createOrUpdateCustomer(Long customerId, Customer customer) {
		Customer managedObj = null;
		try {
			managedObj = entityManager.find(Customer.class, customerId);

			if (managedObj == null) {
				managedObj = new Customer();
				managedObj.setCustomerName(customer.getCustomerName());
				entityManager.persist(managedObj);
				return Optional.ofNullable(managedObj);
			}

			managedObj.setCustomerName(customer.getCustomerName());
			managedObj = entityManager.merge(managedObj);
		} catch (Throwable ex) {
			logger.debug("***** " + ex.getMessage());
		}
		return Optional.ofNullable(managedObj);
	}

}
