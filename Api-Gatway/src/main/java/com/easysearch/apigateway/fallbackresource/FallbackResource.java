package com.easysearch.apigateway.fallbackresource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackResource {
	
	@GetMapping("/shopFallBackMethod")
	public String shopFallBackMethod()
	{
		return "Shop service is not working now, Please try later";
	}
	
	@GetMapping("/customerFallBackMethod")
	public String customerFallBackMethod()
	{
		return "Customer service is not working now, Please try later";	
	}
}
