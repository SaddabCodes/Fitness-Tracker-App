FROM eclipse-temurin:21-jre

WORKDIR /app

COPY ./target/*.jar fitness-tracker-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "fitness-tracker-app.jar"]
