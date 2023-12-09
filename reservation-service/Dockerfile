FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base
EXPOSE 8093
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} reservationservice.jar

ENTRYPOINT ["java","-jar","/reservationservice.jar"]