package com.easysearch.customer.customerinfo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerDetails, Long> {

	public CustomerDetails getCustomerByCustomerId(Long id);

	public List<CustomerDetails> findAll();

}
