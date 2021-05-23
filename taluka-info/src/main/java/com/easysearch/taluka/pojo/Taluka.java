package com.easysearch.taluka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection="Taluka")
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
