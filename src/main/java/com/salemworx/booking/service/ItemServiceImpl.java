package com.salemworx.booking.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salemworx.booking.domain.Item;
import com.salemworx.booking.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

@Autowired
private ItemRepository itemRepo;

	@Override
	public Optional<List<Item>> listItems() {
		// TODO Auto-generated method stub
		return itemRepo.listItems();
	}

}
