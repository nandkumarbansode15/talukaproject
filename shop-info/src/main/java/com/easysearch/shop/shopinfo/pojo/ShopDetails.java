package com.easysearch.shop.shopinfo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="shop")
public class ShopDetails {
	
	@Id
	@GeneratedValue
	private long shopId;
	private String shopName;
	private String shopAddress;
	private String shopCity;
	private long ownerId;
	
	
}
