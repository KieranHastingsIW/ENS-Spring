FROM openjdk:17-jdk-slim
ARG JAR_FILE=ens-0.0.1-SNAPSHOT.jar
WORKDIR /opt
COPY target/${JAR_FILE} /opt/ens.jar
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "/opt/ens.jar"]

# FROM maven:3.8.6-eclipse-temurin-17
# WORKDIR /app
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# COPY src ./src
# CMD ["mvn", "clean","spring-boot:run"]