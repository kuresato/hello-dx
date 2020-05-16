#FROM maven:3.6-jdk-8-alpine AS builder
FROM maven:3.6-jdk-8-alpine
ARG MAVEN_OPTS
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -e -B package
CMD ["java", "-jar", "/app/target/demo-0.0.1-SNAPSHOT.jar"]

#FROM openjdk:8-jre-alpine
#COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar /
#CMD ["java", "-jar", "/app/target/demo-0.0.1-SNAPSHOT.jar"]

CMD ["java", "-jar", "/app/target/demo-0.0.1-SNAPSHOT.jar"]

