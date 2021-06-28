package com.geekymon2.carmarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CarListingSvcApp {

	public static void main(String[] args) {
		SpringApplication.run(CarListingSvcApp.class, args);
	}

}
