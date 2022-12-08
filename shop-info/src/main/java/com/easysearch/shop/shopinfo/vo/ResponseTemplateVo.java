package com.easysearch.shop.shopinfo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.easysearch.shop.shopinfo.pojo.CustomerDetails;
import com.easysearch.shop.shopinfo.pojo.ShopDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseTemplateVo {
	
	private String customerName;
	private String customerAddress;
	private String mobileNumber;
	private String shopName;
	private String shopAddress;
	private String cityName;
	private String distName;
	private String stateName;
	private long ownerId;
}
