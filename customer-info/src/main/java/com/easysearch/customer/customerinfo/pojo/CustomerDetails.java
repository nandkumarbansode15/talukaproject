package com.easysearch.customer.customerinfo.pojo;

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
	private String customerAddress;
	private String mobileNumber;
	
	
}
