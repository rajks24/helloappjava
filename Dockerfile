FROM openjdk:17-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre

LABEL "title"="Helloappjava"
LABEL "version"="1.1.0"
LABEL "author"="Rajesh Singh"
LABEL "description"="Helloapp built with Java and Spring Boot for testing and POC purpose"
LABEL "source"="https://github.com/rajks24/helloappjava.git"

COPY target/*.jar app.jar

# Launch application
ENTRYPOINT ["java","-jar","/app.jar"]
