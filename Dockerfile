FROM eclipse-temurin:17-jdk-jammy

WORKDIR .
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# RUN ./mvnw dependency:resolve
ADD mvn_resolve.sh .
COPY ./src ./src
CMD ./mvn_resolve.sh
# CMD ["./mvnw", "spring-boot:run"]
