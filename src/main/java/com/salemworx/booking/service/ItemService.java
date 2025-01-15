package com.salemworx.booking.service;

import java.util.List;
import com.salemworx.booking.domain.Item;
import java.util.Optional;

public interface ItemService {

	Optional<List<Item>> listItems();

}
