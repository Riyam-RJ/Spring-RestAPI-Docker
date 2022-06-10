#FROM amazoncorretto:11-alpine-jdk
#MAINTAINER webshop-owner
#COPY target/*.jar webshop-backend.jar
#ENTRYPOINT ["java","-jar","/webshop-backend.jar"]

# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.1-amazoncorretto-11 AS MAVEN_BUILD
# copy the pom and src code to the container
COPY ./ ./
# package our application code
RUN mvn clean package
# the second stage of our build will use open jdk 8 on alpine 3.9
FROM amazoncorretto:11-alpine-jdk
# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD target/*.jar webshop-backend.jar
# set the startup command to execute the jar
CMD ["java", "-jar", "/webshop-backend.jar"]