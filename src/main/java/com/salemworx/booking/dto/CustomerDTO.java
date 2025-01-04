package com.salemworx.booking.dto;

public class CustomerDTO {

	private String customerName;

	public CustomerDTO(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
