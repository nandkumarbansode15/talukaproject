package com.easysearch.shop.shopinfo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDetails {
	private Long customerId;
	private String customerName;
	private String customerAddress;
	private String mobileNumber;
	
	
}
