package com.easysearch.shop.shopinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.easysearch.shop.shopinfo.pojo.Taluka;

@Service
public class ShopValidator {

	@Autowired
	private RestTemplate restTemplate;
	
	public boolean validateCity(String cityName) {

		boolean flag=true; 
		try
		{
			restTemplate.getForObject("http://TALUKA-INFO-SERVICE/taluka/"+cityName, Taluka.class);
		}catch(Exception e)
		{
			flag=false;
		}
		
		return flag;
	}

}
