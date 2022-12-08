package com.easysearch.customer.customerinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easysearch.customer.customerinfo.dao.CustomerDao;
import com.easysearch.customer.customerinfo.dao.CustomerDetails;
import com.easysearch.customer.customerinfo.pojo.CustomerDetailsDTO;
import com.easysearch.customer.customerinfo.util.CustomerDetailsUtil;

@Service
public class CustomerService {

	@Autowired
	private	CustomerDao customerDao;
	
	public CustomerDetails save(CustomerDetails customerDetails)
	{
		return customerDao.save(customerDetails);
	}
	
	public List<CustomerDetailsDTO> getCustomer(Long customerId)
	{
		List<CustomerDetailsDTO> list=new ArrayList<>();
		if(customerId.equals(0l))
		{
			list=CustomerDetailsUtil.mapAllCustomer(customerDao.findAll());
		}else
		{
			list.add(CustomerDetailsUtil.mapToCustomerDetailsDTO(customerDao.findById(customerId).get()));
		}

		return list;
	}

	public void deleteCustomer(Long customerId) {
		if(customerId.equals(0l))
		{
			customerDao.deleteAll();
		}else
		{
			customerDao.deleteById(customerId);
		}

	}

	public long getCustomerCount() {
		return customerDao.count();
	}
}
