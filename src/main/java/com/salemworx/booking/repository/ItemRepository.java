package com.salemworx.booking.repository;

import java.util.List;
import com.salemworx.booking.domain.Item;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface ItemRepository {

	Optional<List<Item>> listItems();
}
