FROM java:11
EXPOSE 8080
ADD target/marketplace.jar marketplace.jar
ENTRYPOINT["java","-jar","marketplace.jar"]