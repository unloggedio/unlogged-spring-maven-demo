FROM eclipse-temurin:17-jdk-jammy

WORKDIR .
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY ./src ./src
RUN sleep 10
CMD ["./mvnw", "spring-boot:run"]
