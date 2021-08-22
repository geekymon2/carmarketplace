# Car Marketplace Microservices App

## This Application contains the following microservices.

* Car Orchestrator
* Car Info Services
    - Provides a read only store of various car makes and models, connects to the database to fetch the car makes and models information
* Car Listing Service
* Image Store Service

## Technologies Used
* Spring Boot
* Spring Cloud
* JUnit 5
* SpringFox Swagger2 3.0
* Model Mapper 2.4
* Java 11

## Features
* H2 database for running in test profile for execution of integration testing
* JUnit 5 for unit and integration testing
* Netflix Discovery service for automatic service discovery
* Spring Cloud Config Server for centralised config
* Swagger is included in all services