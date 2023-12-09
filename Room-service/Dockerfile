FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} roomservice.jar

ENTRYPOINT ["java","-jar","/roomservice.jar"]