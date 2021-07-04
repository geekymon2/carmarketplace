package com.geekymon2.carmarketplace.carimagestoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ImageStoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageStoreServiceApplication.class, args);
	}

}
