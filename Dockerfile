FROM maven:3.8.5-openjdk-17 AS Build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=Build /target/AIML-Odyssey-0.0.1-SNAPSHOT.jar AIML-Odyssey.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "AIML-Odyssey.jar"]