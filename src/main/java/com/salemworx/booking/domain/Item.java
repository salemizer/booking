package com.salemworx.booking.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "item")
public class Item {

	@Id
	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name="status")
	private Status status;
	
	@Column(name = "locked_until")
	private LocalDateTime lockedUntil;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = false)
	private List<Booking> booking;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalDateTime getLockedUntil() {
		return lockedUntil;
	}

	public void setLockedUntil(LocalDateTime lockedUntil) {
		this.lockedUntil = lockedUntil;
	}
	
	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
}
