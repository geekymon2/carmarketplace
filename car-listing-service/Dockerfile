FROM adoptopenjdk/openjdk11
LABEL maintainer="geekymon2@gmail.com"
EXPOSE 8080
ADD target/car-listing-service.jar car-listing-service.jar
ENTRYPOINT ["java","-jar","car-listing-service.jar"]