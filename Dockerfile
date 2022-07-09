FROM openjdk:17-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre

LABEL name="Helloappjava"
LABEL version="1.1.0"
LABEL description="Helloapp built with Java and Spring Boot for testing and POC purpose"

COPY target/*.jar app.jar

# Launch application
ENTRYPOINT ["java","-jar","/app.jar"]
