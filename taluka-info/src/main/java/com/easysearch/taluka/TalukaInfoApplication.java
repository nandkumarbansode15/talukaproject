package com.easysearch.taluka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TalukaInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalukaInfoApplication.class, args);
	}

}
