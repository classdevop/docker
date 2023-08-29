FROM maven:3.8.3-openjdk-8 AS build-env

WORKDIR /app

COPY pom.xml .

# (Optional) If you have a .m2 directory for caching Maven dependencies, copy it to the container
# COPY .m2/ /root/.m2/

RUN mvn dependency:go-offline

COPY src/ src/

RUN mvn package

FROM openjdk:8-jre-slim

WORKDIR /app

COPY --from=build-env /app/target/your-application.jar .
EXPOSE 8080

CMD ["java", "-jar", "your-application.jar"]

