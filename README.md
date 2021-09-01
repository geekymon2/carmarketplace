# Car Marketplace Microservices App

[![Build carmarketplace services](https://github.com/geekymon2/carmarketplace/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace/actions/workflows/build.yml)


## List of Related Repos

* Orchestrator Service - [carmarketplace-car-orch-svc](https://github.com/geekymon2/carmarketplace-car-orch-svc)
* Car Info Services - [carmarketplace-car-info-svc](https://github.com/geekymon2/carmarketplace-car-info-svc)
    - Provides a read only store of various car makes, models, and types, connects to the database to fetch the car makes and models information
* Car Listing Service - [carmarketplace-car-listing-svc](https://github.com/geekymon2/carmarketplace-car-listing-svc)
    - Provides a listing of cars as well as the CRUD operations to add, update, delete car listings.
* Image Store Service - [carmarketplace-imgstore-svc](https://github.com/geekymon2/carmarketplace-imagestore-svc)
    - Service to manage car photos
* Config Server - [carmarketplace-config-server](https://github.com/geekymon2/carmarketplace-config-server)
    - Centralised Configuration Management
* Eureka Discovery Server - [carmarketplace-discovery-server](https://github.com/geekymon2/carmarketplace-discovery-server)
    - Discovery Server

## Technologies Used
* Spring Boot
* Spring Cloud
* JUnit 5
* SpringFox Swagger2
* Model Mapper
* Java 11
* Lombok
* Jacoco Code Coverage

## Features
* H2 database for running in test profile for execution of integration testing
* JUnit 5 for unit and integration testing
* Netflix Discovery service for automatic service discovery
* Spring Cloud Config Server for centralised config
* Swagger is included in all services