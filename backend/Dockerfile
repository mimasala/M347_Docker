FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
#ENTRYPOINT ["java -Dspring.datasource.url=${SPRING_DATASOURCE_URL}","-jar","/app.jar"]
ENTRYPOINT ["java","-jar", "-Xmx4g","/app.jar"]