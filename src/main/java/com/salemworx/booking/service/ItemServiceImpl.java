package com.salemworx.booking.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.salemworx.booking.domain.Item;
import com.salemworx.booking.repository.ItemRepository;
import com.salemworx.booking.repository.ItemRepositoryDataJPAImpl;

import jakarta.transaction.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private ItemRepositoryDataJPAImpl itemRepoDataJPA;

	@Override
	public Optional<List<Item>> listItems() {
		// TODO Auto-generated method stub
		return itemRepo.listItems();
	}

	@Transactional
	@Scheduled(fixedRate = 60000)
	void releaseStaleItemLocks() {
		logger.debug("*** " + itemRepoDataJPA.releaseStaleLocks());
	}
}
