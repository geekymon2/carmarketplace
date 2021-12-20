# Car Marketplace

Microservices App for Car Marketplace

## Status

**car-info-service** <br/>
[![build](https://github.com/geekymon2/carmarketplace-car-info-svc/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-car-info-svc/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-car-info-svc/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-car-info-svc) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-car-info-svc) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-car-info-svc)

**car-listing-service** <br/>
[![build](https://github.com/geekymon2/carmarketplace-car-listing-svc/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-car-listing-svc/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-car-listing-svc/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-car-listing-svc) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-car-listing-svc) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-car-listing-svc)

**discovery-server** <br/>
[![build](https://github.com/geekymon2/carmarketplace-discovery-server/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-discovery-server/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-discovery-server/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-discovery-server) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-discovery-server) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-discovery-server)

**config-server** <br/>
[![build](https://github.com/geekymon2/carmarketplace-config-server/actions/workflows/build.yml/badge.svg)](https://github.com/geekymon2/carmarketplace-config-server/actions/workflows/build.yml) &nbsp;&nbsp; [![codecov](https://codecov.io/gh/geekymon2/carmarketplace-config-server/branch/main/graph/badge.svg?token=LH7ATDIHTB)](https://codecov.io/gh/geekymon2/carmarketplace-config-server) &nbsp;&nbsp; ![Docker Image Version (latest by date)](https://img.shields.io/docker/v/geekymon2/cm-config-server) &nbsp;&nbsp; ![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/geekymon2/cm-config-server)

## Related Git Repos

* [carmarketplace-car-orch-svc](https://github.com/geekymon2/carmarketplace-car-orch-svc) - Orchestration Service
* [carmarketplace-car-info-svc](https://github.com/geekymon2/carmarketplace-car-info-svc) - Car Info Services
* [carmarketplace-car-listing-svc](https://github.com/geekymon2/carmarketplace-car-listing-svc) - Car Listing Service
* [carmarketplace-imgstore-svc](https://github.com/geekymon2/carmarketplace-imagestore-svc) - Image Store Service
* [carmarketplace-config-server](https://github.com/geekymon2/carmarketplace-config-server) - Config Server
* [carmarketplace-discovery-server](https://github.com/geekymon2/carmarketplace-discovery-server) - Discovery Server
* [carmarketplace-config](https://github.com/geekymon2/carmarketplace-config) - Configuration

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

## Build
- First build the parent pom. This is needed before others can be built.
  * mvn -f pom.xml install -N


- Build again to also build the core module. Core module is a dependency across other services.
  * mvn -f pom.xml install

- Now you can go and build the services in other repos.