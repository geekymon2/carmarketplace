FROM adoptopenjdk/openjdk11
LABEL maintainer="geekymon2@gmail.com"
EXPOSE 8080
ADD target/car-info-service*.jar car-info-service.jar
ENTRYPOINT ["java","-jar","car-info-service.jar"]