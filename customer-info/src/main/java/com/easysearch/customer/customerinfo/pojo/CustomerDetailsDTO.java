package com.easysearch.customer.customerinfo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Setter
@Getter
public class CustomerDetailsDTO {

	private Long customerId;
	private String customerName;
	private String customerCurrentCity;
	private String customerBaseCity;
	private String customerAddress;
	private String mobileNumber;
	private boolean isShopOwner;
	private String birthDate;
}
