FROM maven:3.6-jdk-11-slim AS builder
ARG MAVEN_OPTS
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -e -B package

FROM openjdk:11-jre-slim
COPY --from=builder /app/target/hello-dx-0.0.1-SNAPSHOT.jar /
CMD ["java", "-jar", "/hello-dx-0.0.1-SNAPSHOT.jar"]
