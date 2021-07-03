package com.geekymon2.carmarketplace.carlistingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CarListingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarListingServiceApplication.class, args);
	}

}
