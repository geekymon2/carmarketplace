package com.geekymon2.carmarketplace.carinfoservice;

import com.geekymon2.carmarketplace.carinfoservice.serviceimpl.CarInfoServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication
public class CarInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarInfoServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CarInfoServiceImpl carInfoService() {
		return new CarInfoServiceImpl();
	}

}
