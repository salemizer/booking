package com.salemworx.booking.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.salemworx.booking.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Optional<List<Item>> listItems() {
		TypedQuery<Item> query = entityManager.createQuery("select i from Item i", Item.class);
		return Optional.ofNullable(query.getResultList());
	}
}
