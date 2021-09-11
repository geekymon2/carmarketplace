# Car Marketplace

Microservices App for Car Marketplace

## Status

CAR-INFO-SERVICE
[![build](https://github.com/geekymon2/carmarketplace-car-info-svc/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-car-info-svc/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-car-info-svc/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-car-info-svc) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-car-info-svc) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-car-info-svc)

DISCOVERY-SERVER
[![build](https://github.com/geekymon2/carmarketplace-discovery-server/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-discovery-server/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-discovery-server/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-discovery-server) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-discovery-server) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-discovery-server)

CONFIG-SERVER
[![build](https://github.com/geekymon2/carmarketplace-config-server/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-config-server/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-config-server/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-config-server) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-config-server) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-config-server)

## List of Related Repos

* Orchestrator Service - [carmarketplace-car-orch-svc](https://github.com/geekymon2/carmarketplace-car-orch-svc)
    - API interface fro UI.
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