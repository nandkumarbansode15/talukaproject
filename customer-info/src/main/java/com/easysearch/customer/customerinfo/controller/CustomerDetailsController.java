package com.easysearch.customer.customerinfo.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easysearch.customer.customerinfo.pojo.CustomerDetails;
import com.easysearch.customer.customerinfo.service.CustomerService;

@RestController
@Slf4j
@RefreshScope
public class CustomerDetailsController {

	@Autowired
	private CustomerService customerService;
	
	@Value("${application.property.test}")
	private String propertyFileTest;
	
	@PostMapping(value="/customer/")
	public CustomerDetails save(@RequestBody CustomerDetails customerDetails)
	{
		log.info("CustomerDetailsController method save"+customerDetails);
		return customerService.save(customerDetails);
	}
	
	@GetMapping("/customer/")
	public String home()
	{
		log.info("CustomerDetailsController method home");
		return propertyFileTest;
	}
	
	@GetMapping("/customer/{id}")
	public CustomerDetails getCustomer(@PathVariable String id)
	{
		log.info("CustomerDetailsController method getCustomer id"+id);
		return customerService.getCustomer(Long.valueOf(id));
	}
}
