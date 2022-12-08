package com.easysearch.shop.shopinfo.resource;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.easysearch.shop.shopinfo.pojo.CustomerDetails;
import com.easysearch.shop.shopinfo.pojo.ShopDetails;
import com.easysearch.shop.shopinfo.service.ShopService;
import com.easysearch.shop.shopinfo.service.ShopValidator;
import com.easysearch.shop.shopinfo.util.ShopUtil;
import com.easysearch.shop.shopinfo.vo.ResponseTemplateVo;

@RestController
@Slf4j
public class ShopResource {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopValidator shopValidator;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/shops/")
	public List<ResponseTemplateVo> getAllShopDetails()
	{
		log.info("In ShopResource->getAllShopDetails method ");
		
		List<ShopDetails> shopDtls=shopService.getAllShopDetails();

		return shopDtls.stream().map(s-> ShopUtil.fetchAndPopulateOtherDetails(restTemplate,s)).collect(Collectors.toList());
	}
	
	@PostMapping("/shops")
	public ShopDetails saveShopDetails(@RequestBody ShopDetails shopDetails)
	{
		log.info("In ShopResource->saveShopDetails method shopDetails="+shopDetails);
		
		if(!shopValidator.validateCity(shopDetails.getShopCity()))
		{
			ShopDetails shop=new ShopDetails();
			shop.setShopCity("This city is not supported");
			return shop;
		}
		
		return shopService.save(shopDetails);
	}
	
	@PutMapping("/shops")
	public ShopDetails updateShop(@RequestBody ShopDetails shopDetails)
	{
		log.info("In ShopResource->updateShop method shopDetails="+shopDetails);
		
		if(!shopValidator.validateCity(shopDetails.getShopCity()))
		{
			ShopDetails shop=new ShopDetails();
			shop.setShopCity("This city is not supported");
			return shop;
		}
		
		return shopService.updateShop(shopDetails);
	}
	
	@DeleteMapping("/shops/{id}")
	public String deleteShop(@PathVariable long id)
	{
		log.info("In ShopResource->deleteShop method id="+id);
		return shopService.deleteShop(id);
	}
	
	@GetMapping("/shops/{id}")
	public ResponseTemplateVo getShopDetails(@PathVariable long id)
	{
		log.info("In ShopResource->getShopDetails method id="+id);
		ShopDetails shop =shopService.getShopDetails(id);
		return ShopUtil.fetchAndPopulateOtherDetails(restTemplate,shop);
	}
	
	@GetMapping("/shops/city/{city}")
	public List<ShopDetails> getShopIdByCity(@PathVariable String city)
	{
		log.info("In ShopResource->getShopIdByCity method city="+city);
		return shopService.getShopIdByCity(city);
	}
	
	
	
}
