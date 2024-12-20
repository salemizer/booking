package com.salemworx.booking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	private Long itemId;
	
	private String itemName;

	@JsonIgnore
	@OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
	private Booking booking;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
