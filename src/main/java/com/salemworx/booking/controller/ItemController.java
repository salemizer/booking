package com.salemworx.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salemworx.booking.domain.Item;
import com.salemworx.booking.service.ItemService;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/v1/items")
	public ResponseEntity<List<Item>> listItems() {
		return new ResponseEntity<List<Item>>(itemService.listItems().get(), HttpStatus.OK);
	}
}
