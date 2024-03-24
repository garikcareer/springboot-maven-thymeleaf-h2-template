FROM openjdk:21
LABEL authors="garikcareer@gmail.com"

WORKDIR /app

EXPOSE 8080

ARG JAR_FILE=target/*.jar

VOLUME /tmp
COPY ${JAR_FILE} /app/company-compass.jar
CMD ["java","-jar","/company-compass.jar"]