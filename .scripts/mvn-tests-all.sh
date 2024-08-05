#!/bin/bash
mvn -f ../pom.xml clean install
mvn -f ../../carmarketplace-car-info-svc/pom.xml clean test
mvn -f ../../carmarketplace-car-listing-svc/pom.xml clean test
mvn -f ../../carmarketplace-user-svc/pom.xml clean test
#mvn -f ../../carmarketplace-img-store-svc/pom.xml clean test