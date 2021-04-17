package com.easysearch.customer.customerinfo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class CustomerInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerInfoApplication.class, args);
	}

}
