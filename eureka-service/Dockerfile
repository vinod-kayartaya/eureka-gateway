FROM openjdk:17-alpine
WORKDIR /app
COPY target/eureka-service-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]