# Car Marketplace Microservices App

[![Build carmarketplace services](https://github.com/geekymon2/carmarketplace/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace/actions/workflows/build.yml)


## This Application contains the following microservices.

* Car Orchestrator
* Car Info Services
    - Provides a read only store of various car makes, models, and types, connects to the database to fetch the car makes and models information
* Car Listing Service
    - Provides a listing of cars as well as the CRUD operations to add, update, delete car listings.
* Image Store Service
    - Service to manage car photos

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