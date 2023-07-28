FROM openjdk:8
WORKDIR /app
EXPOSE 8080
COPY /build/libs/circleci-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]