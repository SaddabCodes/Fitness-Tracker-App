FROM eclipse-temurin:latest

WORKDIR /app

COPY ./target/FitnessTrackerApp-0.0.1-SNAPSHOT.jar /app/fitness-tracker-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "fitness-tracker-app.jar"]
