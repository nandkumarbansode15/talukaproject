package com.easysearch.customer.customerinfo.util;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.easysearch.customer.customerinfo.dao.CustomerDetails;
import com.easysearch.customer.customerinfo.pojo.CustomerDetailsDTO;

public class CustomerDetailsUtil {

	public static CustomerDetails mapCustomerDetailsDTO(CustomerDetailsDTO customerDetails) {
		CustomerDetails c = new CustomerDetails(customerDetails.getCustomerName(),
				customerDetails.getCustomerCurrentCity(), customerDetails.getCustomerBaseCity(),
				customerDetails.getCustomerAddress(), customerDetails.getMobileNumber(), customerDetails.isShopOwner(),
				Date.valueOf(customerDetails.getBirthDate()));
		if (customerDetails.getCustomerId() != null) {
			c.setCustomerId(customerDetails.getCustomerId());
		}

		return c;
	}

	public static CustomerDetailsDTO mapToCustomerDetailsDTO(CustomerDetails customerDetails) {
		CustomerDetailsDTO dto = new CustomerDetailsDTO(customerDetails.getCustomerId(),
				customerDetails.getCustomerName(), customerDetails.getCustomerCurrentCity(),
				customerDetails.getCustomerBaseCity(), customerDetails.getCustomerAddress(),
				customerDetails.getMobileNumber(), customerDetails.isShopOwner(),
				customerDetails.getBirthDate().toString());
		return dto;
	}

	public static List<CustomerDetailsDTO> mapAllCustomer(List<CustomerDetails> findAll) {
		return findAll.stream().map(p->mapToCustomerDetailsDTO(p)).collect(Collectors.toList());
	}

}
