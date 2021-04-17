package com.easysearch.shop.shopinfo.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easysearch.shop.shopinfo.dao.ShopDao;
import com.easysearch.shop.shopinfo.pojo.ShopDetails;

@Service
@Slf4j
public class ShopService {

	@Autowired
	private ShopDao shopDao;
	
	public ShopDetails save(ShopDetails shopDetails)
	{
		log.info("In ShopService->save method");
		return shopDao.save(shopDetails);
	}
	
	public ShopDetails getShopDetails(Long shopId)
	{
		log.info("In ShopService->getShopDetails method");
		return shopDao.findById(shopId).orElse(new ShopDetails());
	}
}
