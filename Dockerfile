FROM openjdk:21
LABEL authors="garikcareer@gmail.com"

WORKDIR /company-compass

EXPOSE 8080

VOLUME /tmp
COPY target/*.jar company-compass.jar
ENTRYPOINT ["java","-jar","/company-compass.jar"]