package com.easysearch.shop.shopinfo.resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.easysearch.shop.shopinfo.pojo.CustomerDetails;
import com.easysearch.shop.shopinfo.pojo.ShopDetails;
import com.easysearch.shop.shopinfo.service.ShopService;
import com.easysearch.shop.shopinfo.vo.ResponseTemplateVo;

@RestController
@Slf4j
public class ShopResource {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/shops/{id}")
	public ResponseTemplateVo getShopDetails(@PathVariable long id)
	{
		log.info("In ShopResource->getShopDetails method id="+id);
		ShopDetails shop =shopService.getShopDetails(id);
		ResponseTemplateVo responseTemplateVo=new ResponseTemplateVo();
		CustomerDetails customerDetails= restTemplate.getForObject("http://OWNER-INFO-SERVICE/customer/"+shop.getOwnerId(), CustomerDetails.class);
				
		responseTemplateVo.setCustomerDetails(customerDetails);
		responseTemplateVo.setShopDetails(shop);
		
		return responseTemplateVo;
	}
	
	@PostMapping("/shops")
	public ShopDetails saveShopDetails(@RequestBody ShopDetails shopDetails)
	{
		log.info("In ShopResource->saveShopDetails method shopDetails="+shopDetails);
		return shopService.save(shopDetails);
	}
}
