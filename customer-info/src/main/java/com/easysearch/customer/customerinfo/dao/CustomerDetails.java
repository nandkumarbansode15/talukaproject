package com.easysearch.customer.customerinfo.dao;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDetails {

	@Id
	@GeneratedValue
	private Long customerId;
	private String customerName;
	private String customerCurrentCity;
	private String customerBaseCity;
	private String customerAddress;
	private String mobileNumber;
	private boolean isShopOwner;
	private Date birthDate;
	
	
	public CustomerDetails(String customerName, String customerCurrentCity, String customerBaseCity,
			String customerAddress, String mobileNumber, boolean isShopOwner, Date birthDate) {
		super();
		this.customerName = customerName;
		this.customerCurrentCity = customerCurrentCity;
		this.customerBaseCity = customerBaseCity;
		this.customerAddress = customerAddress;
		this.mobileNumber = mobileNumber;
		this.isShopOwner = isShopOwner;
		this.birthDate = birthDate;
	}
	
}
