FROM eclipse-temurin:17-jdk-jammy

WORKDIR .
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY ./src ./src
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
CMD ["./mvnw", "spring-boot:run"]
