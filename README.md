# Webshop 

## Introduction

Web application was developed to insert customer and items data into the database and retrieve it over Rest APIs. For the development, below technologies were used.

* Java inbuilt tomcat in Spring Boot – Web Server
* Hibernate/JPA – Object Relational Mapping
* H2DB – Persist data on memory
* Docker – Containerization
* Frontend - Thymeleaf
* JWT Authentication 


## Set up

1. Find your ip adress and place it in "backend.url=http://<ip-address>:18080/" webshop-frontend -> application.properties.

   * To find ip-address get cmd and type "ipconfig" and enter. Then you'll able to see "IPv4 Address. . . . . . . . . . . :"

2. Fire up docker container.
   Navigate to Java-Spring-RestAPI-main folder and enter this command on intellij idea terminal, windows cmd or etc.
   "docker-compose up --build"

3. If you want to stop docker container use docker dekstop application or use following command.
   "docker-compose down"

4. Finally you can access the system using "http://localhost:18085/login"

5. Api Documentation http://localhost:18080/swagger-ui.html#
