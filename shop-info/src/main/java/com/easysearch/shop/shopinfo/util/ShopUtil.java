package com.easysearch.shop.shopinfo.util;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestTemplate;

import com.easysearch.shop.shopinfo.pojo.CustomerDetails;
import com.easysearch.shop.shopinfo.pojo.ShopDetails;
import com.easysearch.shop.shopinfo.pojo.Taluka;
import com.easysearch.shop.shopinfo.vo.ResponseTemplateVo;

@Slf4j
public class ShopUtil {

	private ShopUtil()
	{
		
	}

	public static ResponseTemplateVo getResponseTemplateVo(ShopDetails shop,
			CustomerDetails customerDetails, Taluka taluka) {
		ResponseTemplateVo templateVo=new ResponseTemplateVo();
		
		populateShopDetails(shop,templateVo);
		populateCustomerDetails(customerDetails,templateVo);
		populateTalukaDetails(taluka,templateVo);
		
		return templateVo;
	}

	private static void populateTalukaDetails(Taluka taluka,
			ResponseTemplateVo templateVo) {

		templateVo.setStateName(taluka.getStateName());
		templateVo.setDistName(taluka.getDistName());
		
	}

	public static void populateShopDetails(ShopDetails shop,
			ResponseTemplateVo templateVo) {
		templateVo.setCityName(shop.getShopCity());
		templateVo.setOwnerId(shop.getOwnerId());
		templateVo.setShopAddress(shop.getShopAddress());
		templateVo.setShopName(shop.getShopName());
		
	}

	public static void populateCustomerDetails(
			CustomerDetails customerDetails, ResponseTemplateVo templateVo) {

		templateVo.setCustomerAddress(customerDetails.getCustomerAddress());
		templateVo.setCustomerName(customerDetails.getCustomerName());
		
		templateVo.setMobileNumber(customerDetails.getMobileNumber());
		
	}

	public static ResponseTemplateVo fetchAndPopulateOtherDetails(
			RestTemplate restTemplate, ShopDetails shop) {
		CustomerDetails customerDetails= restTemplate.getForObject("http://OWNER-INFO-SERVICE/customer/"+shop.getOwnerId(), CustomerDetails.class);
		
		Taluka taluka=restTemplate.getForObject("http://TALUKA-INFO-SERVICE/taluka/"+shop.getShopCity(), Taluka.class);

		log.info("In ShopUtil->fetchAndPopulateOtherDetails method shop="+shop);
		
		log.info("In ShopUtil->fetchAndPopulateOtherDetails method customerDetails="+customerDetails);
		
		log.info("In ShopUtil->fetchAndPopulateOtherDetails method taluka="+taluka);
		
		log.info("In ShopUtil->fetchAndPopulateOtherDetails method shop.getShopCity()="+shop.getShopCity());
		
		return getResponseTemplateVo(shop,customerDetails,taluka);
	}
}
