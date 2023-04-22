FROM eclipse-temurin:17-jdk-alpine
RUN mkdir /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Xmx4g","/app/app.jar"]