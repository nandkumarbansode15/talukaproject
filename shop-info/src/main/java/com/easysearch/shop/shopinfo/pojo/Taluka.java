package com.easysearch.shop.shopinfo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Taluka {
	
	private int id;
	private String name;
	private String distName;
	private String stateName;
	private int totalPopulation;
	private int noOfVillages;
	private int noOfBanks;
	private int noOfATMs;
}
