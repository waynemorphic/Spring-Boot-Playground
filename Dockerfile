FROM eclipse-temurin:17-jre-alpine
WORKDIR /Spring-Boot-Playground
EXPOSE 8080
ADD /target/REST-demo-0.0.1-SNAPSHOT.jar rest-playground.jar
CMD ["java", "-jar", "rest-playground.jar"]
LABEL authors="Wayne"