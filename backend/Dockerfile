FROM eclipse-temurin:17-jdk-alpine AS build
RUN mkdir /app
COPY --from=build target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Xmx4g","/app/app.jar"]