package com.easysearch.shop.shopinfo.service;

import java.util.List;
import java.util.Optional;

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

	public List<ShopDetails> getShopIdByCity(String city) {

		return shopDao.findAllByShopCity(city);
	}

	public List<ShopDetails> getAllShopDetails() {
		
		return shopDao.findAll();
	}

	public ShopDetails updateShop(ShopDetails shopDetails) {
		Optional<ShopDetails> optionalShopDetails=shopDao.findById(shopDetails.getShopId());
		ShopDetails shopDetails2=new ShopDetails();
		if(optionalShopDetails.isPresent())
		{
			shopDetails2=optionalShopDetails.get();
			shopDetails2.setOwnerId(shopDetails.getOwnerId());
			shopDetails2.setShopAddress(shopDetails.getShopAddress());
			shopDetails2.setShopCity(shopDetails.getShopCity());
			shopDetails2.setShopName(shopDetails.getShopName());
			
		}
		return shopDetails2;
	}

	public String deleteShop(long id) {
		shopDao.deleteById(id);
		return "Record deleted";
	}
}
