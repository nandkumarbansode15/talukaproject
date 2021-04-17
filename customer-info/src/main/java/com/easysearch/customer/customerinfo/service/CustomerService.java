package com.easysearch.customer.customerinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easysearch.customer.customerinfo.dao.CustomerDao;
import com.easysearch.customer.customerinfo.pojo.CustomerDetails;

@Service
public class CustomerService {

	@Autowired
	private	CustomerDao customerDao;
	
	public CustomerDetails save(CustomerDetails customerDetails)
	{
		return customerDao.save(customerDetails);
	}
	
	public CustomerDetails getCustomer(Long customerId)
	{
		return customerDao.findById(customerId).get();
	}
}
