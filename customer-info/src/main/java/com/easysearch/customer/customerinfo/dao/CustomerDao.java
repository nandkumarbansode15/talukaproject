package com.easysearch.customer.customerinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easysearch.customer.customerinfo.pojo.CustomerDetails;

@Repository
public interface CustomerDao extends JpaRepository<CustomerDetails, Long> {

	public CustomerDetails getCustomerByCustomerId(Long id);

}
