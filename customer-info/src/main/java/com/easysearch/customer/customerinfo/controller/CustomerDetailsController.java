package com.easysearch.customer.customerinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easysearch.customer.customerinfo.dao.CustomerDetails;
import com.easysearch.customer.customerinfo.pojo.CustomerDetailsDTO;
import com.easysearch.customer.customerinfo.service.CustomerService;
import com.easysearch.customer.customerinfo.util.CustomerDetailsUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RefreshScope
public class CustomerDetailsController {

	@Autowired
	private CustomerService customerService;
	
	@Value("${application.property.test}")
	private String propertyFileTest;
	
	@PostMapping(value="/customer/")
	public CustomerDetails save(@RequestBody CustomerDetailsDTO customerDetails) throws InterruptedException
	{
		log.info("CustomerDetailsController method save"+customerDetails);
		return customerService.save(CustomerDetailsUtil.mapCustomerDetailsDTO(customerDetails));
	}
	
	@GetMapping("/customer/")
	public String home()
	{
		log.info("CustomerDetailsController method home");
		return propertyFileTest;
	}
	
	@GetMapping("/customer/{id}")
	public List<CustomerDetailsDTO> getCustomer(@PathVariable String id)
	{
		log.info("CustomerDetailsController method getCustomer id"+id);
		return customerService.getCustomer(Long.valueOf(id));
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable String id)
	{
		String message="Customer info deleted for customer id "+id;
		log.info("CustomerDetailsController method deleteCustomer id"+id);
		customerService.deleteCustomer(Long.valueOf(id));
		if(id.equals("0"))
		{
			message="Deleted all customer records";
		}
		return message;
	}
	
	@GetMapping("/customer/count")
	public long getCustomerCount() throws InterruptedException
	{
		Thread.sleep(3000);
		return customerService.getCustomerCount();
	}
	
	/*
	 * @GetMapping("/customer/city/{city}") public List<CustomerDetailsDTO>
	 * getCustomerByCity() {
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping("/customer/basecity/{city}") public List<CustomerDetailsDTO>
	 * getCustomerByBaseCity() {
	 * 
	 * }
	 * 
	 * @GetMapping("/customer/currentcity/{city}") public List<CustomerDetailsDTO>
	 * getCustomerByCurrentCity() {
	 * 
	 * }
	 * 
	 * @GetMapping("/customer/date/{date}/{greater}") public
	 * List<CustomerDetailsDTO> getCustomerByBirthDate() {
	 * 
	 * }
	 * 
	 * @GetMapping("/customer/date/{date}/{greater}") public
	 * List<CustomerDetailsDTO> getCustomerByBirthDate() {
	 * 
	 * }
	 */
}
