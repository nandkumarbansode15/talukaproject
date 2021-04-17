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
	private CustomerDetails customerDetails;
	private ShopDetails shopDetails;
}
